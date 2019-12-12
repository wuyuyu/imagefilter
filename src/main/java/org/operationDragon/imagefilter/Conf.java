package org.operationDragon.imagefilter;

import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;

public class Conf {

    public Conf() {
    }

    static void sample01(String filename)throws IOException {
        System.out.println(filename);
        Wini ini = new Wini(new File(filename));
        File input = ini.get("Filter", "inputDir", File.class);
        File output = ini.get("Filter", "outputDir", File.class);
        File logFile = ini.get("Filter", "logFile", File.class);
        String filters = ini.get("Filter", "filters", String.class);
        System.out.println("input="+ input);
        System.out.println("output="+ output);
        System.out.println("logfile="+ logFile);
        System.out.println("filters="+ filters);



    }
}
