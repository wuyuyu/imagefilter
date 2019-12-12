package org.operationDragon.imagefilter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {
   // private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    void logToFile(String message) {

     //   String timestampStr = sdf.format(new Date());
        try {
            File f = new File("imagefilter.log");
            FileWriter fileWriter = new FileWriter(f, true);
            fileWriter.write(message + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}