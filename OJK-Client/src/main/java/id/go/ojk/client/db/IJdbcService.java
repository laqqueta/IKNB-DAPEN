package id.go.ojk.client.db;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;

import id.go.ojk.client.model.config.SubmissionFormat;

public interface IJdbcService<T> {
  public T getConnection() throws SQLException;

  public void importTxt(Path path) throws SQLException, IOException;

  public int getRowCount(SubmissionFormat submissionFormat) throws SQLException;
  
  public void delete();
}
