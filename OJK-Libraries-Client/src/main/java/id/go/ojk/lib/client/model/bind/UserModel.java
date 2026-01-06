package id.go.ojk.lib.client.model.bind;

import id.go.ojk.lib.client.model.security.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;

public class UserModel {

	@Getter private User user;

	public final StringProperty numberProperty = new SimpleStringProperty();
	public final StringProperty userLoginIdProperty = new SimpleStringProperty();
	public final StringProperty userNameProperty = new SimpleStringProperty();
	public final StringProperty roleProperty = new SimpleStringProperty();
	public final StringProperty roleDescProperty = new SimpleStringProperty();

	public final StringProperty passwordProperty = new SimpleStringProperty();
	public final StringProperty rePasswordProperty = new SimpleStringProperty();

	public UserModel(){
	}

	public UserModel(int number, User user){
		numberProperty.set(number + "");
		this.user = user;
		if ( user != null  ){
			userLoginIdProperty.set(user.getUserLoginId());
			userNameProperty.set(user.getUserName());
			roleProperty.set(user.getRole().name());
			roleDescProperty.set(user.getRole().getDescription());
		}
	}

	public UserModel cloneQuietly(){
		return new UserModel(Integer.parseInt(numberProperty.get()), user);
	}

	public User toUser(){
		return User.builder()
			.userLoginId(userLoginIdProperty.get())
			.userName(userNameProperty.get())
			.jobPosition("")
			.password(passwordProperty.get())
			.build();
	}

}
