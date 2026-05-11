package id.go.ojk.client.constant;

public enum ExtensionType {

    TXT(".txt"),
    PDF(".pdf"),
    NONE("...")

    ;

    private final String extension;

    ExtensionType(String extension) {
        this.extension = extension;
    }

    public String getType() {
        return extension;
    }
}
