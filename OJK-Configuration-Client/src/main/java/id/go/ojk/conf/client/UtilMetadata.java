package id.go.ojk.conf.client;

import java.util.*;
import java.util.stream.IntStream;

import id.go.ojk.conf.client.dto.FormulaParserData;
import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.constant.ESymbolMap;
import id.go.ojk.lib.client.model.KeyValueString;

public class UtilMetadata {
    public static final String DEVIDE = "/";
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String PIPE = "|";

    public static String genFormRow(String formCode, KeyValueString row) {
        return formCode + row.getKey();
    }

    public static String genFieldSave(String fieldNo, List<KeyValueString> listKv) {
        StringBuilder res = new StringBuilder(fieldNo);
        int size = listKv.size();
        res.append("&");
        for (int i = 0; i < size; i++) {
            KeyValueString kv = listKv.get(i);
            res.append(kv.getKey());
            if (i + 1 < size) {
                res.append(PIPE);
            }
        }
        return res.toString();
    }

    public static String genFieldSaveExcept(String fieldNo, List<KeyValueString> listKv, int[] arrExcept) {
        StringBuilder res = new StringBuilder(fieldNo);
        int size = listKv.size();
        res.append("&");
        for (int i = 0; i < size; i++) {
            boolean exist = isExist(i, arrExcept);
            if (!exist) {
                KeyValueString kv = listKv.get(i);
                res.append(kv.getKey());
                if (i + 1 < size) {
                    res.append(PIPE);
                }
            }
        }
        return res.toString();
    }

    public static String genPlusRow(List<KeyValueString> listKv, int[] arr) {
        return genDelimitedRow(listKv, arr, PLUS);
    }

    public static String genPlusRow(List<KeyValueString> listKv, int from, int to) {
        return genDelimitedRow(listKv, from, to, PLUS);
    }

    public static String genPlusRowExcept(List<KeyValueString> listKv, int from, int to, int[] except) {
        int[] arr = IntStream.rangeClosed(from, to).filter(i -> !isExist(i, except)).toArray();
        return genPlusRow(listKv, arr);
    }

    public static String genPlusRow(List<KeyValueString> listKv) {
        return genDelimitedRow(listKv, 0, listKv.size() - 1, PLUS);
    }

    public static String genMinusRow(List<KeyValueString> listKv, int[] arr) {
        return genDelimitedRow(listKv, arr, MINUS);
    }

    public static String genMinusRow(List<KeyValueString> listKv, int from, int to) {
        return genDelimitedRow(listKv, from, to, MINUS);
    }

    public static String genDevideRow(List<KeyValueString> listKv, int[] arr) {
        return genDelimitedRow(listKv, arr, DEVIDE);
    }

    public static String genPipeRowExcept(List<KeyValueString> listKv, int[] arr) {
        return genDelimitedRowExcept(listKv, arr, PIPE);
    }

    public static String genPipeRow(List<KeyValueString> listKv, int[] arr) {
        return genDelimitedRow(listKv, arr, PIPE);
    }

    public static String genPipeRow(List<KeyValueString> listKv, int from, int to) {
        return genDelimitedRow(listKv, from, to, PIPE);
    }

    public static String genPipeRow(List<KeyValueString> listKv) {
        return genDelimitedRow(listKv, 0, listKv.size() - 1, PIPE);
    }

