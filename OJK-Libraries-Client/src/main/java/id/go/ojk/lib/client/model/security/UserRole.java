package id.go.ojk.lib.client.model.security;

public enum UserRole {
	ojk ("OJK"),
	ljkOffline ("LJK - Offline"),
	ljkOnline ("LJK - Online");

	private String description;

	private UserRole(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
