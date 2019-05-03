package service;

import product.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

public class Audit {

    Timestamp time;
    private static Audit log;
    public static Audit Log() {
        if(log == null) {
            log = new Audit();
        }
        return log;
    }


    public void addToLog(String filePath,String action) throws IOException {
        FileWriter fw = new FileWriter(filePath,true);

        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);


        time=new Timestamp(System.currentTimeMillis());
        printWriter.println(action+","+time);

        printWriter.flush();
        printWriter.close();
    }
}
