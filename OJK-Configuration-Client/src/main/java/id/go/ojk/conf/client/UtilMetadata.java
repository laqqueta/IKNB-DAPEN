package id.go.ojk.conf.client;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

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

	public static String genDelimitedDescByPosCode(List<KeyValueString> listKv, String selectPosCode) {
		StringBuilder sb = new StringBuilder();
		String[] codesAndChar = StringUtils.splitByCharacterType(selectPosCode);
		for (String code : codesAndChar) {
			for (KeyValueString keyValue : listKv) {
				if (keyValue.getKey().equals(code)) {
					String desc = ESymbolMap.encode(keyValue.getValue().trim());
					sb.append("'").append(desc).append("'");
					break;
				} else if (code.equals("+") || code.equals("-") || code.equals("*") || code.equals(":")){
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

	private UtilMetadata() { }
}
