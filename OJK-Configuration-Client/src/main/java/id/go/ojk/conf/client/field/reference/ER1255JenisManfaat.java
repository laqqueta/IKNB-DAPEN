package id.go.ojk.conf.client.field.reference;

import java.util.*;
import java.util.stream.Collectors;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValue;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1255JenisManfaat implements IObject<KeyValueString> {

    R_JM1("MP1", "Manfaat Pensiun"),
    R_JM2("MP2", "Manfaat Pensiun - LCF"),
    R_JM3("MP3", "Manfaat Pensiun - Non LCF"),
    R_JM4("MPL1", "Manfaat Tambahan"),
    R_JM5("MPL2", "Kompensasi Pasca Kerja"),
    R_JM6("MPL3", "Lainnya"),
    R_JM7("ML1", "Kompensasi Pasca Kerja"),
    R_JM8("ML2", "Kesehatan"),
    R_JM9("ML3", "Santunan Kematian"),
    R_JM10("ML4", "Ibadah Keagamaan"),
    R_JM11("ML5", "Pendidikan"),
    R_JM12("ML6", "Lainnya"),
    R_JM13("UUS1", "Manfaat Pensiun UUS"),
    R_JM14("UUS2", "Manfaat Pensiun Lainnya UUS"),
    R_JM15("UUS3", "Manfaat Lain UUS"),
    ;

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER1255JenisManfaat eEnum : ER1255JenisManfaat.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static List<KeyValueString> getObjects(String jenisProgram) {
        List<ER1255JenisManfaat> res;

        switch (jenisProgram) {
            case "PPMPK":
            case "GabunganPPMP":
                res = new ArrayList<>(Arrays.asList(
                        R_JM1, R_JM2, R_JM3, R_JM4, R_JM5,
                        R_JM6, R_JM7, R_JM8, R_JM9, R_JM10,
                        R_JM11, R_JM12));
                break;
            case "PPMPM":
                res = new ArrayList<>(Collections.singletonList(
                        R_JM1));
                break;
            case "PPIPK":
            case "GabunganPPIP":
                res = new ArrayList<>(Arrays.asList(
                        R_JM1, R_JM2, R_JM3, R_JM4, R_JM5,
                        R_JM6, R_JM7, R_JM8, R_JM9, R_JM10,
                        R_JM11, R_JM12, R_JM13, R_JM14, R_JM15));
                break;
            case "PPIPM":
                res = new ArrayList<>(Arrays.asList(
                        R_JM1, R_JM2, R_JM3, R_JM13));
                break;
            default:
                throw new IllegalStateException("Jenis Program: " + jenisProgram + " tidak ditemukan!");
        }

        return res.stream()
                .map(ER1255JenisManfaat::getObject)
                .collect(Collectors.toList());
    }

    public static String getName(String jenisProgram) {

        String defName = ER1255JenisManfaat.class.getSimpleName().substring(6);

        switch (jenisProgram) {
            case "PPMPK":
                return defName + "PPMPKompleks";
            case "PPMPM":
                return defName + "PPMPMurni";
            case "PPIPK":
                return defName + "PPIPKompleks";
            case "PPIPM":
                return defName + "PPIPMurni";
            case "GabunganPPMP":
                return defName + "GabunganPPMP";
            case "GabunganPPIP":
                return defName + "GabunganPPIP";
            default:
                return defName;
        }
    }

    public static String getName() {
        return ER1255JenisManfaat.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER1255JenisManfaat.class.getSimpleName().substring(2, 6));
    }

    public static int getRefNumber(String jenisProgram) {

        int defRefNumber = 10500;

        switch (jenisProgram) {
            case "PPMPK":
                defRefNumber += 1;
                break;
            case "PPMPM":
                defRefNumber += 2;
                break;
            case "PPIPK":
                defRefNumber += 3;
                break;
            case "PPIPM":
                defRefNumber += 4;
                break;
            case "GabunganPPMP":
                defRefNumber += 5;
                break;
            case "GabunganPPIP":
                defRefNumber += 6;
                break;
            default:
                throw new IllegalStateException("Jenis Program: " + jenisProgram + " tidak ditemukan!");
        }

        return defRefNumber;
    }

    public static String getReferenceIndex(int index) {
        StringBuilder res = new StringBuilder();
        ER1255JenisManfaat[] eEnums = ER1255JenisManfaat.values();
        for (int i = 0; i < eEnums.length; i++) {
            if (i == index) {
                res.append(ER1255JenisManfaat.values()[i].key);
                break;
            }
        }
        return res.toString();
    }

    public static String getReferenceValueIndex(int index) {
        StringBuilder res = new StringBuilder();
        ER1255JenisManfaat[] eEnums = ER1255JenisManfaat.values();
        for (int i = 0; i < eEnums.length; i++) {
            if (i == index) {
                res.append(ER1255JenisManfaat.values()[i].value);
                break;
            }
        }
        return res.toString();
    }

    public static String getPipedReferenceKeyValues(String filter) {
        Map<String, KeyValueString> map = ER1255JenisManfaat.getObjects()
                .stream()
                .collect(Collectors.toMap(KeyValueString::getKey, e2 -> e2));

        List<String> keys = Arrays.stream(StringUtils.split(filter, "|"))
                .map(k -> map.get(k).getKey() + " - " + map.get(k).getValue() + "|")
                .collect(Collectors.toList());

        // remove last pipe
        String lastElem = keys.get(keys.size() - 1);
        keys.set(keys.size() - 1, lastElem.substring(0, lastElem.length() - 1));

        return String.join("", keys);
    }

    public static String getPipedReferenceKeys(String filter) {
        Map<String, KeyValueString> map = ER1255JenisManfaat.getObjects()
                .stream()
                .collect(Collectors.toMap(KeyValueString::getKey, e2 -> e2));

        List<String> keys = Arrays.stream(StringUtils.split(filter, "|"))
                .map(k -> map.get(k).getKey() + "|")
                .collect(Collectors.toList());

        // remove last pipe
        String lastElem = keys.get(keys.size() - 1);
        keys.set(keys.size() - 1, lastElem.substring(0, lastElem.length() - 1));

        return String.join("", keys);
    }

    public static void main(String[] args) {
        System.out.println(getName());
    }
}
