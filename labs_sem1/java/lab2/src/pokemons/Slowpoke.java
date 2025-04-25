package pokemons;

import ru.ifmo.se.pokemon.*;
import moves.status.Growl;
import moves.special.Psychic;
import moves.status.Rest;

public class Slowpoke extends Pokemon {
    public Slowpoke(String name, int level) {
        super(name, level);
        setType(Type.WATER, Type.PSYCHIC);
        setStats(90, 65, 65, 40, 40, 15);
        setMove(new Growl(), new Psychic(), new Rest());
    }
}