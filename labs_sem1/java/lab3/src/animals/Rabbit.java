package animals;

import enums.Location;

public class Rabbit extends Animal {
    public Rabbit(String name, Location location) {
        super(name, location);
    }

    @Override
    public void speak(String speach) {
        System.out.println(name + ": " + "*Писклявый крик* " + speach + " *Писклявый крик*");
    }
}
