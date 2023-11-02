public class DataQuExpection extends MyExpection{
    private int length;

    public int getLength() {
        return length;
    }

    public DataQuExpection(String mess, int length) {

        super(mess);
        this.length = length;
    }
    public void dataQuException(){
        if (length<6){
            System.out.println("Введено меньше данных!!!");
        }
        else if (length>6){
            System.out.println("Введено больше данных!!!");
        }
    }
}
