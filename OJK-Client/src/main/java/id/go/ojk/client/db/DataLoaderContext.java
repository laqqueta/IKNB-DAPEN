package id.go.ojk.client.db;

import java.nio.file.Path;

import id.go.ojk.lib.client.exception.SlikException;

public class DataLoaderContext {
  public static IDataLoader getLoader(Path path) {
    return getLoader("default", path);
  }

  public static IDataLoader getLoader(String name, Path path) {
    switch (name) {
      case "default":
        return new StreamDataLoader(path);
      default:
        throw new SlikException("Data loader not supported");
    }
  }
}
