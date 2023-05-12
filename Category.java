package SpendingDraft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Category {
    static HashMap<String, Item> boats = new HashMap<>();
    static HashMap<String, Item> planes = new HashMap<>();
    static HashMap<String, Item> cars = new HashMap<>();
    
    public static void Map() {
        // define the items for each subcategory
        boats.put("Fishing", new Boat(10000));
        boats.put("Yacht", new Boat(185000000));
        boats.put("Cruise", new Boat(1300000000));

        planes.put("Cessna", new Plane(75000));
        planes.put("G700", new Plane(75000000));
        planes.put("BBJ", new Plane(250000000));

        cars.put("Toyota", new Cars(25000));
        cars.put("Lambo", new Cars(225000));
        cars.put("Buggati", new Cars(5000000));
        cars.put("Ferrari", new Cars(38000000));
    }

    public static int buyItem(HashMap<String, Item> chosenItems, Scanner scanner) {
        // get the player's choice of item
        System.out.print("Enter your choice: ");
        String itemChoice = scanner.next();

        // validate the player's choice of item
        if (!chosenItems.containsKey(itemChoice)) {
            System.out.println("Invalid item choice. Please try again.");
            return 0;
        }

        // print the player's purchase information
        int itemPrice = chosenItems.get(itemChoice).getPrice();
        System.out.println("You have purchased a " + itemChoice + " for $" + itemPrice + ".");
        return itemPrice;
        
    }

    public static int ChooseItem(String[] args) {
        ArrayList<Integer> receipt = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a subcategory:");
        System.out.println("1. Boats");
        System.out.println("2. Planes");
        System.out.println("3. Cars");

        // get the player's choice of subcategory
        System.out.print("Enter your choice: 1, 2, or 3? ");
        int subcategoryChoice = scanner.nextInt();

        // validate the player's choice of subcategory
        if (subcategoryChoice < 1 || subcategoryChoice > 3) {
            System.out.println("Invalid subcategory choice. Please try again.");
            return 0;
        }

        HashMap<String, Item > chosenItems;
        switch (subcategoryChoice) {
            case 1:
                chosenItems = boats;
                System.out.println("Items available in Boats category:");
                for (String item : boats.keySet()) {
                    System.out.println("- " + item + " ($" + boats.get(item).getPrice() + ")");
                }
                break;
            case 2:
                chosenItems = planes;
                System.out.println("Items available in Planes category:");
                for (String item : planes.keySet()) {
                    System.out.println("- " + item + " ($" + planes.get(item).getPrice() + ")");
                }
                break;
            case 3:
                chosenItems = cars;
                System.out.println("Items available in Cars category:");
                for (String item : cars.keySet()) {
                    System.out.println("- " + item + " ($" + cars.get(item).getPrice() + ")");
                }
                break;
            default:
                chosenItems = new HashMap<>();
        }

        return buyItem(chosenItems, scanner);

    }
}

