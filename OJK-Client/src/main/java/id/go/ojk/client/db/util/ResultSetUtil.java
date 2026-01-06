package id.go.ojk.client.db.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import id.go.ojk.client.db.JdbcService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResultSetUtil {
  public static final String DEFAULT_SEPARATOR = "|";

  public static Map<Integer, String> sqlToCsv(JdbcService db, String sql) throws SQLException {
    log.debug(sql.toString());
    try (Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql.toString())) {
      return resultSetToCsv(rs);
    }
  }

  @SneakyThrows
  private static Map<Integer, String> resultSetToCsv(ResultSet rs) {
    Map<Integer, String> lines = new TreeMap<Integer, String>();
    ResultSetMetaData mtdt = rs.getMetaData();
    int columnCount = mtdt.getColumnCount();
    // TODO: Sanitize to make sure the row_id is present.
    while (rs.next()) {
      List<String> values = new ArrayList<String>();
      int key = rs.getInt(1);
      for (int i = 2; i <= columnCount; i++) {
        String value = rs.getString(i);
        values.add(value == null ? "" : value);
      }
      lines.put(key, String.join(DEFAULT_SEPARATOR, values));
    }
    return lines;
  }
}
