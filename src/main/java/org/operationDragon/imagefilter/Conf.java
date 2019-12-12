package org.operationDragon.imagefilter;

import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;

public class Conf {

    public Conf() {
    }

    static void sample01(String filename)throws IOException {
        Wini ini = new Wini(new File(filename));
        File input = ini.get("Filter", "inputDir", File.class);
        File output = ini.get("Filter", "outputDir", File.class);
        File logFile = ini.get("Filter", "logFile", File.class);
        Filter filters = ini.get("Filter", "filters", Filter.class);
    }
}
