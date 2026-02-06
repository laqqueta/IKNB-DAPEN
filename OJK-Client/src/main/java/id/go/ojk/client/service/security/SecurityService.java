package id.go.ojk.client.service.security;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

import javax.crypto.Cipher;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;

import com.google.common.collect.ImmutableMap;

import id.go.ojk.client.ClientProperties;
import id.go.ojk.client.MainApplication;
import id.go.ojk.client.api.ApiLogin;
import id.go.ojk.client.api.ApiLogout;
import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.dto.DtoLoginRequest;
import id.go.ojk.client.dto.DtoLoginResponse;
import id.go.ojk.client.dto.DtoLoginResponseData;
import id.go.ojk.client.dto.DtoLogoutRequest;
import id.go.ojk.client.service.ApplicationUpdateService;
import id.go.ojk.client.service.HttpService;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.UserService;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.client.service.ftp.FtpService;
import id.go.ojk.client.service.impl.ReferenceServiceClient;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.lib.client.EncryptionUtil;
import id.go.ojk.lib.client.HttpUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.DtoVersion;
import id.go.ojk.lib.client.model.bind.UserLoginModel;
import id.go.ojk.lib.client.model.constant.ClientTypeFlag;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import id.go.ojk.lib.client.model.security.AuthenticationStatus;
import id.go.ojk.lib.client.model.security.User;
import id.go.ojk.lib.client.model.security.UserRole;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.security.BCryptPasswordEncoder;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class SecurityService extends BaseService {
	private UserSession userSession;
	private Map<String, Object> loginRequest;
	private final UserLoginModel userLoginModel = new UserLoginModel();

	public boolean useApi() {
		return EReport.useLoginApi(userSession.getReportCode());
	}

	public UserSession authenticate(String userId, String password, String report, boolean onlyOfflineUser) {
		UserSession res = null;
		if (EReport.useLoginApi(report)) {
			res = authOnline(userId, password, report);
		}
		if (res == null || res.getAuthenticationStatus() == null
				|| res.getAuthenticationStatus() == AuthenticationStatus.networkOffline) {
			res = autenticateOffline(userId, password, report, onlyOfflineUser);
		}
		return res;
	}

	public boolean reAuthOnline(String userId, String password) {
		log.info("auth online={}", userId);
		ApiLogin api = new ApiLogin();
		try {
			DtoLoginResponse dtoResponse = api.sendReceive(getLoginRequest(userId, password));
			if (dtoResponse == null) {
				log.error("ReLogin online failed");
			}
			if (api.isSucceed(dtoResponse)) {
				DtoLoginResponseData dtoData = dtoResponse.getData();
				userSession.setPlainPassword(password);
				userSession.setUser(getUser(dtoResponse, userId, password));
				userSession.setSessionId(dtoData.getToken());
				userSession.setSessionExpirationDate(dtoData.getExpirationDateMillis());
				userSession.setVersion(new DtoVersion(dtoData.getVersionSetup(), dtoData.getVersionMetadata(),
						dtoData.getVersionReference(), dtoData.getVersionApplication()));
				return true;
			} else {
				log.error("ReLogin online failed:{}", dtoResponse);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	public UserSession authOnline(String userId, String password, String report) {
		log.info("auth online={}", userId);
		UserSession res = new UserSession();
		res.setPlainPassword(password);
		ApiLogin api = new ApiLogin();
		try {
			DtoLoginResponse dtoResponse = api.sendReceive(getLoginRequest(userId, password));
			if (api.isNoResponse(dtoResponse)) {
				log.error("Login online failed ", dtoResponse);
				res.setAuthenticationStatus(null);
				return res;
			}
			if (dtoResponse.isSucceed()) {
				DtoLoginResponseData dtoData = dtoResponse.getData();
				res.setAuthenticationStatus(AuthenticationStatus.onlineAuthenticate);
				res.setUser(getUser(dtoResponse, userId, password));
				res.setSessionId(dtoData.getToken());
				res.setSessionExpirationDate(dtoData.getExpirationDateMillis());
				res.setVersion(new DtoVersion(dtoData.getVersionSetup(), dtoData.getVersionMetadata(),
						dtoData.getVersionReference(), dtoData.getVersionApplication()));
				User localUser = userService.getUser(userId);
				res.getUser().setUserName(localUser.getUserName());
				List<String> appAccess = localUser.getAppAccess();
				if (appAccess != null && appAccess.contains(report.split("[|]")[0])) {
					res.setReportCode(report.split("[|]")[1]);
				}
				setUserSession(res);
				updateLocalUser(localUser, userId, password);
			} else {
				log.error("Login online failed:{}", dtoResponse);
				res.setAuthenticationStatus(AuthenticationStatus.notAuthenticate);
				res.setErrorMessage(dtoResponse.getResponseMessage());
			}
		} catch (Exception e) {
			res.setAuthenticationStatus(AuthenticationStatus.networkOffline);
			log.error(e.getMessage(), e);
		}
		return res;
	}

	private DtoLoginRequest getLoginRequest(String userId, String password) {
		DtoLoginRequest res = new DtoLoginRequest();
		res.setMemberCode(setupService.getMemberCode());
		res.setMemberTypeCode(setupService.getMemberTypeCode());
		res.setPassword(password);
		res.setUserId(userId);
		res.setUserTypeFlag(setupService.getClientTypeFlag().name());
		if (ClientTypeFlag.E == setupService.getClientTypeFlag()) {
			res.setMemberCode(setupService.getMemberCode());
			res.setMemberTypeCode(setupService.getMemberTypeCode());
		}
		return res;
	}

	private User getUser(DtoLoginResponse dtoResponse, String userId, String password) {
		return User.builder().userLoginId(userId).userName(dtoResponse.getData().getUserName()).jobPosition("")
				.passwordHash(passwordEncoder.encode(password))
				.role(setupService.getClientTypeFlag() == ClientTypeFlag.I ? UserRole.ojk : UserRole.ljkOnline).build();
	}

	@SneakyThrows
	private void updateLocalUser(User user, String userId, String password) {
		user.setPassword(password);
		user.setPasswordHash(encodePassword(password));
		user.setChangePassword(Boolean.TRUE);
		user.setLastChangePassword(System.currentTimeMillis());
		userService.updateUserOffline(user);
	}

	public UserSession getUserSession() {
		return userSession;
	}

	private void setUserSession(UserSession userSession) {
		this.userSession = userSession;
		if (isLogin()) {
			if (setupService.getClientTypeFlag() == ClientTypeFlag.E) {
				userLoginModel.setUserSession(userSession, setupService.getMemberName(),
						setupService.getMemberTypeCode() + " - " + setupService.getMemberTypeName());
			} else {
				userLoginModel.setUserSession(userSession, "", "");
			}

		} else {
			userLoginModel.setUserSession(userSession, "", "");
		}
	}

	public UserLoginModel getUserLoginModel() {
		return userLoginModel;
	}

	public boolean isLogin() {
		return userSession != null && userSession.isAuthenticated();
	}

	public boolean isOnlineLogin() {
		return isLogin() && userSession.isOnline();
	}

	public boolean isOjkLogin() {
		return isLogin() && userSession.isOnline() && userSession.getUser().getRole() == UserRole.ojk;
	}

	public void logout() throws ClientProtocolException, IOException, URISyntaxException {
		try {
			if (isOnlineLogin() && !useApi()) {
				cleanUpConnectionCheck();
				httpService.logout();
			} else if (useApi()) {
				ApiLogout api = new ApiLogout();
				api.sendReceive(new DtoLogoutRequest());
			}
		} finally {
			setUserSession(null);
			loginRequest = null;
		}
	}

	public synchronized Map<String, Object> relogin() throws ClientProtocolException, IOException {
		return relogin(true);
	}

	public synchronized Map<String, Object> relogin(boolean testHeartbeat) throws ClientProtocolException, IOException {
		if (testHeartbeat) {
			Map<String, Object> heartbeatResponse;
			try {
				heartbeatResponse = httpService.sendHeartbeat();
				int heartbeatStatus = HttpUtil.getStatus(heartbeatResponse);
				if (heartbeatStatus == 200) {
					return heartbeatResponse;
				}
			} catch (URISyntaxException e) {
				throw new SlikException("", e);
			}
		}
		Map<String, Object> serverResponse = httpService.postMapReturnJsonMap(httpService.getLoginUrl(), loginRequest,
				false);
		if (HttpUtil.isSuccessResponse(serverResponse)) {
			Map<String, Object> payload = HttpUtil.getPayload(serverResponse);
			userSession.setSessionId((String) payload.get("sessionId"));
		}

		return serverResponse;
	}

	private Map<String, Object> constructLoginRequest(String userLoginId, String password) {
		Map<String, String> clientVersion = applicationUpdateService.getClientVersion();

		ImmutableMap.Builder<String, Object> paramBuilder = ImmutableMap.<String, Object>builder()
				.put("userLoginId", userLoginId).put("password", password)
				.put("userTypeFlag", setupService.getClientTypeFlag().name()).put("clientVersion", clientVersion);

		if (ClientTypeFlag.E == setupService.getClientTypeFlag()) {
			paramBuilder.put("memberTypeCode", setupService.getMemberTypeCode()).put("memberCode",
					setupService.getMemberCode());
		}

		final Map<String, Object> m = paramBuilder.build();
		return m;
	}

	public UserSession autenticateOnline(String userLoginId, String password, String report) {
		userLoginId = userLoginId.toLowerCase();
		UserSession result = null;
		result = new UserSession();
		result.setPlainPassword(password);

		final Map<String, Object> m = constructLoginRequest(userLoginId, password);

		try {
			String loginUrl = httpService.getLoginUrl();
			logger.info("authenticate to " + loginUrl);
			Map<String, Object> map = httpService.postMapReturnJsonMap(loginUrl, m, false);
			if (map != null) {
				Integer status = (Integer) map.get("status");
				if (status == HttpStatus.SC_OK) {
					Map<String, Object> payload = (Map<String, Object>) map.get("payload");

					result.setAuthenticationStatus(AuthenticationStatus.onlineAuthenticate);

					User user = User.builder().userLoginId(userLoginId.toLowerCase())
							.userName((String) payload.get("userName")).jobPosition("")
							.passwordHash(passwordEncoder.encode(password))
							.role(setupService.getClientTypeFlag() == ClientTypeFlag.I ? UserRole.ojk
									: UserRole.ljkOnline)
							.build();
					result.setUser(user);
					result.setSessionId((String) payload.get("sessionId"));
					result.setLoginOnlineResponse(payload);

					setupService.loginOnlineSuccess(result);
					referenceService.loginOnlineSuccess(result);
					if (user.getAppAccess() != null && user.getAppAccess().contains(report.split("[|]")[0])) {
						result.setReportCode(report.split("[|]")[1]);
					}

					setUserSession(result);
					loginOnlineSuccess();

					loginRequest = m;
				} else if (status == HttpStatus.SC_UNAUTHORIZED) {
					result.setErrorMessage(HttpUtil.getMessage(map));
				}
			} else {
				result.setAuthenticationStatus(AuthenticationStatus.notAuthenticate);
			}

		} catch (Exception e) {
			result.setAuthenticationStatus(AuthenticationStatus.networkOffline);
			logger.warn("", e);
		}

		return result;
	}

	public UserSession autenticateOffline(String userLoginId, String password, String report, boolean onlyOfflineUser) {
		userLoginId = userLoginId.toLowerCase();
		UserSession result = new UserSession();
		result.setPlainPassword(password);
		User user = userService.getUser(userLoginId);
		if (user == null)
			return result;

		if (onlyOfflineUser && user.isOnlineUser()) {
			return result;
		}
		user = user.cloneQuietly();
		result.setUser(user);
		if (cekPassword(user, password)) {
			result.setAuthenticationStatus(AuthenticationStatus.offlineAuthenticate);
			result.setSessionId("offline");
			result.setLoginDate(LocalDateTime.now());
//			List<String> appAccess = user.getAppAccess();					// TESTING AKSES LBBPRK
//			appAccess.add("2349");											// TESTING AKSES LBBPRK
//			if(appAccess.contains(report.split("[|]")[0])) {				// TESTING AKSES LBBPRK
			List<String> appAccess = user.getAppAccess();
			if (appAccess != null && appAccess.contains(report.split("[|]")[0])) {
				result.setReportCode(report.split("[|]")[1]);
			}
			setUserSession(result);
		}

		return result;
	}

	public boolean cekUserName(String userName) {
		userName = userName.toLowerCase();
		User user = userService.getUser(userName);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}

	public String maskingPassword(String userName) {
		userName = userName.toLowerCase();
		User user = userService.getUser(userName);
		String password = user.getPassword();
		StringBuffer maskPassword = new StringBuffer();

		for (int i = 0; i < password.length(); i++) {
			if (i == 0 || i == (password.length() - 1) || i == (password.length() - 2)) {
				maskPassword.append(password.charAt(i));
			} else {
				maskPassword.append("*");
			}
		}

		return maskPassword.toString();
	}

	public boolean isChangePassword(String userName) {
		userName = userName.toLowerCase();
		User user = userService.getUser(userName);
		return !user.isNeedChangePassword(
				ClientProperties.getInstance().getValueAsInt(ClientProperties.PWD_EXPIRATION_PERIOD, 90));
	}

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public boolean cekPassword(User user, String plainPassword) {
		return passwordEncoder.matches(plainPassword, user.getPasswordHash());
	}

	public boolean cekUserLoginPassword(String plainPassword) {
		User user = userService.getUser(getUserSession().getUser().getUserLoginId());
		return passwordEncoder.matches(plainPassword, user.getPasswordHash());
	}

	public boolean validateComplexPassword(List<String> errors, String plainPassword) {
		String passwordRegex = referenceService.getConfig(ReferenceService.passwordRegex);

		if (!Pattern.matches(passwordRegex, plainPassword)) {
			errors.add(referenceService.getConfig(ReferenceService.passwordErrorMessage));
			return false;
		}
		return true;
	}

	public String encodePassword(String plainPassword) {
		return passwordEncoder.encode(plainPassword);
	}

	// ~ connection test
	private Timer timer;
	private TimerTask timerTask;

	private void loginOnlineSuccess() {
		cleanUpConnectionCheck();
		timer = new Timer("connectionCheck");
		if (timerTask == null) {
			timerTask = new TimerTask() {
				@Override
				public void run() {
					try {
						mainApplication.getRootLayoutController().updateConnectionStatus(null);

						Map<String, Object> result = httpService.sendHeartbeat();
						if (HttpUtil.isSuccessResponse(result)) {
							mainApplication.getRootLayoutController()
									.updateConnectionStatus(ftpService.sendConnectionTest());
						}
					} catch (Exception e) {
						logger.info("fail check connection", e);
						mainApplication.getRootLayoutController().updateConnectionStatus(false);
					}
				}
			};
		}

		timer.schedule(timerTask, OjkClientConstant.checkConnectionDelayMs, OjkClientConstant.checkConnectionRateMs);
	}

	private void cleanUpConnectionCheck() {
		if (timer != null) {
			timer.cancel();
			timer.purge();
		}
		timer = null;
		timerTask = null;
	}

	public String getMemberStaticKey(String memberTypeCode, String memberCode)
			throws ClientProtocolException, IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("memberTypeCode", memberTypeCode);
		param.put("memberCode", memberCode);
		String encrypted = httpService.postMapReturnString(httpService.getOjkMemberStaticAttribute(), param, true);

		String decrypted = new String(
				EncryptionUtil.aesEncryption(Cipher.DECRYPT_MODE, HomeController.sendingLabel, encrypted.getBytes()));
		return decrypted;
	}
	
	public String getResetPasswordInstruction() {
	  StringBuilder sb = new StringBuilder("1. Silahkan menuju ke pelaporan.id\n")
        .append("2. Pada halaman login silahkan klik link Lupa Password dibawah input Password\n")
        .append("3. Masukkan email terdaftar dan isi captcha\n")
        .append("4. Klik submit, jika sukses akan muncul notifikasi sukses dan email untuk reset password akan terkirim");
	  return sb.toString();
	}
	
	public String getChangePasswordInstruction() {
	  StringBuilder sb = new StringBuilder("1. Silahkan login ke pelaporan.id\n")
        .append("2. Setelah login, klik nama pengguna di pojok kanan atas\n")
        .append("3. Pilih menu ubah password\n")
        .append("4. Ikuti petunjuk dan ketentuan ubah password, lalu klik Ubah");
    return sb.toString();
	}

	// ~ service

	private SetupService setupService;
	private HttpService httpService;
	private FtpService ftpService;
	private UserService userService;
	private ApplicationUpdateService applicationUpdateService;
	private ReferenceServiceClient referenceService;
	private MainApplication mainApplication;

	@Override
	public void initialize() {
		this.setupService = appContext.getService(SetupService.class);
		this.httpService = appContext.getService(HttpService.class);
		this.ftpService = appContext.getService(FtpService.class);
		this.userService = appContext.getService(UserService.class);
		this.applicationUpdateService = appContext.getService(ApplicationUpdateService.class);
		this.mainApplication = appContext.getService(MainApplication.class);
		this.referenceService = (ReferenceServiceClient) appContext.getService(ReferenceService.class);
	}

}
