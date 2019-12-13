package org.operationDragon.imagefilter;

import org.apache.commons.cli.*;

import java.io.File;

public class App {


    /**
     * filters all images of a directory
     * @param inputDirectory : directory where input images are stored
     * @param filter : filter to apply
     * @param outputDirectory : directory where to put filtered images
     * @param filename : name of the log's file
     *
     */
    static void applyFilterOnImages (File inputDirectory, Filter filter, File outputDirectory,String filename ){

        for (File f: inputDirectory.listFiles()){
            if(f.getName().endsWith(".jpeg")) {
                String chemin;
                chemin = f.getAbsolutePath();

                try {
                    filter.process(chemin, outputDirectory,filename);
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
        options.addOption("f",true,"filter to apply");
        options.addOption("h",false,"help");
        options.addOption("configfile",true,"config file");
        options.addOption("listFilter",false,"list of filters");
        Conf conf = new Conf("input","output","Dilatation","imagefilter.log");

        System.out.printf("default filter to apply=" + conf.getFilters() + "\n");


        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse( options, args);

        if(cmd.hasOption("listFilter")){
            System.out.println("FilterBlackWhite");
            System.out.println("FilterBlur");
            System.out.println("FilterDilatation");
            System.out.println("FilterZeTeam");
            return;

//            Reflections reflections = new Reflections();
//
//            Set<Class<? extends Filter>> subTypesOf = reflections.getSubTypesOf(Filter.class);
//
//            System.out.println("Filters =" + subTypesOf.toString());
//            return;
        }


        if(cmd.hasOption("configfile")) {
            String configArg = cmd.getOptionValue("configfile");
            conf.loadFile(configArg);
        }

        if(cmd.hasOption("i")){
            conf.setInput(new File(cmd.getOptionValue("i")));
        }

        if(cmd.hasOption("o")){
            conf.setOutput(new File(cmd.getOptionValue("o")));
        }

        if(cmd.hasOption("f")){
            conf.setFilters(cmd.getOptionValue("f"));
        }

        if(cmd.hasOption("h")){
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("App", "", options, "", true);
            return;
        }


/**
 *  Allows to identifies if the user has correctly entered the proposed program command
 */
        Filter filter = null;
        System.out.printf("filter to apply=" + conf.getFilters());
        switch (conf.getFilters()){
            case "Blur":
                filter = new FilterBlur();
                break;
            case "Dilatation":
                filter = new FilterDilatation();
                break;
            case "BlackWhite":
                filter = new FilterBlackWhite();
                break;
            case "ZeTeam":
                filter = new FilterZeTeam();
                break;

            default:
                System.out.println("unknown filter " + conf.getFilters());

        }
        App.applyFilterOnImages(conf.getInput(),filter,conf.getOutput(),conf.getLogFile().getAbsolutePath());

    }
}
