package threads;

import java.util.List;

public class MyThread extends Thread{

    private List<Character> names;
    private String message;

    public MyThread(List<Character> liste, String message){
        this.names = liste;
        this.message = message;
    }

    @Override
    public synchronized void run() {
        for(int i = 0; i<message.length() ; i++){
                names.add(message.charAt(i));
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        }
        System.out.println(Thread.currentThread().getName() + "bitti");
            System.out.println(names);
    }

}

