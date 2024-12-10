package ru.lab5.zadanie_6;

import java.util.Scanner;


// добавить отдельный метод по задаче. Сделать методом так, чтобы очередь 1 превратилась в обратную очередь в очереди2
public class QueueOp {
    public static Object readObjectInQueue(Scanner scanner) {
        String in = scanner.nextLine();
        try {
            return Integer.parseInt(in);
        } catch (NumberFormatException e) {
            try {
                return Double.parseDouble(in);
            } catch (NumberFormatException e1) {
                return in;
            }
        }
    }
}
