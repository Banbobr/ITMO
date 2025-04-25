package moves.special;

import ru.ifmo.se.pokemon.*;

// Psychic deals damage and has a 10% chance of lowering the target's Special Defense by one stage.

public final class Psychic extends SpecialMove {
    public Psychic() {
        super(Type.PSYCHIC, 90, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.1) {
            p.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }

    @Override
    protected String describe() {
        return "Использует Psychic";
    }
}