package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.opencv.core.Mat;

import java.io.File;

public class App {
    public static void main(String[] args) {

        File f = new File("dragon.jpeg");
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filterBlur(image);
​
        File outputDir = new File("output");
        File outputFile = new File(outputDir, "result.jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
    }
}
