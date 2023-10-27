import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.Console;

public class Cart {
    
    public static void main (String[] args) {
        System.out.println("Welcome to your shopping cart");
        List<String> shoppingCart = new LinkedList<>();
        Console cons = System.console(); //console takes in user input via terminal
        //
        //String inputString = myScanner.nextLine();
        //list();
        boolean stop = false;
        while(!stop){
            String input = cons.readLine("> ");
            Scanner myScanner = new Scanner(input); //turns the user input (from console) to a scanner object
            String cmd = myScanner.next(); //scanner is the one that reads the strings to find certain delimiters
            switch (cmd) {
                case "stop":
                stop = true;
                break;
                case "list":
                list(shoppingCart);
                break;
                case "add":
                add(shoppingCart,myScanner);
                break;
                case "delete":
                delete(shoppingCart, myScanner);
                break;
                default:
                System.out.println("Invalid command.");
            }
            myScanner.close();
        }
        System.out.println("Bye");

    } 
    static void list(List<String> q){
        System.out.println("List called");
        if(q.isEmpty()){
            System.out.println("Shopping cart is empty.");
        }
        else{
            Integer i = 1;
            for (String item : q){
                System.out.println(String.format("%d. %s", i, item));
                i++;
            }
            //System.out.println(q);
        }
    }
    static void add(List<String> q, Scanner myScanner){
        System.out.println("add called");
        myScanner.useDelimiter("\\s*,\\s*");
        while(myScanner.hasNext()){
            String fruit = myScanner.next().trim();
            if(q.contains(fruit)){
                System.out.println(fruit+" exists.");
            }
            else{
                q.add(fruit);
            }
        }

    }
    static void delete(List<String> q, Scanner myScanner){
        String num = myScanner.next();
        int order = Integer.valueOf(num);
        if (order < q.size()){
            q.remove(order);
            System.out.println("Item deleted.");
        }
        else{
            System.out.println("Invalid index.");
        }
     
        //System.out.println("delete called");

    }
}
