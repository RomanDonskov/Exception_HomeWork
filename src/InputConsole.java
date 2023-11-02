import java.util.HashMap;
import java.util.Scanner;

public class InputConsole {
    public static  HashMap<String, Object> inputCnsl(){
        HashMap<String, Object> map = new HashMap<>();
        while (true) {
            System.out.println("Веедите данные: Ф И О, дата рождения (dd.mm.yyyy), телефон, пол: ");
            Scanner input = new Scanner(System.in);

            String data = input.nextLine();

            CheckData check = new CheckData(data);

            try {
                map = check.parsInputData();
            } catch (DataException e) {
                System.out.println(e.getMessage());
            } catch (DataQuExpection e) {
                e.dataQuException();
            } catch (DateException e) {
                e.dateException();
            } catch (SexException e) {
                e.sexException();
            }
            if (!map.isEmpty()) return map;
        }
    }
}
