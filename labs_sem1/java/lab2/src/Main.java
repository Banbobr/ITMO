import ru.ifmo.se.pokemon.*;
import pokemons.*;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();

        Pokemon p1 = new Moltres("Бебра", 1);
        Pokemon p2 = new Slowking("Допсяш", 1);
        Pokemon p3 = new Monferno("Засыпаш", 1);

        Pokemon p4 = new Slowpoke("Челик", 1);
        Pokemon p5 = new Chimchar("Биба", 1);
        Pokemon p6 = new Infernape("Боба", 1);

        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);

        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);

        b.go();
    }
}