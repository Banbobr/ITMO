package moves.status;

import ru.ifmo.se.pokemon.*;

// Growl lowers the target's Attack by one stage.

public final class Growl extends StatusMove {
    public Growl() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.ATTACK, -1);
    }

    @Override
    protected String describe() {
        return "Использует Growl";
    }
}