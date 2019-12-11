package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.imgproc.Imgproc;

import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.*;

public class FilterBlur implements Filter{
    @Override
    public Mat process(String imageName) throws FilterException{
        File img = new File(String.valueOf(imageName));
        Mat image = opencv_imgcodecs.imread(img.getAbsolutePath());

        try {
            int size = 3;
            Mat result = image.clone();
            GaussianBlur(image, result, new Size(size, size), 0);
            String [] name = imageName.split("\\.");
            File outputDir = new File("output");
            String outputName = name[0] + "_blur." + name[1];
            File outputFile = new File(outputDir, outputName);
            opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);

            return result;
        }catch (Exception e){
            throw new FilterException("Problème de filtre flou");
        }
    }

}

/*
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

 */

