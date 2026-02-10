import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Week5 {
    static List<Fruit> fruits;

    public static void main(String[] args) {
        // initialize fruits array list
        fruits = new ArrayList<>();

        // load or read the data
        loadData();

        displayMenu();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choice: ");
        int c = sc.nextInt();
        sc.nextLine(); // clear extra \n

        switch (c) {
            case 1:
                displayData();
                break;
            case 2:
                String keyword = "";
                System.out.print("Enter keyword: ");
                keyword = sc.nextLine();
                search(keyword);
                break;
            case 3:
                //new record
                Fruit f = new Fruit();
                System.out.println("Enter fruit name: ");
                f.name = sc.nextLine();
                System.out.println("Enter ngolor: ");
                f.color = sc.nextLine();
                System.out.println("Enter price: ");
                f.price = sc.nextFloat();
                System.out.println("Enter shelf life: ");
                f.shelfLife = sc.nextInt();
                fruits.add(f);
                saveData();

                break;
            case 4:
                //update record
                System.out.println("Enter index of fruit: ");
                int i = sc.nextInt();
                sc.nextLine(); 
                if(i < fruits.size() && i >= 0 ){
                    Fruit ff = fruits.get(i);
                    System.out.println("Enter new name. Skip if you want retain. ("+ ff.name + "): ");
                    String name = sc.nextLine();
                    ff.name = name.trim().equals("") ? ff.name : name;

                    System.out.println("Enter new color. Skip if you want retain. ("+ ff.color + "): ");
                    String color = sc.nextLine();
                    ff.color = color.trim().equals("") ? ff.color : color;

                    //do the same process for the other fields
                }else{
                    System.out.println("Fruit to be updated not found...");
                }
            case 0:
                saveData();
                
                System.out.println("Program Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }

    public static float tryParseFloat(String value) {
        float parsed = -1;
        try {
            parsed = Float.parseFloat(value);
        } catch (NumberFormatException e) {
            // System.out.println("");
        }
        return parsed;
    }

    public static float tryParseInt(String value) {
        int parsed = -1;
        try {
            parsed = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // System.out.println("");
        }
        return parsed;
    }

    public static void search(String s){
        System.out.println("Search results:");
        int count = 0;
        
        //linear search
        /*
        for(Fruit f : fruits){
            if (f.name.toLowerCase().contains(s.toLowerCase()) ||
                f.color.toLowerCase().contains(s.toLowerCase()) ||
                f.price == tryParseFloat(s) ||
                f.shelfLife == tryParseInt(s)
                ){
                count++;
                System.out.printf("%-13s %-8s %.2f %4d\n", f.name, f.color, f.price, f.shelfLife);
            }
        } */

        //lambda expressions -> anonymous functions, treated like an object and is as arguments to some methods
        
        //streams
        List<Fruit> filtered = fruits.stream().filter(fruit -> 
                fruit.name.toLowerCase().contains(s.toLowerCase()) 
                || fruit.color.toLowerCase().contains(s.toLowerCase()) 
                || fruit.price == tryParseFloat(s) 
                || fruit.shelfLife == tryParseInt(s)
        ).toList();
        
        for(Fruit f : filtered){
            System.out.printf("%-13s %-8s %.2f %4d\n", f.name, f.color, f.price, f.shelfLife);

        }

        if(filtered.size() == 0)
            System.out.println("No results found...");

    }

    public static void saveData(){
        StringBuilder data = new StringBuilder("Fruit Name,Color,Price,Shelf Life");
        for(Fruit f: fruits){
            data.append("\n")
            .append(f.name).append(",")
            .append(f.color).append(",")
            .append(f.price).append(",")
            .append(f.shelfLife);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("data.csv"))){
            bw.write(data.toString());
            bw.close();
            System.out.println("File saved...");
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

    public static void displayData() {
        System.out.println("Fruit Name    Color    Price    Shelf Life");
        /*
         * for(int i = 0; i < fruits.size(); i++){
         * Fruit f = fruits.get(i);
         * System.out.printf("%-13s %-8s %.2f %4d\n", f.name, f.color, f.price,
         * f.shelfLife);
         * }
         */
        for (Fruit f : fruits) {
            System.out.printf("%-13s %-8s %.2f %4d\n", f.name, f.color, f.price, f.shelfLife);
        }
    }

    public static void displayMenu() {
        System.out.println("""
                Menu
                1. Display
                2. Search
                3. New fruit
                4. Edit
                0. Exit
                    """);
    }

    public static void loadData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.csv"));
            String line;
            br.readLine(); // discard header
            while ((line = br.readLine()) != null) {
                // convert the `line` into String array
                String[] arr = line.split(",");
                Fruit f = new Fruit();
                f.name = arr[0];
                f.price = Float.parseFloat(arr[2]);
                f.color = arr[1];
                f.shelfLife = Integer.parseInt(arr[3]);
                fruits.add(f); // add the current fruit to current available slot of the array

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Fruit {
    String name;
    String color;
    float price;
    int shelfLife;
}

//classes and objects