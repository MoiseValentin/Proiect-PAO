package service;

import product.*;

import java.io.*;
import java.util.List;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class DatabaseService extends view.Main  {


    public void importDatabase(String filePath) throws IOException
    {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(",");

            switch (values[0]) {
                case "Drink":
                    this.newProduct = new Drink(values[1], parseFloat(values[2]));
                    this.db.addProduct(this.newProduct);
                    break;
                case "AlcoholicDrink":
                    this.newProduct = new AlcoholicDrink(values[1], parseFloat(values[2]), Double.parseDouble(values[3]));
                    this.db.addProduct(this.newProduct);
                    break;
                case "Pizza":
                    this.newProduct = new Pizza(values[1], parseFloat(values[2]), Boolean.parseBoolean(values[3]));
                    this.db.addProduct(this.newProduct);
                    break;
                case "Salad":
                    this.newProduct = new Salad(values[1], parseFloat(values[2]), values[3]);
                    this.db.addProduct(this.newProduct);
                    break;
            }


        }
        bufferedReader.close();
    }

    public void exportDatabase(String filePath) throws IOException
    {
        FileWriter fw = new FileWriter(filePath,false);

        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        List<Product> tempProdList = this.db.getProductList();
        for (int i = 0 ; i< tempProdList.size();i++)

            printWriter.println(tempProdList.get(i));
        printWriter.flush();
        printWriter.close();
    }
}
