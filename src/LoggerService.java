import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoggerService {
    private final List<String> logs = new ArrayList<>();

    public void addLog(String line) {
        logs.add(line);
    }

    public List<String> getLogs() {
        return Collections.unmodifiableList(logs);
    }

    public void exportLogs(String fileName, FileService fileService) throws IOException {
        fileService.writeLinesToFile(fileName, logs);
    }
}
