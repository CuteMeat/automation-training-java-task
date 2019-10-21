package com.task.automation.thread.optional;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Runway extends Thread{

    private Semaphore semaphore;

    private int id;

    public Runway (Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Самолет "+id+" начал выход на взлетную полосу");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Самолет " + id + " взлетел");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Полоса приняла самолет" + id);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Полоса освободилась");
            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println("С самолетом " + id+" проблемы");
        }
    }
}
