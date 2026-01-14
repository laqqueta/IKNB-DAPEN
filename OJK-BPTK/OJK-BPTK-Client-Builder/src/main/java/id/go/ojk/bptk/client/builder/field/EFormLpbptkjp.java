package id.go.ojk.bptk.client.builder.field;

import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLpbptkjp implements IForm {
  RKPST("RKPST", "Rekapitulasi Kepesertaan Program JP"),
  RPIU("RPIU", "Rekapitulasi Upah dan Iuran Program JP"),
  RDJP("RDJP", "Rekapitulasi Dana Program JP"),
  RPMF("RPMF", "Rekapitulasi Manfaat Program JP"),
  RKPIU("RKPIU", "Agregat Kepesertaan dan Iuran Program JP"),
  RKPMF("RKPMF", "Agregat Kepesertaan dan Manfaat Program JP"),
  INF("INF", "Informasi Pendukung Lain"),
  SP("SP", "Surat Pengantar dan Pernyataan Direksi"),
  ;

  @Getter
  private String code;
  @Getter
  private String name;

  @Override
  public String getReportCode() {
    return EReportBpjs.LPBPTKJP_RUTIN.getReportTypeCode();
  }  
}
