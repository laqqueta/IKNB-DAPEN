package id.go.ojk.util.constants;

public enum ExtensionType {

    TXT(".txt"),
    PDF(".pdf"),
    NONE("...")

    ;

    private final String extension;

    ExtensionType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
