package ru.lab5.zadanie_2;

public class MeowCount implements Meowing{
    private Meowing meowing;
    private int meowCount;

    public MeowCount(Meowing meowing){
        this.meowCount = 0;
        this.meowing = meowing;
    }

    @Override
    public void meow(){
        meowing.meow();
        meowCount++;
    }

    public int getMeowCount() {
        return meowCount;
    }
}
