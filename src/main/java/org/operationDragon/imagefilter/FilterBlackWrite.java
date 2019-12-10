package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;

import static java.util.Locale.filter;

public class FilterBlackWrite extends JavaCVHelper {

    void process (){
        File f = new File("dragon.jpeg");

        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filterGrayscale(image);
        File outputDir = new File("output");
        File outputFile = new File(outputDir, "result.jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);

        f = new File("dragonmignon2.jpeg");

        image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filterGrayscale(image);
        outputDir = new File("output");
        outputFile = new File(outputDir, "result2.jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
    }

    void processGeneral (File f, Mat filter,){
        File f = new File("dragon.jpeg");

        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filter(image);
        File outputDir = new File("output");
        File outputFile = new File(outputDir, "result.jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
    }

}
