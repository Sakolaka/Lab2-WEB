package main.java.com.example.multithreadingsync.cashier;

import java.util.*;
import java.util.concurrent.*;

public class CashierSimulation {

    public static void run(Scanner scanner) {
        System.out.print("Введіть кількість кас: ");
        int cashierCount = scanner.nextInt();
        scanner.nextLine(); // очистити буфер

        List<BlockingQueue<String>> queues = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(cashierCount);

        for (int i = 0; i < cashierCount; i++) {
            BlockingQueue<String> queue = new LinkedBlockingQueue<>();
            queues.add(queue);
            int finalI = i;
            service.execute(() -> {
                while (true) {
                    try {
                        String client = queue.take();
                        System.out.println("Каса " + (finalI + 1) + " обслуговує " + client);
                        Thread.sleep(500 + new Random().nextInt(500));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
        }

        System.out.print("Кількість клієнтів: ");
        int clients = scanner.nextInt();
        scanner.nextLine(); // очистити буфер

        for (int i = 0; i < clients; i++) {
            String client = "Клієнт-" + (i + 1);
            BlockingQueue<String> shortest = queues.stream()
                    .min(Comparator.comparingInt(BlockingQueue::size))
                    .orElse(queues.get(0));
            shortest.offer(client);
        }

        System.out.println("Усі клієнти розподілені по чергам.");
    }
}
