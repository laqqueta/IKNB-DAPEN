package id.go.ojk.lib.client.instance;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import id.go.ojk.lib.client.ColumnMap;
import id.go.ojk.lib.client.RowMap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValueByRowCode {
	@Getter
	private static Map<String, RowMap> map = new ConcurrentHashMap<>();
	private static ValueByRowCode instance;
	
	public static synchronized ValueByRowCode getInstance() {
		if (instance == null) {
			instance = new ValueByRowCode();
		}
		return instance;
	}

	public synchronized boolean checkPut(String rowCode, Integer rowIdx, Integer columnIdx, String value) {
		RowMap row = ValueByRowCode.getInstance().getRow(rowCode);
		if (row != null) {
			Iterator<Entry<Integer, ColumnMap>> iterator = row.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Integer, ColumnMap> entry = iterator.next();
				if (checkColumn(entry.getValue(), columnIdx, value)) {
					return true;
				}
			}
		}
		put(rowCode, rowIdx, columnIdx, value);
		return false;
	}
	
	private boolean checkColumn(ColumnMap columnMap, Integer columnIdx, String value) {
		String tmp = columnMap.get(columnIdx);
		return tmp != null && tmp.equals(value);
	}
	
	public synchronized void put(String rowCode, Integer rowIdx, Integer columnIdx, String value) {
		RowMap row = map.computeIfAbsent(rowCode, k -> new RowMap());
		ColumnMap column = row.computeIfAbsent(rowIdx, k -> new ColumnMap());
		column.put(columnIdx, value);
	}
	
	public void clear() {
		map.clear();
	}
	
	public RowMap getRow(String rowCode) {
		return map.get(rowCode);
	}
}
