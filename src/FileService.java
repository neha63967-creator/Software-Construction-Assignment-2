import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileService {

    /**
     * Append text to a file (creates file if missing).
     */
    public void appendToFile(String fileName, String data) throws IOException {
        try (FileWriter fw = new FileWriter(fileName, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(data);
        }
    }

    /**
     * Overwrite file with provided data lines.
     */
    public void writeLinesToFile(String fileName, java.util.List<String> lines) throws IOException {
        try (FileWriter fw = new FileWriter(fileName);
             PrintWriter pw = new PrintWriter(fw)) {
            for (String line : lines) pw.println(line);
        }
    }
}
