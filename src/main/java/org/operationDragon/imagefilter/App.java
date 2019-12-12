package org.operationDragon.imagefilter;

import org.apache.commons.cli.*;
import org.reflections.Reflections;

import java.io.File;
import java.util.Set;

public class App extends Conf{


    /**
     * filters a document set into a file
     * @param inputDirectory : directory where input images are stored
     * @param filter : filter to apply
     * @param outputDirectory : directory where to put filtered images
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
        options.addOption("h",false,"help");
        options.addOption("configfile",true,"config file");
        options.addOption("listFilter",false,"list of filters");


        CommandLineParser parser = new DefaultParser();
        CommandLine cmd2 = parser.parse( options, args);

        if(cmd2.hasOption("listFilter")){
            Reflections reflections = new Reflections();

            Set<Class<? extends Filter>> subTypesOf = reflections.getSubTypesOf(Filter.class);

            System.out.println("Filters =" + subTypesOf);

        }



        CommandLineParser parser2 = new DefaultParser();
        CommandLine cmd = parser2.parse( options, args);

        if(cmd.hasOption("configfile")){
          String configArg = cmd.getOptionValue("configfile");
            System.out.println(configArg);
            File Conf = new File(configArg);
            sample01(Conf.getAbsolutePath());

        }

        String inputArg = "input"; // Valeur par défaut du répertoire d'entrée

        if(cmd.hasOption("i")){
            inputArg = cmd.getOptionValue("i");
        }


        File input = new File(inputArg);

        CommandLineParser parser1 = new DefaultParser();
        CommandLine cmd1 = parser1.parse(options,args);

        String outputArg = "output"; // Valeur par défaut du répertoire de sortie
        if(cmd1.hasOption("o")){
            outputArg =cmd1.getOptionValue("o");
        }


        File output = new File(outputArg);


        if(cmd1.hasOption("h")){
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("App", "", options, "", true);
            return;
        }

        String filterArg = "test";
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
            case "test":
                filter = new FilterZeTeam();
                break;

        }
        App.applyFilterOnImages(input,filter, output);

    }
}
