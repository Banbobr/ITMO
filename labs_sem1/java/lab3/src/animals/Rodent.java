package animals;

import enums.Location;

public class Rodent extends Animal {
    private boolean catched = false;

    public Rodent(String name, Location location) {
        super(name, location);
    }

    public Boolean getCatched() {
        return this.catched;
    }

    public void setCathed(Boolean catched) {
        this.catched = catched;
    }

    @Override
    public void speak(String speach) {
        System.out.println(name + ": " + "*Писк* " + speach + " *Писк*");
    }
}
