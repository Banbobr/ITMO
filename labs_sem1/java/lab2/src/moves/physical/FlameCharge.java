package moves.physical;

import ru.ifmo.se.pokemon.*;

// Flame Charge deals damage and raises the user's Speed by one stage.

public final class FlameCharge extends PhysicalMove {
    public FlameCharge() {
        super(Type.FIRE, 50, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.SPEED, 1);
    }

    @Override
    protected String describe() {
        return "Использует Flame Charge";
    }
}