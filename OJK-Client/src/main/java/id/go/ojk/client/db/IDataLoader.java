package id.go.ojk.client.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IDataLoader {
  public void load(String tableName, List<String> columns) throws SQLException, FileNotFoundException, IOException;
}
