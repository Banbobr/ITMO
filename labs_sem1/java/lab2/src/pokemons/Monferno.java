package pokemons;

import ru.ifmo.se.pokemon.*;
import moves.status.SlackOff;

public class Monferno extends Chimchar {
    public Monferno(String name, int level) {
        super(name, level);
        setType(Type.FIRE, Type.FIGHTING);
        setStats(64, 78, 52, 78, 52, 81);
        addMove(new SlackOff());
    }
}