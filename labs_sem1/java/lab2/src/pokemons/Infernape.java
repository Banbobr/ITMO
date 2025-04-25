package pokemons;

import ru.ifmo.se.pokemon.*;
import moves.physical.StoneEdge;

public final class Infernape extends Monferno {
    public Infernape(String name, int level) {
        super(name, level);
        setType(Type.FIRE, Type.FIGHTING);
        setStats(76, 104, 71, 104, 71, 108);
        addMove(new StoneEdge());
    }
}