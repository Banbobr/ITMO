package pokemons;

import ru.ifmo.se.pokemon.*;
import moves.physical.AerialAce;
import moves.status.Rest;
import moves.special.Ember;
import moves.status.Confide;

public final class Moltres extends Pokemon {
    public Moltres(String name, int level) {
        super(name, level);
        setType(Type.FIRE, Type.FLYING);
        setStats(90, 100, 90, 125, 85, 90);
        setMove(new AerialAce(), new Rest(), new Ember(), new Confide());
    }
}