package id.go.ojk.client.db.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class FileUtil {
  // More precise file size
  public static String getFileSizeAsString(File file) {
    long bytes = file.length();
    long absB = bytes == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(bytes);
    if (absB < 1024) {
      return bytes + " B";
    }
    long value = absB;
    CharacterIterator ci = new StringCharacterIterator("KMGTPE");
    for (int i = 40; i >= 0 && absB > 0xfffccccccccccccL >> i; i -= 10) {
      value >>= 10;
      ci.next();
    }
    value *= Long.signum(bytes);
    return String.format("%." + 2 + "f %cB", value / 1024.0, ci.current());
  }

  // Get relative path from current workdir to target path
  public static Path getRelativePathTo(Path targetPath) {
    return Paths.get("./").toAbsolutePath().relativize(targetPath.toAbsolutePath());
  }
}
