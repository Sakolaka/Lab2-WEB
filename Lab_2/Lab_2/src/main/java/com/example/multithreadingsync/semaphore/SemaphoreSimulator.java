package main.java.com.example.multithreadingsync.semaphore;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class SemaphoreSimulator {
    public static void run(Scanner scanner) {
        System.out.print("Кількість потоків: ");
        int n = scanner.nextInt();
        System.out.print("t1 (мс): ");
        int t1 = scanner.nextInt();
        System.out.print("t2 (мс): ");
        int t2 = scanner.nextInt();
        Semaphore semaphore = new Semaphore(4);
        for (int i = 0; i < n; i++) {
            String name = "Потік-" + (i + 1);
            Thread t = new Thread(() -> {
                try {
                    System.out.println(name + " чекає семафор...");
                    semaphore.acquire();
                    System.out.println(name + " отримав семафор.");
                    int sleepTime = t1 + (int)(Math.random() * (t2 - t1));
                    Thread.sleep(sleepTime);
                    System.out.println(name + " звільняє семафор.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();
                }
            }, name);
            t.start();
        }
    }
}