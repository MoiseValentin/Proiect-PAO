package service;

import product.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PizzaService extends view.Main{
    private static PizzaService service;
    DatabaseService externalDatabase;
    Audit log = new Audit();


    public static PizzaService PizzaService() throws IOException, FileNotFoundException {
        if (service == null) {
            service = new PizzaService();
            return service;
        }
        return service;
    }
    public void serviceMode() throws IOException, FileNotFoundException
    {
        int typeOfService=1;
        while (typeOfService != 0) {
            System.out.println("Select desired service:");
            System.out.println("0. Back");
            System.out.println("1. Add product in DB");
            System.out.println("2. Remove product from DB");
            System.out.println("3. List database");
            System.out.println("4. See Daily History");
            System.out.println("5. Close the register");
            System.out.println("6. Import DB");
            System.out.println("7. Export DB");


            typeOfService = this.s.nextInt();

            switch (typeOfService) {
                case 0:
                    break;
                case 1:


                    System.out.println("\t product type: ");
                    System.out.println("\t 1.Alcoholic Drink ");
                    System.out.println("\t 2.Non-Alcoholic Drink ");
                    System.out.println("\t 3.Pizza ");
                    System.out.println("\t 4.Salad ");
                    int typeOfProduct = this.s.nextInt();
                    System.out.println("\t Name:");
                    String nameOfProduct = this.s.next();
                    System.out.println("\t Price:");
                    double priceOfProduct = this.s.nextDouble();


                    if (typeOfProduct == 1) {
                        System.out.println("\t Alcohol percentage: ");
                        Product p = new AlcoholicDrink(nameOfProduct, priceOfProduct, s.nextDouble());
                        if (this.db.contains(p)) {
                            System.out.println("product already in database");
                        } else
                            this.db.addProduct(p);

                    }
                    if (typeOfProduct == 2) {
                        Product p = new Drink(nameOfProduct, priceOfProduct);
                        if (this.db.contains(p)) {
                            System.out.println("product already in database");
                        } else {
                            this.db.addProduct(p);
                        }
                    }
                    if (typeOfProduct == 3) {
                        System.out.println("\t Is pizza vegetarian? ");
                        Product p = new Pizza(nameOfProduct, priceOfProduct, s.nextBoolean());
                        if (this.db.contains(p)) {
                            System.out.println("product already in database");
                        } else {
                            this.db.addProduct(p);
                        }
                    }
                    if (typeOfProduct == 4) {
                        System.out.println("\t Salad type: ");
                        Product p = new Salad(nameOfProduct, priceOfProduct, this.s.next());
                        if (this.db.contains(p)) {
                            System.out.println("product already in database");
                        } else {
                            this.db.addProduct(p);
                        }
                    }

                    log.addToLog("src/auditLog/log.csv","ADD_PRODUCT_TO_DB");
                    break;
                case 2:
                    System.out.println("Name of the product you want to delete: ");
                    String itemToDelete = this.s.next();
                    if (this.db.contains(itemToDelete)) {
                        this.db.removeProduct(itemToDelete);
                    } else
                        System.out.println("product not in the DataBase!");
                    log.addToLog("src/auditLog/log.csv","REMOVE_PRODUCT_FROM_DB");
                    break;
                case 3:
                    System.out.println(this.db.getProductList());
                    log.addToLog("src/auditLog/log.csv","LIST_PRODUCTLIST");
                    break;
                case 4:
                    log.addToLog("src/auditLog/log.csv","SEE_DAILY_HISTORY");
                  //  System.out.println(this.dl);
                    break;
                case 5:

                    log.addToLog("src/auditLog/log.csv","CLOSE_THE_REGISTER");
                    break;
                case 6:
                    externalDatabase = new DatabaseService();
                    externalDatabase.importDatabase("src/database/database.csv");
                    log.addToLog("src/auditLog/log.csv","IMPORT_DATABASE");
                    break;
                case 7:
                    externalDatabase = new DatabaseService();
                    externalDatabase.exportDatabase("src/database/database.csv");
                    log.addToLog("src/auditLog/log.csv","EXPORT_DATABASE");
                    break;


            }
        }
    }
}
