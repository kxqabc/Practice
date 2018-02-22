package miles.test;

public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println("new thread is running!");
    }
}
