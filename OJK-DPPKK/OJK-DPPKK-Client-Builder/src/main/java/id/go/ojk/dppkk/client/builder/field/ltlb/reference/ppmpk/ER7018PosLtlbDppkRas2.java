package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7018PosLtlbDppkRas2 implements IObject<KeyValueString> {

    R_RAS20100000000("RAS20100000000", "Biaya Pegawai, Pengurus, Dewan Pengawas, dan/atau Dewas Pengawas Syariah"),
    R_RAS20101000000("RAS20101000000", "Biaya Pendidikan dan Latihan (Diklat)"),
    R_RAS20101010000("RAS20101010000", "a. Diklat Pegawai"),
    R_RAS20101020000("RAS20101020000", "b. Diklat Pengurus"),
    R_RAS20101030000("RAS20101030000", "c. Diklat Dewan Pengawas"),
    R_RAS20101040000("RAS20101040000", "d. Diklat Dewan Pengawas Syariah (jika ada)"),
    R_RAS20102000000("RAS20102000000", "Total Biaya Diklat"),
    R_RAS20103000000("RAS20103000000", "Rasio Biaya Diklat");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7018PosLtlbDppkRas2 eEnum : ER7018PosLtlbDppkRas2.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7018PosLtlbDppkRas2.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7018PosLtlbDppkRas2.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("2|3|4", getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
    }

    public static ConditionalRequired genValidationMustEmpty1() {
        return UtilFieldConditional.genMustEmpty("N", "M", "2",
                UtilMetadata.genPipeRow(getObjects(), 2, 7));
    }

    public static ConditionalRequired genValidationMustEmpty2() {
        return UtilFieldConditional.genMustEmpty("N", "M", "3",
                UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1 }));
    }

    public static ConditionalRequired genValidationMustEmpty3() {
        return UtilFieldConditional.genMustEmpty("N", "M", "4",
                UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1 }));
    }

    public static SegmentValidation genValidation1() {
        return UtilSegmentValidation.genEqualsFormula("3|4", R_RAS20102000000.key, UtilMetadata.genPlusRow(getObjects(), 2, 5),
                UtilMetadata.genMessageTotal(R_RAS20102000000.value, UtilMetadata.genPlusDesc(getObjects(), 2, 5)));
    }

}
