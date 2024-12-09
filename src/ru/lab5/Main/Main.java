package ru.lab5.Main;
import ru.lab5.zadanie_1.Fraction;
import ru.lab5.zadanie_2.Cat;
import ru.lab5.zadanie_2.MeowCount;
import ru.lab5.zadanie_2.MeowUt;
import ru.lab5.zadanie_2.Meowing;
import ru.lab5.zadanie_3.ListOp;
import ru.lab5.zadanie_5.ReadFileUt;
import ru.lab5.zadanie_6.QueueOp;
import ru.lab5.zadanie_7.num1.Point;
import ru.lab5.zadanie_7.num1.PolyLine;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        /* Задание 1.1 */
        System.out.println("Задание 1.1 Дробь");
        Fraction[] fractions = new Fraction[3];

        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Введите числитель и знаменатель для дроби " + (i + 1) + " : ");
                if (in.hasNextInt()) {
                    int chisl = in.nextInt();
                    if (in.hasNextInt()) {
                        int znamen = in.nextInt();
                        if (znamen != 0) {
                            fractions[i] = new Fraction.FractionBuilder()
                                    .setChislitel(chisl)
                                    .setZnamenatel(znamen)
                                    .build();
                            break;
                        } else {
                            System.out.println("Знаменатель не может быть равен 0. Попробуйте еще раз");
                        }
                    } else {
                        System.out.println("Знаменатель должен быть целым числом. Попробуйте еще раз");
                        in.next();
                    }
                } else {
                    System.out.println("Числитель должен быть целым числом");
                    in.next();
                }
            }
        }

        System.out.println("Результат: ");
        Fraction rez;

        // 1. Сумма
        System.out.println("Сумма");
        rez = fractions[0].summ(fractions[1]);
        System.out.println(fractions[0] + " + " + fractions[1] + " = " + rez);
        rez = fractions[0].summ(fractions[2]);
        System.out.println(fractions[0] + " + " + fractions[2] + " = " + rez);
        System.out.println();

        System.out.println("Разность");
        // 2. Вычитание
        rez = fractions[0].vichet(fractions[1]);
        System.out.println(fractions[0] + " - " + fractions[1] + " = " + rez);
        rez = fractions[0].vichet(fractions[2]);
        System.out.println(fractions[0] + " - " + fractions[2] + " = " + rez);
        System.out.println();

        System.out.println("Деление");
        // 3. Деление
        rez = fractions[0].del(fractions[1]);
        System.out.println(fractions[0] + " / " + fractions[1] + " = " + rez);
        rez = fractions[0].del(fractions[2]);
        System.out.println(fractions[0] + " / " + fractions[2] + " = " + rez);
        System.out.println();

        System.out.println("Умножение");
        // 4. Умножение
        rez = fractions[0].umnozhenie(fractions[1]);
        System.out.println(fractions[0] + " * " + fractions[1] + " = " + rez);
        rez = fractions[0].umnozhenie(fractions[2]);
        System.out.println(fractions[0] + " * " + fractions[2] + " = " + rez);
        System.out.println();

        // f1.sum(f2).div(f3).minus(5)
        Fraction f4 = new Fraction.FractionBuilder().setChislitel(5).setZnamenatel(1).build();
        System.out.println("Посчитать f1.sum(f2).div(f3).minus(5) ");
        rez = fractions[0].summ(fractions[1]);
        System.out.println("1. " + rez);
        rez = rez.del(fractions[2]);
        if (rez == null) {
            System.out.println("Деление на ноль невозможно (в курсах школьной математики)");
        } else {
            System.out.println("2. " + rez);
            rez = rez.vichet(f4);
            System.out.println("Ответ: " + rez + "\n");
        }

        /* Задание 2.1 */
        System.out.println("Задание 2.1 Мяуканье");
        Cat cat = new Cat("Вася");
        MeowCount meowCount = new MeowCount(cat);
        Meowing[] meowings = {meowCount};

        System.out.println("До вызова метода");
        System.out.println(cat);

        MeowUt.makeMeow(meowings);
        MeowUt.makeMeow(meowings);

        System.out.println("После вызова метода");
        System.out.println("Количество мяуканий: " + meowCount.getMeowCount() + "\n");

        /* Задание 3.5 */
        System.out.println("Задание 3.5 Список");
        List<Object> list = new ArrayList<>();

        System.out.print("Введите длинну массива: ");
        int count_3;
        if (in.hasNextInt()) {
            count_3 = in.nextInt();
            in.nextLine();
            for (int i = 0; i < count_3; i++) {
                System.out.print("Введите значение которое надо ввести для " + (i + 1) + " позиции: ");
                Object valueAdd = ListOp.readObject(in);
                list.add(valueAdd);
            }

            System.out.println("Массив до удаления: " + list);

            System.out.println("Введите значение для удаления: ");
            Object valueRem = ListOp.readObject(in);
            ListOp.removeAll(list, valueRem);
            System.out.println("Список после удаления: " + list + "\n");
        } else {
            System.out.println("неправильный ввод \n");
            in.nextLine();
        }

        /* Задание 4.5 */

        /* Задание 5.5 */
        System.out.println("Задание 5.5 Сеты");
        String file = "textAlp.txt";
        ReadFileUt readFile = new ReadFileUt();
        try {
            String text = ReadFileUt.readFile(file);
            String[] words = text.split("\\s+");
            Set<Character> zvonkiyLetters = new HashSet<>(Arrays.asList('б', 'в', 'г', 'д', 'ж', 'з'));
            /*
                'б', - 2
                'в', - 6
                'г', - 1te
                'д', - 3
                'ж', - 1
                'з' - 2
            */
            Set<Character> result = new HashSet<>();
            Set<Character> multiWords = new HashSet<>();

            for (String word : words) {
                Set<Character> wordsAdd = new HashSet<>();
                for (char c : word.toLowerCase().toCharArray()) {
                    if (zvonkiyLetters.contains(c)) {
                        wordsAdd.add(c);
                    }
                }
                for (char c : wordsAdd) {
                    if (multiWords.contains(c)) {
                        result.add(c);
                    } else {
                        multiWords.add(c);
                    }
                }
            }

            List<Character> sortedResult = new ArrayList<>(result);
            Collections.sort(sortedResult);
            System.out.println("Звонкие буквы, которые входят более чем в одно слово: ");
            for (char c : sortedResult) {
                System.out.println(c + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();


        /* Задание 6.5 */
        System.out.println("Задание 6.5 Очередь");
        Queue<Object> queue = new LinkedList<>();
        Queue<Object> queue2 = new LinkedList<>();

        int count_6;
        System.out.println("Введите длину очереди: ");
        if (in.hasNextInt()) {
            count_6 = in.nextInt();
            in.nextLine();
            for (int i = 0; i < count_6; i++) {
                System.out.println("Введите значение для " + (i + 1) + " позиции");
                Object value_6 = QueueOp.readObjectInQueue(in);
                queue.add(value_6);
            }

            System.out.println("массив до преобразований: " + queue);
            Stack<Object> stack = new Stack<>();
            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }
            while (!stack.isEmpty()) {
                queue2.add(stack.pop());
            }
            System.out.println("массив после преобразований: " + queue2 + "\n");
        } else {
            System.out.println("Неправильный размер массива \n");
            in.nextLine();
        }


        /* Задание 7.1 */
        System.out.println("Задание 7.1 Стрим Поинт");
        List<Point> points = Arrays.asList(
                new Point(1,1),
                new Point(1,1),
                new Point(-5,-4),
                new Point(1,9),
                new Point(9,1));

        List<Point> result  = points.stream()
                .filter(p -> p.getX() != 0 && p.getY() != 0 && p.getX() != p.getY()) // удаляем если x = y
                .sorted(Comparator.comparingDouble(Point::getX)) // сортировка по X
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .collect(Collectors.toList());

        PolyLine polyLine = createPolyne(result);
        System.out.println("Точки в ломанной: " + polyLine.toString());


        /* Задание 7.2 */


    }

    //Задание 7.1
    private static PolyLine createPolyne(List<Point> points){
        PolyLine polyline = new PolyLine();
        for (Point point : points){
            polyline.addPoint(point);
        }
        return polyline;
    }


}

