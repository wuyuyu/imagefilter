package org.operationDragon.imagefilter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import java.io.File;

public class App extends JavaCVHelper{
    /**
     * filters a document set into a file
     * @param input
     * @param filter
     */
    static void applyFilterOnImages (File inputDirectory, Filter filter, File outputDirectory ){

        for (File f: inputDirectory.listFiles()){
            if(f.getName().endsWith(".jpeg")) {
                String chemin;
                chemin = f.getAbsolutePath();

                try {
                    filter.process(chemin, outputDirectory);
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
        options.addOption("o",true,"output directory");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse( options, args);

        String inputArg = "input"; // Valeur par défaut du répertoire d'entrée

        if(cmd.hasOption("i")){
            inputArg = cmd.getOptionValue("i");
        }

        File input = new File(inputArg);

        CommandLineParser parser1 = new DefaultParser();
        CommandLine cmd1 = parser1.parse(options,args);

        String outputArg = "caca"; // Valeur par défaut du répertoire de sortie
        if(cmd1.hasOption("o")){
            outputArg =cmd1.getOptionValue("o");
        }

        File output = new File(outputArg);

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
        App.applyFilterOnImages(input,filter, output);
    }
}
