package id.go.ojk.client.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.duckdb.DuckDBAppender;
import org.duckdb.DuckDBConnection;

import id.go.ojk.client.db.util.Formatter;
import id.go.ojk.client.service.context.ApplicationContextClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class StreamDataLoader implements IDataLoader {
  private final JdbcService db = ApplicationContextClient.getInstance().getService(JdbcService.class);
  private final Path path;

  @Override
  public void load(String tableName, List<String> columns) throws SQLException, FileNotFoundException, IOException {
    StringBuilder sb = new StringBuilder();
    sb.append("CREATE OR REPLACE TABLE ").append(tableName).append(" (").append(String.join(",", columns)).append(")");

    String sql = sb.toString();
    try (DuckDBConnection conn = db.getConnection();Statement stmt = conn.createStatement()) {
      log.debug(sql);
      stmt.execute(sql);
    }

    int fixedLength = columns.size() - 1;
    AtomicInteger counter = new AtomicInteger();
    AtomicInteger flushCounter = new AtomicInteger();
    String separator = "|";
    try (DuckDBConnection conn = db.getConnection();
        DuckDBAppender appender = conn.createAppender(DuckDBConnection.DEFAULT_SCHEMA, tableName)) {
      StopWatch sw = new StopWatch();
      sw.start();
      try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
        reader.lines().skip(1).forEach(line -> { //don't use parallel() stream
          String[] originalLines = StringUtils.splitPreserveAllTokens(line, separator);
          int columnCount = originalLines.length;
          String[] fixedLines = Arrays.copyOf(originalLines, fixedLength);
          int fixedLinesLength = fixedLines.length;
          // log.debug((Arrays.toString(fixedLines)));
          try {
            appender.beginRow();
            appender.append(counter.incrementAndGet());
            for (int j = 0; j < fixedLinesLength - 1; j++) {
              appender.append(StringUtils.isEmpty(fixedLines[j]) ? null : fixedLines[j]);
            }
            appender.append(columnCount);
            appender.endRow();
            flushCounter.incrementAndGet();
            if (flushCounter.intValue() == 1_000_000) {
              log.info("{} row(s) imported", Formatter.formatInteger(counter.intValue()));
              flushCounter.set(0);
              appender.flush();
            }
          } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
          }
        });
      }
      sw.stop();
      log.info("Import completed in {}", Formatter.formatMillis(sw.getTime()));
    }
  }
}
