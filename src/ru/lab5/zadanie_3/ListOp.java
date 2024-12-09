package ru.lab5.zadanie_3;

import java.util.List;
import java.util.Scanner;

public class ListOp {
    // метод удаления
    public static <T> void removeAll(List<T> list, T value) {
        list.removeIf(element -> element.equals(value));
    }

    //метод вставки с клавиатуры
    public static Object readObject(Scanner scanner) {
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
