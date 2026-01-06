package id.go.ojk.fins.client.builder.field.tpp.reference;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER12000Pos82A101 implements IObject<KeyValueString> {

    R_820101010100 ("820101010100", "Risiko tinggi"),
    R_820101010200 ("820101010200", "Risiko sedang"),
    R_820101010300 ("820101010300", "Risiko rendah"),
    R_820101020101 ("820101020101", "Risiko tinggi"),
    R_820101020102 ("820101020102", "Risiko sedang"),
    R_820101020103 ("820101020103", "Risiko rendah"),
    R_820101020201 ("820101020201", "Risiko tinggi"),
    R_820101020202 ("820101020202", "Risiko sedang"),
    R_820101020203 ("820101020203", "Risiko rendah"),
    R_820101020301 ("820101020301", "Risiko tinggi"),
    R_820101020302 ("820101020302", "Risiko sedang"),
    R_820101020303 ("820101020303", "Risiko rendah"),
    R_820101020401 ("820101020401", "Risiko tinggi"),
    R_820101020402 ("820101020402", "Risiko sedang"),
    R_820101020403 ("820101020403", "Risiko rendah"),
    R_820101020501 ("820101020501", "Risiko tinggi"),
    R_820101020502 ("820101020502", "Risiko sedang"),
    R_820101020503 ("820101020503", "Risiko rendah"),
    R_820101020601 ("820101020601", "Risiko tinggi"),
    R_820101020602 ("820101020602", "Risiko sedang"),
    R_820101020603 ("820101020603", "Risiko rendah"),
    R_820101030101 ("820101030101", "Risiko tinggi"),
    R_820101030102 ("820101030102", "Risiko sedang"),
    R_820101030103 ("820101030103", "Risiko rendah"),
    R_820101030201 ("820101030201", "Risiko tinggi"),
    R_820101030202 ("820101030202", "Risiko sedang"),
    R_820101030203 ("820101030203", "Risiko rendah"),
    R_820101040100 ("820101040100", "Risiko tinggi"),
    R_820101040200 ("820101040200", "Risiko sedang"),
    R_820101040300 ("820101040300", "Risiko rendah"),

    ;

    @Getter
    private final String key;
    private final String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER12000Pos82A101 eEnum : ER12000Pos82A101.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER12000Pos82A101.class.getSimpleName().substring(7);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER12000Pos82A101.class.getSimpleName().substring(2, 7));
    }
}
