package main.java.com.example.multithreadingsync.mutex;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class MutexSimulator {
    public static void run(Scanner scanner) {
        System.out.print("Кількість потоків: ");
        int n = scanner.nextInt();
        System.out.print("t1 (мс): ");
        int t1 = scanner.nextInt();
        System.out.print("t2 (мс): ");
        int t2 = scanner.nextInt();
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < n; i++) {
            String name = "Потік-" + (i + 1);
            Thread t = new Thread(() -> {
                System.out.println(name + " чекає м'ютекс...");
                lock.lock();
                try {
                    System.out.println(name + " захопив м'ютекс.");
                    int sleepTime = t1 + (int)(Math.random() * (t2 - t1));
                    Thread.sleep(sleepTime);
                    System.out.println(name + " звільняє м'ютекс.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }, name);
            t.start();
        }
    }
}