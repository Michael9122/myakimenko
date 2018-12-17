package ru.job4j.jmm;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 17.12.2018
 * @version 1
 */
public class MemoryTrouble {

    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        counter.counter = 10;
        MyThread myThread = new MyThread();
        myThread.setName("thread one");
        MyThread myThread2 = new MyThread();
        myThread.setCounter(counter);
        myThread2.setCounter(counter);
        myThread.start();
        myThread2.start();
        myThread.join();
        myThread2.join();
        System.out.println(counter.counter);
    }
}

class MyThread extends Thread {

    Counter counter;

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.change();
    }
}

class Counter {

    int counter;

    public void change() {
        int counter = this.counter;
        for (int i = 0; i < 10; i++) {
            if (Thread.currentThread().getName().equals("thread one")) {
                Thread.yield();
            }
            counter++;
        }
        this.counter = counter;
    }
}
