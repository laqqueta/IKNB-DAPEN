package id.go.ojk.util.constants;

public enum ProgramType {

    PPMPK("PPMP Kompleks"),
    PPMPM("PPMP Murni"),
    PPIPK("PPIP Kompleks"),
    PPIPM("PPIP Kopmpleks"),
    PPMPPPIPK("PPMPPPIP Kompleks"),

    ALL("ALL")
    ;

    private final String detail;

    ProgramType(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
}
