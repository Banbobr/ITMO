package moves.physical;

import ru.ifmo.se.pokemon.*;

public final class AerialAce extends PhysicalMove {
    public AerialAce() {
        super(Type.FLYING, 60, 100);
    }

    @Override
    protected String describe() {
        return "Использует Aerial Ace";
    }
}