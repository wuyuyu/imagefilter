package org.operationDragon.imagefilter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/
public class LogWriter {
    /**
     * Function that allows to write in a file
     * @param message string message
     * @param filename file's name where to write
     */
    void logToFile(String message,String filename ) {

        try {
            File f = new File(filename);
            FileWriter fileWriter = new FileWriter(f, true);
            fileWriter.write(message + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}