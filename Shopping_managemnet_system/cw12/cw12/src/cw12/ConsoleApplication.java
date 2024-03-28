package cw12;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleApplication {

    public static Scanner input = new Scanner(System.in);
    private static WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();

    public static void main(String args[]) throws IOException {

        while(true){
            displayMenu();
            //input the command user want to do

            String menu=input.next();
            switch(menu){
                case "1":
                    addProductToSystem();
                    break;
                case "2":
                    deleteProductFromSystem();
                    break;
                case "3":
                    printSystemProducts();
                    break;
                case "4":
                    shoppingManager.saveInFile();
                    break;
                case "5":
                    shoppingManager.loadDataFromFile();
                    break;
                case "6":
                    shoppingManager.openGUI();
                    // Handle GUI functionality
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid option.");

            }
        }
    }
    private static void displayMenu() {
        shoppingManager.displayMenu();
    }
    private static void printSystemProducts() {
        System.out.println("System product details: ");
        shoppingManager.printProductList();
    }

    private static void deleteProductFromSystem() {
        System.out.println("enter product Id if you want to delete :");
        String delProductId=input.next();
        shoppingManager.deleteProduct(delProductId);
    }

    private static void addProductToSystem() {
        System.out.println("enter a for add electronic item and enter b for add cloth");
        String item=input.next();

        Product newProduct = null;

        //add a electronic product
        if(item.equalsIgnoreCase("a")) {
            System.out.println("enter the electronic item product id");
            String ProductId = input.next();
            while(!ProductId.matches("[0-9a-zA-Z]+")){
             System.out.println("Please enter a valid product id!");
            ProductId= input.next(); 
            }  
            
            System.out.println("enter the electronic item product name");
            String productName = input.next();
            while(!productName.matches("[0-9a-zA-Z]+")){
             System.out.println("Please enter a valid product name!");
            productName= input.next(); 
            }  
            
            System.out.println("enter the electronic item brand");
            String electronicItemBand = input.next();
            while(!electronicItemBand.matches("[0-9a-zA-Z]+")){
             System.out.println("Please enter a valid electronic item brand!");
            electronicItemBand= input.next(); 
            }  
            
            System.out.println("enter the  electronic item warranty period");
            String electronicItemWarrantPeriod = input.next();
            while(!electronicItemWarrantPeriod.matches("[0-9a-zA-Z]+")){
             System.out.println("Please enter a valid warrenty period!");
            electronicItemWarrantPeriod= input.next(); 
            }  
            
            System.out.println("enter the electronic item num of available items");
            int electronicItemAvailableItems = input.nextInt();
            
            
            System.out.println("enter the electronic item price");
            double productPrice = input.nextDouble();

            newProduct = new Electronic(ProductId, productName, electronicItemAvailableItems, productPrice, electronicItemBand, electronicItemWarrantPeriod);

        } else if (item.equalsIgnoreCase("b")) {
            System.out.println("enter the cloth item product id");
            String ProductId = input.next();
            while(!ProductId.matches("[0-9a-zA-Z]+")){
             System.out.println("Please enter a valid product id!");
            ProductId= input.next(); 
            }
            
            System.out.println("enter the cloth item product name");
            String productName = input.next();
            while(!productName.matches("[0-9a-zA-Z]+")){
             System.out.println("Please enter a valid product name!");
            productName= input.next(); 
            }
            
            System.out.println("enter the cloth item size");
            String clothItemSize= input.next();
            while(!clothItemSize.matches("[0-9a-zA-Z]+")){
             System.out.println("Please enter a valid cloth item size!");
            clothItemSize= input.next(); 
            }
            
            System.out.println("enter the  cloth item colour");
            String clothItemColour = input.next();
            while(!clothItemColour.matches("[0-9a-zA-Z]+")){
             System.out.println("Please enter a valid clothItem colour!");
            clothItemColour= input.next(); 
            }
            
            System.out.println("enter the cloth item num of available items");
            int clothItemAvailableItems = input.nextInt();
            
            
            
            System.out.println("enter the cloth item price");
            double productPrice = input.nextDouble();

            newProduct = new Clothes(ProductId, productName, clothItemAvailableItems, productPrice, clothItemSize, clothItemColour);

        }else {
            System.out.println("Invalid option given !");
            return;
        }

        shoppingManager.addProduct(newProduct);
    }
}
