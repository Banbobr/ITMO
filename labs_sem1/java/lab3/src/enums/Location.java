package enums;

public enum Location {
    FOREST("Заповедный лес"),
    HOME("Дом");

    private final String title;
    Location(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}