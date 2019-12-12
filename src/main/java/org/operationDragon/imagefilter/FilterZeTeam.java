package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.opencv.core.Core;
import org.opencv.core.Point;

import java.io.File;

public class FilterZeTeam implements Filter{

    public Mat process(String imageName, File outputDirectory) throws FilterException{



        File img = new File(imageName);
        System.out.println(img);
        Mat image = opencv_imgcodecs.imread(imageName);
        String outputPath = outputDirectory.getAbsolutePath();
        String [] name = img.getName().split("\\.");
        String outputName = name[0] + "_zeTeam" + name[1];
        File ouputFile = new File(outputPath, outputName);
        System.out.println(image);
       Mat result =opencv_imgproc.putText((image) "chips", new Point( 2,  2), null, 1, Scalar.GREEN);
       opencv_imgcodecs.imwrite(ouputFile.getAbsolutePath(), result);
         return result;
    }
