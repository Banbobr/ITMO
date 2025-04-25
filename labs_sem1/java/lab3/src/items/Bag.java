package items;

import java.util.ArrayList;
import exceptions.ItemInBagException;

public class Bag {
    private final ArrayList<String> items;
    private int capacity;
    private final String owner;

    public Bag(String owner, int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
        this.owner = owner;
    }

    public void add(String item) {
        if (capacity == 0) {
            throw new RuntimeException(owner + " не смог сложить в мешок " + item + " потому что кончилось место");
        } else {
            items.add(item);
            capacity -= 1;
            System.out.println(owner + " сложил в мешок " + item);
        }
    }

    public void remove(String item) throws ItemInBagException {
    if (!items.remove(item)) {
            throw new ItemInBagException(owner, item);
        } else {
            System.out.println(owner + " выложил из мешка " + item);
        }
    }

    public void getItems() {
        if (items.isEmpty()) {
            System.out.println("Мешок " + owner + " пуст");
        } else {
            System.out.println("Список вещей в мешке " + owner + ": " + String.join(", ", items));
        }
    }

    public void clear() {
        items.clear();
        System.out.println(owner + "выложил все вещи из мешка");
    }

    public boolean checkEmpty() {
        return items.isEmpty();
    }
}