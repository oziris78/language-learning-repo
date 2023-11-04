import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyMain {



    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.version().version()); // JAVA SE11.0.9.1
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}



