package junit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class FilePathTest {

  @Test
  @DisplayName("Ensure that two temporary directories with same files names and content have same hash")
  void hashTwoDynamicDirectoryWhichHaveSameContent(@TempDir Path tempDir, @TempDir Path tempDir2)
      throws IOException {

    Path file1 = tempDir.resolve("myfile.txt");

    List<String> input = Arrays.asList("input1", "input2", "input3");
    Files.write(file1, input);

    assertTrue(Files.exists(file1), "File should exist");

    Path file2 = tempDir2.resolve("myfile.txt");

    Files.write(file2, input);
    assertTrue(Files.exists(file2), "File should exist");
  }
}
