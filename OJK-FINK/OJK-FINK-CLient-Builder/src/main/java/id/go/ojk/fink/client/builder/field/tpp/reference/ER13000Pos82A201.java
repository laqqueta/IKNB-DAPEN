package id.go.ojk.fink.client.builder.field.tpp.reference;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER13000Pos82A201 implements IObject<KeyValueString> {

    R_820102010100 ("820102010100", "Risiko tinggi"),
    R_820102010200 ("820102010200", "Risiko sedang"),
    R_820102010300 ("820102010300", "Risiko rendah"),
    R_820102020101 ("820102020101", "Risiko tinggi"),
    R_820102020102 ("820102020102", "Risiko sedang"),
    R_820102020103 ("820102020103", "Risiko rendah"),
    R_820102020201 ("820102020201", "Risiko tinggi"),
    R_820102020202 ("820102020202", "Risiko sedang"),
    R_820102020203 ("820102020203", "Risiko rendah"),
    R_820102020301 ("820102020301", "Risiko tinggi"),
    R_820102020302 ("820102020302", "Risiko sedang"),
    R_820102020303 ("820102020303", "Risiko rendah"),
    R_820102020401 ("820102020401", "Risiko tinggi"),
    R_820102020402 ("820102020402", "Risiko sedang"),
    R_820102020403 ("820102020403", "Risiko rendah"),
    R_820101020501 ("820101020501", "Risiko tinggi"),
    R_820101020502 ("820101020502", "Risiko sedang"),
    R_820101020503 ("820101020503", "Risiko rendah"),
    R_820101020601 ("820101020601", "Risiko tinggi"),
    R_820101020602 ("820101020602", "Risiko sedang"),
    R_820101020603 ("820101020603", "Risiko rendah"),
    R_820102030101 ("820102030101", "Risiko tinggi"),
    R_820102030102 ("820102030102", "Risiko sedang"),
    R_820102030103 ("820102030103", "Risiko rendah"),
    R_820102030201 ("820102030201", "Risiko tinggi"),
    R_820102030202 ("820102030202", "Risiko sedang"),
    R_820102030203 ("820102030203", "Risiko rendah"),
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
        for (ER13000Pos82A201 eEnum : ER13000Pos82A201.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER13000Pos82A201.class.getSimpleName().substring(7);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER13000Pos82A201.class.getSimpleName().substring(2, 7));
    }
}
