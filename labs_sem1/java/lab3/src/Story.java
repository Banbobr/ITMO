import animals.Person;
import animals.Cat;
import animals.Rodent;
import animals.Rabbit;
import enums.Location;
import enums.Paws;
import items.Bag;

public final class Story {
    public static void Story(){
        Cat cat = new Cat("Кот", Location.HOME);
        Person person = new Person("Хозяин", Location.HOME);
        Rodent rat = new Rodent("Крыса", Location.HOME);
        Rodent mouse = new Rodent("Мышь", Location.HOME);
        Rabbit rabbit = new Rabbit("Кролик", Location.FOREST);

        person.think(" не знал верить или нет " + cat.getName());
        person.think(" помнил на какие хитрости пускался " + cat.getName());
        cat.catchRodent(rat);
        rat.speak("помогите меня поймали");
        cat.catchRodent(mouse);
        mouse.speak("помогите меня поймали");
        cat.catchRodent(mouse);
        cat.playDead();
        cat.hangOn(Paws.BACK);
        cat.speak("Я вешу " + Paws.BACK.getTypePaws());
        person.speak("Кто его знает, а вдруг и в самом деле " + cat.getName() + " чем-нибудь поможет в беде!");
        Bag catBag = new Bag(cat.getName(), 2);
        catBag.add("отруби");
        catBag.add("заячья капуста");
        catBag.getItems();
        cat.takeShoes();
        cat.CheckgotEverythgNeed();
        cat.takeBag();
        cat.takeShoes();
        cat.takeBag();
        cat.CheckgotEverythgNeed();
        cat.tryCatchRabbit(catBag);
        cat.goToForest();
        cat.tryCatchRabbit(catBag);
        rabbit.speak("ай ай ай меня поймали");
    }
}
