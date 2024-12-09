package ru.lab5.zadanie_2;

public class Cat implements Meowing{
   private String name;

   public Cat(String name){
       this.name = name;
   }

    public String getName() {
        return name;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }

    @Override
    public String toString() {
        return "Кот: " + name;
    }
}
