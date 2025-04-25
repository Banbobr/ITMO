package pokemons;

import ru.ifmo.se.pokemon.*;
import moves.special.PowerGem;

public final class Slowking extends Slowpoke {
    public Slowking(String name, int level) {
        super(name, level);
        setType(Type.WATER, Type.PSYCHIC);
        setStats(95, 75, 80, 100, 110, 30);
        addMove(new PowerGem());
    }
}