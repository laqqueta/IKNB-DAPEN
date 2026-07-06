package id.go.ojk.metadata.util.constants;

public enum ProgramType {

    PPMPK("PPMP Kompleks"),
    PPMPM("PPMP Murni"),
    PPIPK("PPIP Kompleks"),
    PPIPM("PPIP Kopmpleks"),
    DPLK("DPLK"),
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
