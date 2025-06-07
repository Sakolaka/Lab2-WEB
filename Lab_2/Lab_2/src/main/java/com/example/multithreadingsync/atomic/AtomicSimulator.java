package main.java.com.example.multithreadingsync.atomic;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSimulator {
    private static final AtomicInteger atomicVar = new AtomicInteger(0);
    public static void run(Scanner scanner) {
        while (true) {
            System.out.println("\n1. Збільшити");
            System.out.println("2. Зменшити");
            System.out.println("3. Встановити значення");
            System.out.println("4. Поточне значення");
            System.out.println("0. Назад");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> System.out.println("Нове значення: " + atomicVar.incrementAndGet());
                case 2 -> System.out.println("Нове значення: " + atomicVar.decrementAndGet());
                case 3 -> {
                    System.out.print("Нове значення: ");
                    int val = scanner.nextInt();
                    atomicVar.set(val);
                }
                case 4 -> System.out.println("Поточне значення: " + atomicVar.get());
                case 0 -> { return; }
                default -> System.out.println("Невірний вибір!");
            }
        }
    }
}