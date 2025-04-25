package moves.status;

import ru.ifmo.se.pokemon.*;

// Slack Off recovers up to 50% of the user's maximum HP.

public final class SlackOff extends StatusMove {
    public SlackOff() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.HP, (int) p.getStat(Stat.HP) / 2);
    }

    @Override
    protected String describe() {
        return "Использует Slack Off";
    }
}