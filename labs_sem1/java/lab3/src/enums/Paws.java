package enums;

public enum Paws {
    BACK("на задних лапах"),
    FRONT("на передних лапах");

    private final String typePaws;
    Paws(String typePaws) {
        this.typePaws = typePaws;
    }

    public String getTypePaws() {
        return typePaws;
    }
}
