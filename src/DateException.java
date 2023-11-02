public class DateException extends MyExpection {

    private String date;

    public String getDate() {
        return date;
    }

    public DateException(String mess, String date){
        super(mess);
        this.date = date;
    }
    public void dateException(){
        System.out.printf("Date error - %s", date);
    }
}
