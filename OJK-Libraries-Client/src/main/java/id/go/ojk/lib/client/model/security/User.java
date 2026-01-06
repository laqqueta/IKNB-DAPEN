package id.go.ojk.lib.client.model.security;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@XStreamAlias("user")
@Builder
@Data
public class User {

	private String userLoginId;
	private String userName;
	private String jobPosition;

	//@XStreamOmitField
	private String password;	

	private Boolean changePassword;
	private String passwordHash;
	private UserRole role;
	private List<String> appAccess;
	private long lastChangePassword ;
	private List<String> lastPassword;
	

	@Tolerate
	public User(){
	}

	@Tolerate
	public User(String userLoginId, String userName, String jobPosition, String passwordHash, UserRole role, String password, boolean changePassword, List<String> appAccess){
		this.userLoginId = userLoginId;
		this.userName = userName;
		this.jobPosition = jobPosition;
		this.passwordHash = passwordHash;
		this.role = role;
		this.password = password;
		this.changePassword = changePassword;
		this.appAccess = appAccess;
		this.lastChangePassword = 0;
	}
	
	public boolean isNeedChangePassword(int pwdExpirationPeriod) {
		return !changePassword || isPasswordExpired(pwdExpirationPeriod);
	}
	
	public boolean isPasswordExpired(int pwdExpirationPeriod) {
		long days = TimeUnit.DAYS.convert(System.currentTimeMillis() - lastChangePassword, TimeUnit.MILLISECONDS);
		return changePassword && days > pwdExpirationPeriod;
	}
	
	public List<String> validatePassword(String newPassword) {
		List<String> res = new ArrayList<>();
		if (!checkLastUsedPassword(newPassword)) {
			res.add("Password baru tidak boleh sama dengan 3 password terakhir.");
		}
		if (!checkOldPassword(newPassword)) {
			res.add("Password baru tidak boleh mirip dengan password lama.");
		}
		return res;
	}
	
	private boolean checkLastUsedPassword(String newPassword) {
		if (lastPassword != null && lastPassword.contains(newPassword)) {
			return false;
		}
		return true;
	}
	
	private boolean checkOldPassword(String newPassword) {
		if (lastPassword == null || lastPassword.isEmpty()) {
			return true;
		}
		String oldPassword = lastPassword.get(lastPassword.size() - 1);
		if (newPassword.length() != oldPassword.length()) {
			return true;
		} else if (isIdentic(oldPassword, newPassword)) {
			return false;
		}
		return true;
	}
	
	private boolean isIdentic(String oldPassword, String newPassword) {
		int diff = 0;
		for (int i = 0; i < oldPassword.length(); i++) {
			if (oldPassword.charAt(i) != newPassword.charAt(i)) {
				diff++;
			}
		}
		return diff < 3;
	}
	
	public void addLastPassword(String newPassword) {
		if (lastPassword == null) {
			lastPassword = new ArrayList<>();
		} else if (lastPassword.size() >= 3) {
			lastPassword.remove(0);
		}
		lastPassword.add(newPassword);
	}

	//~ getter setter

	public boolean isOnlineUser() {
		return role == UserRole.ojk || role == UserRole.ljkOnline;
	}

	public User cloneQuietly() {
		try {
			return clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return this;
		}
	}

	@Override
	public User clone() throws CloneNotSupportedException {
		User cloned = new User();
		cloned.setUserLoginId(userLoginId);
		cloned.setUserName(userName);
		cloned.setJobPosition(jobPosition);
		cloned.setPassword(password);
		cloned.setChangePassword(changePassword);
		cloned.setPasswordHash(passwordHash);
		cloned.setRole(role);
		cloned.setAppAccess(appAccess);
		return cloned;
	}

}
