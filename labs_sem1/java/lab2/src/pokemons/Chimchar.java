package pokemons;

import ru.ifmo.se.pokemon.*;
import moves.physical.FlameCharge;
import moves.status.DoubleTeam;

public class Chimchar extends Pokemon {
    public Chimchar(String name, int level) {
        super(name, level);
        setType(Type.FIRE);
        setStats(44, 58, 44, 58, 44, 61);
        setMove(new FlameCharge(), new DoubleTeam());
    }
}