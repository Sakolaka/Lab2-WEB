package main.java.com.example.multithreadingsync.menu;

import main.java.com.example.multithreadingsync.atomic.AtomicSimulator;
import main.java.com.example.multithreadingsync.cashier.CashierSimulation;
import main.java.com.example.multithreadingsync.mutex.MutexSimulator;
import main.java.com.example.multithreadingsync.pool.ThreadPoolSimulator;
import main.java.com.example.multithreadingsync.semaphore.SemaphoreSimulator;

import java.util.Scanner;

public class MenuHandler {
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Меню ===");
            System.out.println("1. М'ютекс");
            System.out.println("2. Семафор");
            System.out.println("3. Атомарна змінна");
            System.out.println("4. Пул потоків");
            System.out.println("5. Вільна каса");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> MutexSimulator.run(scanner);
                case 2 -> SemaphoreSimulator.run(scanner);
                case 3 -> AtomicSimulator.run(scanner);
                case 4 -> ThreadPoolSimulator.run(scanner);
                case 5 -> CashierSimulation.run(scanner);
                case 0 -> {
                    System.out.println("Завершення програми...");
                    return;
                }
                default -> System.out.println("Невірний вибір!");
            }
        }
    }
}