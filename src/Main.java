import java.util.HashMap;


public class Main {
    public static HashMap<String, Object> map = new HashMap<>();

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        map = InputConsole.inputCnsl();

        String fileName = (String) map. get("lastName");
    if (!fileName.equals("null")) {
        for (String str : map.keySet()) {
            sb.append(map.get(str));
            sb.append(" ");
        }
        FileWork fw = new FileWork();
        if (fw.writeData(sb.toString(), fileName + ".txt")) {
            System.out.printf("Файл %s успешно создан!", fileName+".txt");
        }
    }

    }
}