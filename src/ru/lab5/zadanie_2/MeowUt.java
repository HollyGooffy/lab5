package ru.lab5.zadanie_2;

public class MeowUt {
    public static void makeMeow(Meowing[] meowings) {
        for(Meowing meowing : meowings){
            meowing.meow();
        }
    }
}
