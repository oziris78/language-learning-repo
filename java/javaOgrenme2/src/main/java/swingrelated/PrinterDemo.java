package swingrelated;


public class PrinterDemo {

    static class MyException extends Exception{
        public MyException(String message) { super(message); }
    }

    static void f(boolean bool) throws MyException {
        if(bool) throw new MyException("bu string terminalde yazar");
    }

    public static void main(String[] args) {
        try{ f(true); }
        catch (MyException e){
            String message = e.getMessage(); // bu string terminalde yazar
            e.printStackTrace(); // CustomExceptionDemo$MyException: bu string terminalde yazar
        }
    }
}

