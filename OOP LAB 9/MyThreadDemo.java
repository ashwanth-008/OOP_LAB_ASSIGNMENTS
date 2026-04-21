//1) Creation of a thread by extending the thread class. The thread is created and started in main method of another class.
class MyThread extends Thread 
{
    public void run() 
    {
        System.out.println("Thread running using Thread class");
    }
}

public class MyThreadDemo 
{
    public static void main(String[] args) 
    {
        MyThread t = new MyThread();
        t.start();
    }
}
