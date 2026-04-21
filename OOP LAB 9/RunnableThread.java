class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread running using Runnable interface");
    }

    public MyRunnable() {
        Thread t = new Thread(this);
        t.start();
    }
}

public class RunnableThread {
    public static void main(String[] args) {
        new MyRunnable();
    }
}