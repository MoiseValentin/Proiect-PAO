package service;

import java.io.*;
import java.sql.Timestamp;

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
    public void printLog(String filePath)  throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);

        }
        bufferedReader.close();
    }

}
