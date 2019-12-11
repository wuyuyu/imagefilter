package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;

public class FilterBlur extends JavaCVHelper{


    public FilterBlur(String imageName) throws FilterException{
        File img = new File(imageName);
        Mat image = opencv_imgcodecs.imread(img.getAbsolutePath());
        String [] name = imageName.split("\\.");
        image = filterBlur(image);
        File outputDir = new File("output");
        String outputName = name[0] + "_blur." + name[1];
        File outputFile = new File(outputDir, outputName);
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
    }


}