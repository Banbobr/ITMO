package animals;

import enums.Location;
import enums.Paws;
import items.Bag;

public class Cat extends Animal {
    private boolean gotEverythingNeed = false;
    private boolean takeShoes = false;
    private boolean takeBag = false;

    public Cat(String name, Location location) {
        super(name, location);
    }

    public void CheckgotEverythgNeed() {
        if (takeShoes && takeBag) {
            gotEverythingNeed = true;
            System.out.println(name + " полностью собрался");
        } else if (takeShoes) {
            System.out.println(name + " не обулся");
        } else {
            System.out.println(name + " не взял мешок");
        }
    }

    public void goToForest() {
        location = Location.FOREST;
        if (gotEverythingNeed) {
            System.out.println(name + " собрал все что надо и отправился в " + location.getTitle());
        } else {
            System.out.println(name + "еще не готов идти в " + location.getTitle());
        }
    }

    public void catchRodent(Rodent rodent) {
        if (rodent.getCatched()) {
            System.out.println(name + " уже поймал " + rodent.getName());
        } else {
            rodent.setCathed(true);
            System.out.println(name + " поймал " + rodent.getName());
        }
    }

    public void takeBag() {
        if (takeBag) {
            System.out.println(name + " уже взял мешок");
        } else {
            takeBag = true;
            System.out.println(name + " взял мешок");
        }
    }

    public void takeShoes() {
        if (takeShoes) {
            System.out.println(name + " уже надел обувь");
        } else {
            takeShoes = true;
            System.out.println(name + " надел обувь");
        }
    }

    public void tryCatchRabbit(Bag bag) {
        if (!bag.checkEmpty() && takeBag && (location == Location.FOREST)) {
            System.out.println(name + " готов ловить кроликов");
        } else if (!takeBag) {
            System.out.println(name + " еще не взял мешок");
        } else if (!(location == Location.FOREST)) {
            System.out.println(name + " не может ловить кроликов не в лесу");
        } else {
            System.out.println("Мешок пуст, ловить нечем(((");
        }
    }

    public void playDead() {
        System.out.println(name + " прикинулся мертвым");
    }

    public void hangOn(Paws paws) {
        System.out.println(name + " повиснул " + paws.getTypePaws());
    }

    @Override
    public void speak(String speach) {
        System.out.println(name + ": " + "Мяу " + speach + " Мяу");
    }
}