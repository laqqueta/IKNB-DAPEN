package id.go.ojk.client.module.tpp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportTypeCode {
    TPP_FNK("TPPFNK"),
    TPP_FNS("TPPFNS"),
    TPP_PA("TPPPA")
    ;

    @Getter
    private String reportTypeCode;

}
