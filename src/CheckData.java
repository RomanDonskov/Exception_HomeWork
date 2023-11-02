import java.text.SimpleDateFormat;
import java.util.HashMap;

public class CheckData {
    public String data;
    public CheckData(String data){
        this.data = data;
    }
    public HashMap<String, Object> parsInputData() throws DataQuExpection, SexException, DateException, DataException {
        String[] dataArr = toArray();
        HashMap<String, Object> dataDic = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String i : dataArr) {
            if (i.length() == 1) {

                if (i.equals("f") || i.equals("m")) {
                    dataDic.put("sex", i);
                } else {
                    throw new SexException("Gender error!",i);
                }
            } else if (i.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                String[] arrayDate = i.split("\\.");

                if (Integer.parseInt(arrayDate[0]) < 0 ||
                        Integer.parseInt(arrayDate[0]) > 31 || Integer.parseInt(arrayDate[1]) < 0 ||
                        Integer.parseInt(arrayDate[1]) > 12 || Integer.parseInt(arrayDate[2]) < 0 ||
                        Integer.parseInt(arrayDate[2]) > 2023) {
                    throw new DateException("Date error! ", i);
                } else {
                    if (isDateValid(i)) {
                        dataDic.put("date", i);
                    }
                    else
                     throw new DateException("Date error! ", i);
                }
            } else if (i.matches("[0-9]+")) {
                dataDic.put("tel", i);
            } else if (i.matches("[A-Za-z]+")) {
                sb.append(i + " ");
            } else throw new DataException("Data Error!!!");

        }

        String[] fullName = String.valueOf(sb).split(" ");
        if (fullName.length == 3) {
            dataDic.put("firstName", fullName[1]);
            dataDic.put("lastName", fullName[0]);
            dataDic.put("fatherName", fullName[2]);

        } else {
            throw new DataException("Data Error!!!");
        }
        return dataDic;
    }
    private boolean isDateValid(String date) {

        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
        myFormat.setLenient(false);
        try {
            myFormat.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    private String [] toArray() throws DataQuExpection {
        String[] str = data.split(" ");
        if (str.length == 6) {
            return str;
        }
        else {
            throw new DataQuExpection("Неверное количество введенных данных! ",str.length);
        }
    }

}