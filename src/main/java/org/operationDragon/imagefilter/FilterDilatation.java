package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.imgproc.Imgproc;

import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.dilate;
import static org.bytedeco.opencv.global.opencv_imgproc.getStructuringElement;

public class FilterDilatation implements Filter{

    @Override
    public Mat process(String imageName) throws FilterException{
        File img = new File(String.valueOf(imageName));
        Mat image = opencv_imgcodecs.imread(img.getAbsolutePath());



        try {
            int size = 8;
            Mat result = image.clone();
            Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
            dilate(image, result, element);
            String [] name = imageName.split("\\.");
            File outputDir = new File("output");
            String outputName = name[0] + "_dilate." + name[1];
            File outputFile = new File(outputDir, outputName);
            opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
            return result;
        }catch (Exception e){
            throw new FilterException("Problème de filtre dilatation");
        }
    }
}

    /*
    public FilterDilatation(String imageName) throws FilterException {
        int size = 8;
        File img = new File(imageName);
        Mat image = opencv_imgcodecs.imread(img.getAbsolutePath());
        Mat result = image;
        String [] name = imageName.split("\\.");
        Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
        dilate(image, result, element);
        File outputDir = new File("output");
        String outputName = name[0] + "_dilate." + name[1];
        File outputFile = new File(outputDir, outputName);
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
    }

     */

