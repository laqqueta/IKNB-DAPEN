package id.go.ojk.client.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import id.go.ojk.client.api.ApiChangePassword;
import id.go.ojk.client.dto.DtoChangePasswordRequest;
import id.go.ojk.client.dto.DtoChangePasswordResponse;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.lib.client.HttpUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.bind.UserModel;
import id.go.ojk.lib.client.model.security.User;
import id.go.ojk.lib.client.model.security.UserRole;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserService extends BaseService {

	private SetupService setupService;
	private SecurityService securityService;
	private HttpService httpService;

	@Override
	public void initialize() {
		setupService = appContext.getService(SetupService.class);
		securityService = appContext.getService(SecurityService.class);
		httpService = appContext.getService(HttpService.class);
	}

    public ObservableList<UserModel> getUserModels() {
    	Map<String, User> userMap = setupService.getUserMap();
    	ObservableList<UserModel> userModels = FXCollections.observableArrayList();

    	int counter = 0;
    	for (Entry<String, User> entry : userMap.entrySet()) {
    		userModels.add(new UserModel(++counter, entry.getValue()));
		}

        return userModels;
    }

	public User getUser(String userLoginId){
		return setupService.getUserMap().get(userLoginId.toLowerCase());
	}

	public boolean isUserExist(String userLoginId){
		return getUser(userLoginId) != null;
	}

	public User addUserOffline(User user) throws NoSuchAlgorithmException, IOException, ArchiveException{
		user.setPasswordHash( securityService.encodePassword(user.getPassword()));
		user.setRole(UserRole.ljkOffline);
		setupService.getUserMap().put(user.getUserLoginId().toLowerCase(), user);
		setupService.persist();
		return user;
	}

	public User updateUserOffline(User user) throws NoSuchAlgorithmException, IOException, ArchiveException{
		User dbUser = getUser(user.getUserLoginId());
		dbUser.setUserName(user.getUserName());
		if ( StringUtils.isNotEmpty(user.getPassword()) ) {
			dbUser.setPasswordHash( securityService.encodePassword(user.getPassword()));
		}
		setupService.persist();
		return dbUser;
	}

	public boolean deleteUserOffline(User user) throws NoSuchAlgorithmException, IOException, ArchiveException{
		String userLoginId = user.getUserLoginId().toLowerCase();
		User dbUser = getUser(userLoginId);
		if ( dbUser.isOnlineUser() )
			throw new SlikException("User online tidak dapat di hapus!");
		boolean result = setupService.getUserMap().remove(userLoginId) != null;
		setupService.persist();
		return result;
	}

	public Tupple2<Boolean, String> changeMyPassword(String oldPassword, String newPassword) throws NoSuchAlgorithmException, IOException, ArchiveException{
		String userId = securityService.getUserSession().getUser().getUserLoginId();
		boolean isReset = newPassword.equals(userId);
		if( securityService.isOnlineLogin() ){
			Map<String, String> request = new HashMap<>();
			request.put("oldPassword", oldPassword);
			request.put("newPassword", newPassword);
			Map<String, Object> response = httpService.postMapReturnJsonMap(httpService.getChangePasswordUrl(), request, true);
			if ( !HttpUtil.isSuccessResponse(response) ){
				return Tupple2.<Boolean, String>builder().a(false).b(HttpUtil.getMessage(response)).build();
			}
		}
		User user = getUser(userId);
		user.setPasswordHash(securityService.encodePassword(newPassword));
		user.setPassword(newPassword);
		user.setChangePassword(!isReset);
		if (!isReset) {
			user.addLastPassword(newPassword);
		}
		user.setLastChangePassword(isReset ? 0 : System.currentTimeMillis());
		setupService.persist();
		return Tupple2.<Boolean, String>builder().a(true).b(null).build();
	}

	public boolean changePassword(String oldPassword, String newPassword) throws NoSuchAlgorithmException, IOException, ArchiveException{
		String userId = securityService.getUserSession().getUser().getUserLoginId();
		boolean isReset = newPassword.equals(userId);
		if( securityService.isOnlineLogin() ){
			DtoChangePasswordRequest dtoRequest = new DtoChangePasswordRequest();
			dtoRequest.setNewPassword(newPassword);
			dtoRequest.setPassword(oldPassword);
			dtoRequest.setToken(securityService.getUserSession().getSessionId());
			dtoRequest.setUserId(userId);
			DtoChangePasswordResponse dtoResponse = new ApiChangePassword().sendReceive(dtoRequest);
			if (dtoResponse != null && !dtoResponse.isSucceed()){
				return false;
			}
		}
		User user = getUser(userId);
		user.setPasswordHash(securityService.encodePassword(newPassword));
		user.setPassword(newPassword);
		user.setChangePassword(!isReset);
		if (!isReset) {
			user.addLastPassword(newPassword);
		}
		user.setLastChangePassword(isReset ? 0 : System.currentTimeMillis());
		setupService.persist();
		return true;
	}

	//~ persistence

	public HashMap<String, User> readXStream(File file){
		XStream xstream = instanceStream();
		HashMap<String, User> dataMap = (HashMap<String, User>) xstream.fromXML(file);
		return dataMap;
	}

	@Deprecated
	public HashMap<String, User> toMap(List<User> users) {
		HashMap<String, User> tmpMap = new HashMap<>();
		for (User user : users) {
			tmpMap.put(user.getUserLoginId(), user);
		}
		return tmpMap;
	}

	@Deprecated
	public void saveXStream(File file, List<User> users) {
		saveXStream(file, toMap(users));
	}

	@Deprecated
	public void saveXStream(File file, HashMap<String, User> dataMap) {
		file.getParentFile().mkdirs();
		XStream xstream = instanceStream();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			xstream.toXML(dataMap, fos);
		} catch (FileNotFoundException e) {
			throw new SlikException("", e);
		} finally {
			IOUtils.closeQuietly(fos);
		}
	}

	public XStream instanceStream(){
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(
				new Class[]{
					User.class
				}
			);
		return xstream;
	}

}
