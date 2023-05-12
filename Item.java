package SpendingDraft;

import java.util.Random;

public class Item {
    int price;

    public Item(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class Boat extends Item {
    public Boat(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        Random r = new Random();
        int x = r.nextInt(10);
        if (x == 0) {
            return (int) Math.round(price * .8);
        } else {
            return Math.round(price);
        }
    }
}

class Cars extends Item {
    public Cars(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        Random r = new Random();
        int x = r.nextInt(5);
        if (x == 5) {
            return (int) Math.round(price * .5);
        } else {
            return Math.round(price);
        }
    }
}

class Plane extends Item {
    public Plane(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        Random r = new Random();
        int x = r.nextInt(10);
        if (x == 5) {
            return (int) Math.round(price * .9);
        } else {
            return Math.round(price);
        }
    }
}
