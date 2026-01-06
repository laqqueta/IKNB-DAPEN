package id.go.ojk.lib.client.model.bind;

import id.go.ojk.lib.client.model.security.UserRole;
import id.go.ojk.lib.client.model.security.UserSession;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserLoginModel {
	public final BooleanProperty isLoginProperty = new SimpleBooleanProperty();
	public final BooleanProperty isLoginOnlineProperty = new SimpleBooleanProperty();
	public final BooleanProperty isMemberProperty = new SimpleBooleanProperty();
	public final BooleanProperty isOnlineUser = new SimpleBooleanProperty();

	public final StringProperty userNameProperty = new SimpleStringProperty();
	public final StringProperty userRoleProperty = new SimpleStringProperty();
	public final StringProperty loginOnlineStatusProperty = new SimpleStringProperty();
	public final StringProperty memberProperty = new SimpleStringProperty();
	public final StringProperty memberTypeProperty = new SimpleStringProperty();

	public UserLoginModel(){
	}

	public void reset(){
		isLoginProperty.set(false);
		isLoginOnlineProperty.set(false);
		isMemberProperty.set(false);

		userNameProperty.set("");
		memberProperty.set("");
		memberTypeProperty.set("");
	}

	public void setUserSessionSafe(UserSession userSession, String member, String memberType){
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	setUserSession(userSession, member, memberType);
		    }
		});
	}

	public void setUserSession(UserSession userSession, String member, String memberType){
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
				if ( userSession == null || !userSession.isAuthenticated()) {
					reset();
				} else {
					isLoginProperty.set(true);
					isLoginOnlineProperty.set(userSession.isOnline());
					isMemberProperty.set(userSession.getUser().getRole() != UserRole.ojk);
					isOnlineUser.set(userSession.getUser().isOnlineUser());

					userNameProperty.set(userSession.getUser().getUserName());

					userRoleProperty.set(userSession.getUser().getRole().getDescription());
					loginOnlineStatusProperty.set(userSession.isOnline() ? "Online" : "Offline");

					memberProperty.set(member);
					memberTypeProperty.set(memberType);
				}
		    }
		});
	}

}
