package ru.lab5.zadanie_1;

public class Fraction implements FractionInterface {
    private int chislitel;
    private int znamenatel;
    private Double cach_value;//добавить новый класс с кешированием

    Fraction() {
        this.chislitel = 0;
        this.znamenatel = 1;
    }

    Fraction(int chislitel, int znamenatel) {
        this.chislitel = chislitel;
        this.znamenatel = znamenatel;
    }

    Fraction(int chislitel) {
        this(chislitel, 1);
    }

    public void setChislitel(int chislitel) {
        this.chislitel = chislitel;
        invalidateCache();
    }


    public void setZnamenatel(int znamenatel) {
        this.znamenatel = znamenatel;
        invalidateCache();
    }

    int getChislitel() {
        return this.chislitel;
    }

    int getZnamenatel() {
        return this.znamenatel;
    }

    // Находим наименьшее общее кратное
    private int NOD(int a, int b) {
        while (a != b) {
            if (a > b) a -= b;
            else b -= a;
        }
        return a;
    }

    // сокращаем дроби
    private void sokr() {
        int NOD = NOD(Math.abs(chislitel), Math.abs(znamenatel));
        chislitel /= NOD;
        znamenatel /= NOD;

        if (znamenatel < 0) {
            chislitel = -chislitel;
            znamenatel = -znamenatel;
        }
    }


    // сумма дробей
    public Fraction summ(Fraction fraction) {
        if (fraction.chislitel == 0) {
            return new Fraction(this.chislitel, this.znamenatel);
        } else {
            int newChislitel = this.chislitel * fraction.znamenatel + fraction.chislitel * this.znamenatel;
            int newZnamenatel = this.znamenatel * fraction.znamenatel;
            Fraction result = new Fraction(newChislitel, newZnamenatel);
            result.sokr();
            return result;
        }
    }

    // вычитание дробей
    public Fraction vichet(Fraction fraction) {
        if (fraction.chislitel == 0) {
            return new Fraction(this.chislitel, this.znamenatel);
        } else {
            int newChislitel = this.chislitel * fraction.znamenatel - fraction.chislitel * this.znamenatel;
            int newZnemenatel = this.znamenatel * fraction.znamenatel;
            Fraction result = new Fraction(newChislitel, newZnemenatel);
            result.sokr();
            return result;
        }
    }

    // умножение дробей
    public Fraction umnozhenie(Fraction fraction) {
        if (fraction.chislitel == 0) {
            return new Fraction(0, 1);
        } else {
            int newChislitel = this.chislitel * fraction.chislitel;
            int newZnamenatel = this.znamenatel * fraction.znamenatel;
            Fraction result = new Fraction(newChislitel, newZnamenatel);
            result.sokr();
            return result;
        }
    }

    // деление дробей
    public Fraction del(Fraction fraction) {
        if (fraction.chislitel == 0) {
            return null;
        } else {
            int newChis = this.chislitel * fraction.znamenatel;
            int newZnam = this.znamenatel * fraction.chislitel;
            Fraction result = new Fraction(newChis, newZnam);
            result.sokr();
            return result;
        }
    }


    public String toString() {
        return chislitel + "/" + znamenatel;
    }

    @Override
    public double getValue() {
        if (cach_value == null) {
            cach_value = (double) chislitel / znamenatel;
        }
        return cach_value;
    }

    private void invalidateCache() {
        cach_value = null;
    }

    // Builder
    public static class FractionBuilder {
        private int chislitel;
        private int znamenatel;

        public FractionBuilder setChislitel(int chislitel) {
            this.chislitel = chislitel;
            return this;
        }

        public FractionBuilder setZnamenatel(int znamenatel) {
            if (znamenatel == 0) {
                throw new IllegalArgumentException("Знаменатель не может быть равен 0");
            }
            this.znamenatel = znamenatel;
            return this;
        }

        public Fraction build() {
            return new Fraction(chislitel, znamenatel);
        }
    }
}