    public static String genDelimitedRowExcept(List<KeyValueString> listKv, int[] arr, String delimiter) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < listKv.size(); i++) {
            boolean exist = isExist(i, arr);
            if (!exist) {
                KeyValueString kv = listKv.get(i);
                res.append(kv.getKey());
                res.append(delimiter);
            }
        }
        return res.length() > 0 ? res.toString().substring(0, res.length() - 1) : "";
    }

    public static String genDelimitedRow(List<KeyValueString> listKv, int[] arr, String delimiter) {
        StringBuilder res = new StringBuilder();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            KeyValueString kv = listKv.get(arr[i]);
            res.append(kv.getKey());
            if (i + 1 < length) {
                res.append(delimiter);
            }
        }
        return res.toString();
    }

    public static String genDelimitedRowArr(List<KeyValueString> listKv, int[] arr, String delimiters) {
        StringBuilder res = new StringBuilder();
        String[] delimiter = delimiters.split("\\|");
        int length = arr.length;

        if (delimiter.length + 1 != length)
            throw new IllegalArgumentException();

        for (int i = 0; i < length; i++) {
            KeyValueString kv = listKv.get(arr[i]);
            res.append(kv.getKey());
            if (i + 1 < length) {
                res.append(delimiter[i]);
            }
        }
        return res.toString();
    }

    public static String genDelimitedRowArr(List<KeyValueString> listKv, int start, int end, String delimiters) {
        StringBuilder res = new StringBuilder();
        String[] delimiter = delimiters.split("\\|");

        if (delimiter.length + 1 != (end - start))
            throw new IllegalArgumentException();

        for (int i = start; i <= end; i++) {
            KeyValueString kv = listKv.get(i);
            res.append(kv.getKey());
            if (i < end) {
                res.append(delimiter[i]);
            }
        }
        return res.toString();
    }

    public static String genDelimitedRow(List<KeyValueString> listKv, int from, int to, String delimiter) {
        StringBuilder res = new StringBuilder();
        for (int i = from; i <= to; i++) {
            KeyValueString kv = listKv.get(i);
            res.append(kv.getKey());
            if (i < to) {
                res.append(delimiter);
            }
        }
        return res.toString();
    }

    public static String genDelimitedDesc(List<KeyValueString> listKv, int[] arr, String delimiter) {
        StringBuilder res = new StringBuilder();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            KeyValueString kv = listKv.get(arr[i]);
            String desc = ESymbolMap.encode(kv.getValue().trim());
            res.append(StringUtils.wrap(desc, "'"));
            if (i + 1 < length) {
                res.append(delimiter);
            }
        }
        return res.toString();
    }

    public static String genDelimitedDescArr(List<KeyValueString> listKv, int[] arr, String delimiters) {
        StringBuilder res = new StringBuilder();
        int length = arr.length;
        String[] delimiter = delimiters.split("\\|");

        if (delimiter.length + 1 != length)
            throw new IllegalArgumentException();

        for (int i = 0; i < length; i++) {
            KeyValueString kv = listKv.get(arr[i]);
            String desc = ESymbolMap.encode(kv.getValue().trim());
            res.append(StringUtils.wrap(desc, "'"));
            if (i + 1 < length) {
                res.append(delimiter[i]);
            }
        }
        return res.toString();
    }

    public static String genDelimitedDescArr(List<KeyValueString> listKv, int start, int end, String delimiters) {
        StringBuilder res = new StringBuilder();
        String[] delimiter = delimiters.split("\\|");

        if (delimiter.length + 1 != (end - start))
            throw new IllegalArgumentException();

        for (int i = start; i <= end; i++) {
            KeyValueString kv = listKv.get(i);
            String desc = ESymbolMap.encode(kv.getValue().trim());
            res.append(StringUtils.wrap(desc, "'"));
            if (i < end) {
                res.append(delimiter[i]);
            }
        }
        return res.toString();
    }

    public static String genDelimitedDesc(List<KeyValueString> listKv, int from, int to, String delimiter) {
        StringBuilder res = new StringBuilder();
        for (int i = from; i <= to; i++) {
            KeyValueString kv = listKv.get(i);
            String desc = ESymbolMap.encode(kv.getValue().trim());
            res.append(StringUtils.wrap(desc, "'"));
            if (i < to) {
                res.append(delimiter);
            }
        }
        return res.toString();
    }

    public static String genFormulaFormatter(List<KeyValueString> listKv, int[] selectPos, int[] fields) {
        StringBuilder res = new StringBuilder("(");

        for (int i = 0; i < selectPos.length; i++) {
            KeyValueString kv = listKv.get(selectPos[i]);
            res.append(kv.getKey()).append("[");

            for (int k = 0; k < fields.length; k++) {
                res.append(fields[k]);
                if (k < fields.length - 1) {
                    res.append("+");
                }
            }

            res.append("]");

            if (i < selectPos.length - 1) {
                res.append("+");
            }

        }
        return res.append(")").toString();
    }

    public static String genFormulaFormatter(List<KeyValueString> listKv, String selectPos, String fields) {
        StringBuilder res = new StringBuilder("(");
        String[] arrPos = StringUtils.split(selectPos, "|");
        String[] arrField = StringUtils.split(fields, "|");

        for (int i = 0; i < arrPos.length; i++) {
            KeyValueString kv = listKv.get(Integer.parseInt(arrPos[i]));
            res.append(kv.getKey()).append("[");

            for (int k = 0; k < arrField.length; k++) {
                res.append(arrField[k]);
                if (k < arrField.length - 1) {
                    res.append("+");
                }
            }

            res.append("]");

            if (i < arrPos.length - 1) {
                res.append("+");
            }

        }
        return res.append(")").toString();
    }

    public static FormulaParserData genFormulaParserFormatter(List<KeyValueString> listKv, int[] operationPos, int[] fields, String[] posOperand, String[] fieldOperand, String form) {
        StringBuilder formula = new StringBuilder("(");
        StringBuilder message = new StringBuilder();

        if (fields.length == 2 && fieldOperand.length != 1 || operationPos.length == 2 && posOperand.length != 1) throw new IllegalStateException();
        if (fields.length > 2 && fieldOperand.length+1 != fields.length || operationPos.length > 2 && posOperand.length+1 != operationPos.length) throw new IllegalStateException();

        for (int i = 0; i < operationPos.length; i++) {
            KeyValueString kv = listKv.get(operationPos[i]);
            formula.append(form)
                    .append("#")
                    .append(kv.getKey()).append("[");

            if (fields.length > 1) message.append("(");
            message.append("'")
                    .append(kv.getValue()).append("' ");

            for (int k = 0; k < fields.length; k++) {
                formula.append(fields[k]);
                message.append("Kolom ").append(fields[k]+1);
                if (k < fields.length - 1) {
                    formula.append(fieldOperand[k]);
                    message.append(fieldOperand[k]);
                }
            }

            formula.append("]");
            if (fields.length > 1) message.append(")");

            if (i < operationPos.length - 1) {
                formula.append(posOperand[i]);
                message.append(" ").append(posOperand[i]).append(" ");
            }
        }

        return new FormulaParserData(formula.append(")").toString(), message.toString());
    }

    public static FormulaParserData genFormulaParserFormatterDetailed(List<KeyValueString> listKv, int[] operationPos, int[] fields, String[] posOperand, String[] fieldOperand, String[] fieldNames, String form) {
        StringBuilder formula = new StringBuilder("(");
        StringBuilder message = new StringBuilder();

        if (fields.length == 2 && fieldOperand.length != 1 || operationPos.length == 2 && posOperand.length != 1) throw new IllegalStateException();
        if (fields.length > 2 && fieldOperand.length+1 != fields.length || operationPos.length > 2 && posOperand.length+1 != operationPos.length) throw new IllegalStateException();
        if (fields.length != fieldNames.length) throw new IllegalStateException();

        for (int i = 0; i < operationPos.length; i++) {
            KeyValueString kv = listKv.get(operationPos[i]);
            formula.append(form)
                    .append("#")
                    .append(kv.getKey()).append("[");

            if (fields.length > 1) message.append("(");
            message.append("'")
                    .append(kv.getValue()).append("' ");

            for (int k = 0; k < fields.length; k++) {
                formula.append(fields[k]);
                message.append("Kolom '").append(fieldNames[k]).append("'");
                if (k < fields.length - 1) {
                    formula.append(fieldOperand[k]);
                    message.append(fieldOperand[k]);
                }
            }

            formula.append("]");
            if (fields.length > 1) message.append(")");

            if (i < operationPos.length - 1) {
                formula.append(posOperand[i]);
                message.append(" ").append(posOperand[i]).append(" ");
            }
        }

        return new FormulaParserData(formula.append(")").toString(), message.toString());
    }

    // Single Row & Column usage
    public static FormulaParserData genFormulaParserFormatter(KeyValueString listKv, int[] fields, String form) {
        return genFormulaParserFormatter(Collections.singletonList(listKv), new int[] {0}, fields, new String[]{}, new String[]{}, form);
    }

    public static FormulaParserData genFormulaParserFormatter(KeyValueString listKv, String fields, String form) {
        int[] arrField = Arrays.stream(StringUtils.split(fields, "|"))
                .mapToInt(Integer::valueOf)
                .toArray();

        return genFormulaParserFormatter(Collections.singletonList(listKv), new int[] {0}, arrField, new String[]{}, new String[]{}, form);
    }

    public static FormulaParserData genFormulaParserFormatter(KeyValueString listKv, String fields, String fieldOperands, String form) {
        int[] arrField = Arrays.stream(StringUtils.split(fields, "|"))
                .mapToInt(Integer::valueOf)
                .toArray();

        String[] arrInnerOps = StringUtils.split(fieldOperands, "|");

        return genFormulaParserFormatter(Collections.singletonList(listKv), new int[] {0}, arrField, new String[]{}, arrInnerOps, form);
    }

    public static FormulaParserData genFormulaParserFormatterDetailed(KeyValueString listKv, int[] fields, String[] fieldNames, String form) {
        return genFormulaParserFormatterDetailed(Collections.singletonList(listKv), new int[]{0}, fields, new String[]{}, new String[]{}, fieldNames, form);
    }

    public static FormulaParserData genFormulaParserFormatterDetailed(KeyValueString listKv, String fields, String fieldNames, String form) {
        int[] arrField = Arrays.stream(StringUtils.split(fields, "|"))
                .mapToInt(Integer::valueOf)
                .toArray();

        String[] arrFieldNames = StringUtils.split(fieldNames, "|");

        return genFormulaParserFormatterDetailed(Collections.singletonList(listKv), new int[]{0}, arrField, new String[]{}, new String[]{}, arrFieldNames, form);
    }

    public static FormulaParserData genFormulaParserFormatterDetailed(KeyValueString listKv, String fields, String fieldOperands, String fieldNames, String form) {
        int[] arrField = Arrays.stream(StringUtils.split(fields, "|"))
                .mapToInt(Integer::valueOf)
                .toArray();

        String[] arrInnerOps = StringUtils.split(fieldOperands, "|");
        String[] arrFieldNames = StringUtils.split(fieldNames, "|");

        return genFormulaParserFormatterDetailed(Collections.singletonList(listKv), new int[]{0}, arrField, new String[]{}, arrInnerOps, arrFieldNames, form);
    }

    // Single/Multi Row & Column usage
    public static FormulaParserData genFormulaParserFormatter(List<KeyValueString> listKv, String operationPos, String fields, String posOperands, String fieldOperands, String form) {
        int[] arrSelectPos = Arrays.stream(StringUtils.split(operationPos, "|"))
                .mapToInt(Integer::valueOf)
                .toArray();

        int[] arrField = Arrays.stream(StringUtils.split(fields, "|"))
                .mapToInt(Integer::valueOf)
                .toArray();

        String[] arrOuterOps = StringUtils.split(posOperands, "|");
        String[] arrInnerOps = StringUtils.split(fieldOperands, "|");

        return genFormulaParserFormatter(listKv, arrSelectPos, arrField, arrOuterOps, arrInnerOps, form);
    }

    public static FormulaParserData genFormulaParserFormatterDetailed(List<KeyValueString> listKv, String operationPos, String fields, String posOperands, String fieldOperands, String fieldNames, String form) {
        int[] arrSelectPos = Arrays.stream(StringUtils.split(operationPos, "|"))
                .mapToInt(Integer::valueOf)
                .toArray();

        int[] arrField = Arrays.stream(StringUtils.split(fields, "|"))
                .mapToInt(Integer::valueOf)
                .toArray();

        String[] arrFieldNames = StringUtils.split(fieldNames, "|");

        String[] arrOuterOps = StringUtils.split(posOperands, "|");
        String[] arrInnerOps = StringUtils.split(fieldOperands, "|");

        return genFormulaParserFormatterDetailed(listKv, arrSelectPos, arrField, arrOuterOps, arrInnerOps, arrFieldNames, form);
    }

    public static String genDelimitedDescByPosCode(List<KeyValueString> listKv, String selectPosCode) {
        StringBuilder sb = new StringBuilder();
        String[] codesAndChar = StringUtils.splitByCharacterType(selectPosCode);
        for (String code : codesAndChar) {
            for (KeyValueString keyValue : listKv) {
                if (keyValue.getKey().equals(code)) {
                    String desc = ESymbolMap.encode(keyValue.getValue().trim());
                    sb.append("'").append(desc).append("'");
                    break;
                } else if (code.equals("+") || code.equals("-") || code.equals("*") || code.equals(":")) {
                    sb.append(" ").append(code).append(" ");
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static String genPipeColumn(int[] arr) {
        return genDelimitedColumn(arr, PIPE);
    }

    public static String genPipeColumn(int from, int to) {
        return genDelimitedColumn(from, to, PIPE);
    }

    public static String genPipeColumnExcept(int min, int max, int[] arrExcept) {
        return genDelimitedColumnExcept(min, max, arrExcept, PIPE);
    }

    public static String genPlusColumn(int[] arr) {
        return genDelimitedColumn(arr, PLUS);
    }

    public static String genPlusColumn(int from, int to) {
        return genDelimitedColumn(from, to, PLUS);
    }

    public static String genMinusColumn(int[] arr) {
        return genDelimitedColumn(arr, MINUS);
    }

    public static String genMinusColumn(int from, int to) {
        return genDelimitedColumn(from, to, MINUS);
    }

    public static String genDelimitedColumn(int[] arr, String delimiter) {
        StringBuilder res = new StringBuilder();
        int len = arr.length - 1;
        for (int i = 0; i <= len; i++) {
            res.append(arr[i]);
            if (i < len) {
                res.append(delimiter);
            }
        }
        return res.toString();
    }

    public static String genDelimitedColumn(int from, int to, String delimiter) {
        StringBuilder res = new StringBuilder();
        for (int i = from; i <= to; i++) {
            res.append(i);
            if (i < to) {
                res.append(delimiter);
            }
        }
        return res.toString();
    }

    public static String genDelimitedColumnExcept(int min, int max, int[] arrExcept, String delimiter) {
        StringBuilder builder = new StringBuilder();
        for (int i = min; i <= max; i++) {
            boolean exist = isExist(i, arrExcept);
            if (!exist) {
                builder.append(i);
                builder.append(delimiter);
            }
        }
        String res = builder.toString();
        return res.substring(0, StringUtils.lastIndexOf(res, delimiter));
    }

    public static String genPlusDesc(List<KeyValueString> listKv, int[] arr) {
        return genDelimitedDesc(listKv, arr, PLUS);
    }

    public static String genPlusDesc(List<KeyValueString> listKv, int from, int to) {
        return genDelimitedDesc(listKv, from, to, PLUS);
    }

    public static String genPlusDescExcept(List<KeyValueString> listKv, int from, int to, int[] except) {
        int[] arr = IntStream.rangeClosed(from, to).filter(i -> !isExist(i, except)).toArray();
        return genDelimitedDesc(listKv, arr, PLUS);
    }

    public static String genMinusDesc(List<KeyValueString> listKv, int[] arr) {
        return genDelimitedDesc(listKv, arr, MINUS);
    }

    public static String genMinusDesc(List<KeyValueString> listKv, int from, int to) {
        return genDelimitedDesc(listKv, from, to, MINUS);
    }

    public static String genDevideDesc(List<KeyValueString> listKv, int[] arr) {
        return genDelimitedDesc(listKv, arr, DEVIDE);
    }

    public static String genMessage(String field, String comparator) {
        return field.trim() + PIPE + comparator.trim();
    }

    public static String genMessage(String field, String comparatorHead, String comparator) {
        if (StringUtils.isNotEmpty(comparatorHead)) {
            comparatorHead = StringUtils.capitalize(comparatorHead.toLowerCase().trim());
        }
        String message2 = (StringUtils.isNotEmpty(comparatorHead) ? comparatorHead + ", " : "") + comparator;
        return field.trim() + PIPE + message2.trim();
    }

    public static String genMessageTotal(String field, String comparator) {
        String message2 = "Total " + StringUtils.uncapitalize(comparator.trim());
        return field.trim() + PIPE + message2;
    }

    public static String genMessageForm(String message, String form) {
        return message + " pada form " + form;
    }

    public static String genMessageFormTotal(String field, String form) {
        return genMessageForm("Total akumulasi kolom " + StringUtils.wrap(field, "'"), form);
    }

    private static boolean isExist(int value, int[] arr) {
        boolean res = false;
        for (int i = 0; i < arr.length; i++) {
            res = (value == arr[i]);
            if (res) {
                break;
            }
        }
        return res;
    }

    public static StringJoiner joinKeys(List<IObject<KeyValueString>> listKv, CharSequence delimiter) {
        StringJoiner joiner = new StringJoiner(delimiter);
        listKv.forEach(kv -> {
            joiner.add(kv.getObject().getKey());
        });
        return joiner;
    }

    public static StringJoiner joinValues(List<IObject<KeyValueString>> listKv, CharSequence delimiter) {
        StringJoiner joiner = new StringJoiner(delimiter);
        listKv.forEach(kv -> {
            joiner.add(ESymbolMap.encode(kv.getObject().getValue().trim()));
        });
        return joiner;
    }

    private UtilMetadata() {
    }
}
