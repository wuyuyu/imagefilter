package org.operationDragon.imagefilter;

import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;

public class Conf{
    private File input;
    private File output;
    private File logFile;
    private String filters;

    public File getInput() {
        return input;
    }

    public File getOutput() {
        return output;
    }

    public File getLogFile() {
        return logFile;
    }

    public String getFilters() {
        System.out.println("filtretest="+filters);
        return filters;
    }



    public Conf(String filename) throws IOException {
        System.out.println(filename);
        Wini ini = new Wini(new File(filename));
        input = ini.get("Filter", "inputDir", File.class);
        output = ini.get("Filter", "outputDir", File.class);
        logFile = ini.get("Filter", "logFile", File.class);
        filters = ini.get("Filter", "filters", String.class);


    }

}
