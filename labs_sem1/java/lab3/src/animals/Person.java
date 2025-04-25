package animals;

import enums.Location;
import interfaces.Thinking;

public class Person extends Animal implements Thinking {
    public Person(String name, Location location) {
        super(name, location);
    }

    public void think(String idea) {
        System.out.println(name + idea);
    }

    @Override
    public void speak(String speach) {
        System.out.println(name + ": " + speach);
    }
}