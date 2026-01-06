package id.go.ojk.pa.client.builder.field.tpp.reference;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1000Pos81A101 implements IObject<KeyValueString> {

    R_810101010100("810101010100","Risiko tinggi"),
    R_810101010200("810101010200","Risiko menengah"),
    R_810101010300("810101010300","Risiko rendah"),
    R_810101020101("810101020101","Risiko tinggi"),
    R_810101020102("810101020102","Risiko menengah"),
    R_810101020103("810101020103","Risiko rendah"),
    R_810101020201("810101020201","Risiko tinggi"),
    R_810101020202("810101020202","Risiko menengah"),
    R_810101020203("810101020203","Risiko rendah"),
    R_810101020301("810101020301","Risiko tinggi"),
    R_810101020302("810101020302","Risiko menengah"),
    R_810101020303("810101020303","Risiko rendah"),
    R_810101020401("810101020401","Risiko tinggi"),
    R_810101020402("810101020402","Risiko menengah"),
    R_810101020403("810101020403","Risiko rendah"),
    R_810101020501("810101020501","Risiko tinggi"),
    R_810101020502("810101020502","Risiko menengah"),
    R_810101020503("810101020503","Risiko rendah"),
    R_810101020601("810101020601","Risiko tinggi"),
    R_810101020602("810101020602","Risiko menengah"),
    R_810101020603("810101020603","Risiko rendah"),
    R_810101030100("810101030100","Risiko tinggi"),
    R_810101030200("810101030200","Risiko menengah"),
    R_810101030300("810101030300","Risiko rendah"),
    R_810101040101("810101040101","Risiko tinggi"),
    R_810101040102("810101040102","Risiko sedang"),
    R_810101040103("810101040103","Risiko rendah"),
    R_810101040201("810101040201","Risiko tinggi"),
    R_810101040202("810101040202","Risiko sedang"),
    R_810101040203("810101040203","Risiko rendah"),

    ;

    @Getter
    private final String key;
    private final String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER1000Pos81A101 eEnum : ER1000Pos81A101.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER1000Pos81A101.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER1000Pos81A101.class.getSimpleName().substring(2, 6));
    }
}
