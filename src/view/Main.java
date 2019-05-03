package view;

import database.Database;
import product.Product;
import service.DatabaseService;
import service.PizzaService;
import java.io.*;
import java.util.*;


public class Main {
    protected static Scanner s = new Scanner(System.in);
    protected static Database db = new Database();
    protected static Product newProduct;
    private static PizzaService serviceClass = new PizzaService();
    public static void main(String[] args) throws IOException {

        DatabaseService firstImport;
        firstImport = new DatabaseService();
        firstImport.importDatabase("src/database/database.csv");

        serviceClass.serviceMode();
    }
}
