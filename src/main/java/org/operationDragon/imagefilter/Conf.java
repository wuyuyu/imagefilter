package org.operationDragon.imagefilter;

import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;

public class Conf{
    private File input;
    private File output;
    private File logFile;
    private String filters;

    public void setInput(File input) {
        this.input = input;
    }

    public void setOutput(File output) {
        this.output = output;
    }

    public void setLogFile(File logFile) {
        this.logFile = logFile;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }


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


    public Conf(String filename,String outpuFileName,String filterName,String logfileName) throws IOException {
        input = new File(filename);
        output = new File(outpuFileName);
        logFile = new File(logfileName);
        filters = filterName;
    }

    public void loadFile(String configFile)throws IOException{
        System.out.println("configFile=" + configFile);
        Wini ini = new Wini(new File(configFile));
        File in = ini.get("Filter", "inputDir", File.class);
      //  System.out.println("in=["+in.getName() + "]");
        if(in != null){
            System.out.println("is different de null");
            input = in;
        }
       File out = ini.get("Filter", "outputDir", File.class);
        if(out != null){
            output = out;
        }
        File log = ini.get("Filter", "logFile", File.class);
        if(log != null) {
            logFile = log;
        }

       String fil = ini.get("Filter", "filters", String.class);
        if(fil != null){
            filters = fil;
        }
    }
}
