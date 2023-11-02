public class SexException extends MyExpection {
    private String sex;
    public SexException(String mess, String sex) {
        super(mess);
        this.sex = sex;
    }
    public void sexException(){
        System.out.printf("Error gender - %s",sex);
    }
}
