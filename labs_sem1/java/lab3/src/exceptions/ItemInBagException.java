package exceptions;

public class ItemInBagException extends Exception {
    private final String owner;
    private final String item;

    public ItemInBagException(String owner, String item) {
        this.owner = owner;
        this.item = item;
    }

    @Override
    public String getMessage() {
        return owner + " не смог выложить " + item + " потому что его нет в мешке";
    }
}
