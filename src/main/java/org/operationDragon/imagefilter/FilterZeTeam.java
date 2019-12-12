package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;

public class FilterZeTeam implements Filter{

    public Mat process(String imageName, File outputDirectory) throws FilterException{

        File img = new File(imageName);
        System.out.println(img);
        Mat image = opencv_imgcodecs.imread(imageName);
        String outputPath = outputDirectory.getAbsolutePath();

}
