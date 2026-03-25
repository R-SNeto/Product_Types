package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainUI {

    private static Scanner scanner = new Scanner(System.in);

    private List<Product> productList = new ArrayList<>();


    public void userInterface (){

        System.out.print("Enter the number of products: ");
        int numberProducts = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < numberProducts; i++){

            String type = productType(scanner);
            System.out.println("\nPRODUCT #" + (i+1) + " DATA:\n");
            System.out.print("Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Product Price: ");
            Double price = Double.parseDouble(scanner.nextLine());

            switch (type){
                case "COMMON":
                    Product prod = new Product(name, price);
                    productList.add(prod);
                    break;

                case "USED":
                    System.out.print("Manufacture date (dd/MM/yyyy): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Product usedProd = new UsedProduct(name, price, date);
                    productList.add(usedProd);
                    break;

                case "IMPORTED":
                    System.out.print("Customs Fee: ");
                    Double fee = Double.parseDouble(scanner.nextLine());

                    Product importedProd = new ImportedProduct(name, price, fee);
                    productList.add(importedProd);
                    break;
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");

        for(Product p : productList){
            System.out.println(p.priceTag());
        }

        scanner.close();
    }

    public String productType(Scanner scanner){

        System.out.println("        PRODUCT TYPE       ");
        System.out.println("---------------------------");
        System.out.println("Common");
        System.out.println("Used");
        System.out.println("Imported");
        System.out.println("---------------------------");
        System.out.print("Choose: ");
        return scanner.nextLine().trim().toUpperCase();
    }

}
