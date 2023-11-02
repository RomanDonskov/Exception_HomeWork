import java.io.FileWriter;
import java.io.IOException;

public class FileWork {
    public boolean writeData(String data, String path) {
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.append(data);
            fw.append("\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}