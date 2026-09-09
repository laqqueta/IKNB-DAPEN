package id.go.ojk.metadata.module.lblt.reference;

import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.util.constants.ProgramType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static id.go.ojk.lib.client.model.config.DataType.numeric;

@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7068PosLtlbDppkPkpl implements IObject<KeyValueString> {

    R_PKPL010000("PKPL010000", "Detail"),
    R_PKPL000000("PKPL000000", "Total");

    public final String key;
    public final String value;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7068PosLtlbDppkPkpl eEnum : ER7068PosLtlbDppkPkpl.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static List<KeyValueString> getObjectsGabungan() {
        List<KeyValueString> res = getObjects();

        res.addAll(Arrays.stream(ER7068PosLtlbDppkPkpl.values())
                .map(ER7068PosLtlbDppkPkpl::getObject)
                .collect(Collectors.toList()));

        res.addAll(Arrays.stream(ER7068PosLtlbDppkPkpl.values())
                .map(ER7068PosLtlbDppkPkpl::getObject)
                .collect(Collectors.toList()));

        return res;
    }

    public static String getName() {
        return ER7068PosLtlbDppkPkpl.class.getSimpleName().substring(6);
    }

    public static int getRefNumber(int referenceNumber) {
        return referenceNumber;
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public enum Configs implements ReferenceConfig {
        REF_CONFIG {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave("3", getObjects());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave("3|4", getObjects());
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
                return UtilMetadata.genFieldSave("2|4|5", getObjectsGabungan());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave("2|4|5", getObjectsGabungan());
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
        },
    }

    public static void main(String[] args) {
        getObjectsGabungan().forEach(v -> System.out.println(v.getKey() + " > " + v.getValue()));
        System.out.println(Configs.REF_CONFIG_PPMPKPPIPK.segmentReqiurePosCode());
    }

    // REF_CONFIG \{\n@Override\npublic String savePos\(\) \{\nreturn UtilMetadata\.genFieldSave\("[^"]*", getObjects\(\)\);\n\}\n\n@Override\n    public String savePosForm\(\) \{\n        return UtilMetadata\.genFieldSave\("[^"]*", getObjects\(\)\);\n    \}\n\n    @Override\n    public String requiredPos\(\) \{\n        return UtilMetadata\.genPipeRow\(getObjects\(\), new int\[\] \{ 1 \}\);\n    \}\n\},
}
