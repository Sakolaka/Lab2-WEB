package main.java.com.example.multithreadingsync.pool;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolSimulator {
    public static void run(Scanner scanner) {
        System.out.print("Тип (1 - fixed, 2 - cached): ");
        int type = scanner.nextInt();
        System.out.print("Кількість потоків для виконання: ");
        int n = scanner.nextInt();
        ExecutorService executor = (type == 1) ? Executors.newFixedThreadPool(4) : Executors.newCachedThreadPool();
        for (int i = 0; i < n; i++) {
            String name = "Потік-" + (i + 1);
            executor.execute(() -> {
                System.out.println(name + " працює...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(name + " завершив.");
            });
        }
        executor.shutdown();
    }
}