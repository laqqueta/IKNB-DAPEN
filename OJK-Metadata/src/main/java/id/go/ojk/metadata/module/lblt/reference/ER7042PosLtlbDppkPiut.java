package id.go.ojk.metadata.module.lblt.reference;

import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.util.constants.ProgramType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7042PosLtlbDppkPiut implements IObject<KeyValueString> {

    R_PIUT010000("PIUT010000", "Detail"),
    R_PIUT000000("PIUT000000", "Total");

    public final String key;
    public final String value;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7042PosLtlbDppkPiut eEnum : ER7042PosLtlbDppkPiut.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static List<KeyValueString> getObjectsGabungan() {
        List<KeyValueString> res = new ArrayList<>();

        res.addAll(Arrays.stream(ER7042PosLtlbDppkPiut.values())
                .map(ER7042PosLtlbDppkPiut::getObject)
                .collect(Collectors.toList()));

        res.addAll(Arrays.stream(ER7042PosLtlbDppkPiut.values())
                .map(ER7042PosLtlbDppkPiut::getObject)
                .collect(Collectors.toList()));

        return res;
    }

    public static String getName() {
        return ER7042PosLtlbDppkPiut.class.getSimpleName().substring(6);
    }

    public static int getRefNumber(int referenceNumber) {
        return referenceNumber;
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public static ReferenceConfig getRefConfig(ProgramType programType) {
        switch (programType) {
            case PPMPK:
            case PPMPM:
                return Configs.REF_CONFIG_PPMP;
            case PPIPK:
            case PPIPM:
                return Configs.REF_CONFIG_PPIP;
            case PPMPPPIPK:
                return Configs.REF_CONFIG_PPMPKPPIPK;
            default:
                throw new IllegalStateException();
        }
    }

    public enum Configs implements ReferenceConfig {
        REF_CONFIG_PPMP {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(3, 13), getObjects());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(3, 13), getObjects());
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
            }
        },

        REF_CONFIG_PPIP {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(3, 12), getObjects());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(3, 12), getObjects());
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
            }
        },

        REF_CONFIG_PPMPKPPIPK {
            private final String rowPPMP = UtilMetadata.genPipeRow(getObjectsGabungan(), new int[] { 1 });
            private final String rowPPIP = UtilMetadata.genPipeRow(getObjectsGabungan(), new int[] { 3 });

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave("2|4|5|6|7|8|9|10|11|12|13|14", getObjectsGabungan());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave("2|4|5|6|7|8|9|10|11|12|13|14", getObjectsGabungan());
            }

            @Override
            public Integer segmentRequireColumnLink() {
                return 2;
            }

            @Override
            public String segmentColumnValue() {
                return "PPMP|PPIP";
            }

            @Override
            public String segmentReqiurePosCode() {
                return rowPPMP + "#" + rowPPIP;
            }
        }
    }
}
