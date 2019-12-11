package org.operationDragon.imagefilter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.io.IOException;

public class App extends JavaCVHelper{
    /**
     * filters a document set into a file
     * @param input
     * @param filter
     */
    static void filterDossier (File input, Filter filter ){


        for (File f: input.listFiles()){
            if(f.getName().endsWith(".jpeg")) {
                String chemin;
                chemin = f.getAbsolutePath();

                try {
                    filter.process(chemin);
                }catch (Exception e){
                    e.getMessage();
                }
            }
        }
    }

    /**
     * Principle Method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
/**
 *  Allows to have interface in command line to access image folders
 */
        Options options = new Options();
        options.addOption("i",true,"input directory");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse( options, args);
        String inputArg = "";

        if(cmd.hasOption("i")){
            inputArg = cmd.getOptionValue("i");

        }


        File input = new File(inputArg);

        String filterArg = "dilatation";
        Filter filter = null;
/**
 *  Allows to identifies if the user has correctly entered the proposed program command
 */
        switch (filterArg){
            case "blur":
                filter = new FilterBlur();
                break;
            case "dilatation":
                filter = new FilterDilatation();
                break;
            case "blackWhite":
                filter = new FilterBlackWhite();
                break;
        }
        App.filterDossier(input,filter);

/**
 * Filters images from their absolute URL
 */
        try{
            FilterDilatation dilatation1 = new FilterDilatation();
            dilatation1.process("dragon.jpeg");
            FilterBlackWhite bw1 = new FilterBlackWhite();
            bw1.process("dragon2.jpeg");
            FilterBlur blur = new FilterBlur();
            blur.process("dragon3.jpeg");

            FilterDilatation dilatation2 = new FilterDilatation();
            dilatation2.process("text ");


        }catch (FilterException e){
            System.out.println(e.getMessage());
        }
    }
}
