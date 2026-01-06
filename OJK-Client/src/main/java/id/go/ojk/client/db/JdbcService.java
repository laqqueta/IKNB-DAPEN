package id.go.ojk.client.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.duckdb.DuckDBConnection;

import id.go.ojk.client.db.util.FileUtil;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.lib.client.exception.SlikException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JdbcService extends BaseService implements IJdbcService<DuckDBConnection> {
  public static final String SERVICE_NAME = "dbService";
  public static final String DB_NAME = "apolo";
  public static final Path path = Paths.get(System.getProperty("java.io.tmpdir"), DB_NAME);
  public static final Path walPath = Paths.get(System.getProperty("java.io.tmpdir"), DB_NAME + ".wal");
  private final Map<String, Map<Integer, String>> indexToColumnMapping = new HashMap<>();
  public static final String SQL_EXCEPTION_MESSAGE = "Terjadi kesalahan";
  
  @Override
  public void initialize() {
    try {
      Class.forName("org.duckdb.DuckDBDriver");
    } catch (ClassNotFoundException e) {
      log.error(e.getMessage(), e);
      throw new SlikException(e.getMessage(), e);
    }
  }

  public String getTableName(SubmissionFormat submissionFormat) {
    return getTableName(submissionFormat, submissionFormat.getCode());
  }

  public String getTableName(SubmissionFormat submissionFormat, String formCode) {
    return submissionFormat.getReportCode() + formCode;
  }

  public String getTableName(SubmissionFormat submissionFormat, String formCode, String suffix) {
    return getTableName(submissionFormat, formCode) + " " + suffix;
  }

  public List<String> getAllColumnName(SubmissionFormat submissionFormat) {
    return indexToColumnMapping.get(submissionFormat.getCode()).entrySet().stream().map(e -> e.getValue())
        .collect(Collectors.toList());
  }
  
  public List<String> getAllColumnName(SubmissionFormat submissionFormat, String prefix) {
    return indexToColumnMapping.get(submissionFormat.getCode()).entrySet().stream().map(e -> prefix + "." + e.getValue())
        .collect(Collectors.toList());
  }
  
  public String getColumnName(SubmissionFormat submissionFormat, int columnIndex, String prefix) {
    return prefix + "." + getColumnName(submissionFormat.getCode(), columnIndex);
  }

  public String getColumnName(SubmissionFormat submissionFormat, int columnIndex) {
    return getColumnName(submissionFormat.getCode(), columnIndex);
  }
  
  public String getColumnName(String formCode, int columnIndex, String prefix) {
    return prefix + "." + getColumnName(formCode, columnIndex);
  }

  public String getColumnName(String formCode, int columnIndex) {
    String columnName = indexToColumnMapping.get(formCode).get(columnIndex);
    if (columnName == null) {
      throw new NullPointerException(new StringBuilder().append("Index ").append(columnIndex).append(" in form '")
          .append(formCode).append("' is not saved").toString());
    }
    return columnName;
  }

  public void updateIndexToColumnMapping(SubmissionFormat submissionFormat) {
    Map<Integer, String> savePosFormMap = new HashMap<Integer, String>();
    submissionFormat.getFields().forEach(f -> {
      savePosFormMap.put(f.getNumber(), "column" + f.getNumber());
    });

    indexToColumnMapping.put(submissionFormat.getCode(), savePosFormMap);
  }

  @Override
  public void importTxt(Path path) throws SQLException, IOException {
    String[] fileNameSplit = StringUtils.split(path.getFileName().toString(), "-");

    if(StringUtils.isAnyBlank(fileNameSplit)) {
      throw new SlikException("Invalid file '" + path + "'");
    }

    String reportCode = fileNameSplit[0];
    String form = fileNameSplit[1];
    String tableName = reportCode + form;

    final File file = path.toFile();
    if (!file.exists()) {
      throw new FileNotFoundException(file.getAbsolutePath());
    }

    final String fileSize = FileUtil.getFileSizeAsString(file);
    log.info("Importing '{}' ({}) to '{}'", path, fileSize, tableName);

    DataLoaderContext.getLoader(path).load(tableName, getColumns(tableName, form));
  }

  @Override
  public int getRowCount(SubmissionFormat submissionFormat) throws SQLException {
    int count = 0;
    String sb = "SELECT COUNT(*) FROM " + getTableName(submissionFormat);
    try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sb.toString());) {
      rs.next();
      count = rs.getInt(1);
      log.info("{} has {} row(s)", submissionFormat.getReportCode() + "-" + submissionFormat.getCode(), count);
    }
    return count;
  }

  @Override
  public DuckDBConnection getConnection() throws SQLException {
    return (DuckDBConnection) DriverManager.getConnection("jdbc:duckdb:" + path);
  }

  public void delete() {
    log.info("Deleting db file: {}", FileUtils.deleteQuietly(path.toFile()));
    log.info("Deleting db log file: {}", FileUtils.deleteQuietly(walPath.toFile()));
  }

  private List<String> getColumns(String tableName, String formCode) {
    List<String> columns = new ArrayList<String>();
    columns.add("row_id BIGINT");
    indexToColumnMapping.entrySet().stream().filter(e -> e.getKey().equals(formCode)).forEach(a -> {
      a.getValue().entrySet().forEach(b -> {
        columns.add(b.getValue() + " VARCHAR");
      });
    });
    columns.add("column_count BIGINT");
    return columns;
  }
}
