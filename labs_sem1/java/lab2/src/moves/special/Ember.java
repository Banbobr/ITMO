package moves.special;

import ru.ifmo.se.pokemon.*;

// Ember deals damage and has a 10% chance of burning the target.

public final class Ember extends SpecialMove {
    public Ember() {
        super(Type.FIRE, 40, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.1) {
            Effect.burn(p);
        }
    }

    @Override
    protected String describe() {
        return "Использует Ember";
    }
}