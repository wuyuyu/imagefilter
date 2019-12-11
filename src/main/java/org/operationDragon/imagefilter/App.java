package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.io.IOException;

public class App extends JavaCVHelper{
    public static void main(String[] args) throws Exception {
        /*
        FilterDilatation.process("dragon.jpeg");
        File outputDir = new File("output");
        String outputName = name[0] + "_dilate." + name[1];
        File outputFile = new File(outputDir, outputName);
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);

         */

        File f = new File("imagefilter.log");


        try{
            // TODO gérer exception qd le fichier n'existe pas :(
            new FilterBlur("dragonmignon.jpeg");
            new FilterBlackWhite("dragonmignon.jpeg");
            new FilterBlackWhite("dragon3.jpeg");
            new FilterBlackWhite("dragon.jpeg");

            FilterDilatation dilatation1 = new FilterDilatation();


            dilatation1.process();







        }catch (FilterException e){

            System.out.println(e.getMessage());
        }
    }
}
