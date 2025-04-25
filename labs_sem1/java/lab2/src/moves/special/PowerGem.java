package moves.special;

import ru.ifmo.se.pokemon.*;

// Power Gem deals damage with no additional effect.

public final class PowerGem extends SpecialMove {
    public PowerGem() {
        super(Type.ROCK, 80, 100);
    }

    @Override
    protected String describe() {
        return "Использует Power Gem";
    }
}