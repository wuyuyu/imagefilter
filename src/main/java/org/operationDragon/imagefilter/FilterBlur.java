package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.GaussianBlur;

public class FilterBlur implements Filter{

    /**
     * This method is used to filter an image with blur and store it in the outPut file
     * @param imageName name of the image
     * @param outputDirectory output file
     * @param filename name of the log's file
     * @return an processed image
     * @throws FilterException
     */
    @Override
    public Mat process(String imageName, File outputDirectory,String filename) throws FilterException{
        File img = new File(imageName);
        Mat image = opencv_imgcodecs.imread(imageName);
        String outputPath = outputDirectory.getAbsolutePath();

        try {
            int size = 3;
            Mat result = image.clone();
            GaussianBlur(image, result, new Size(size, size), 0);
            String [] name = img.getName().split("\\.");
            String outputName = name[0] + "_blur." + name[1];
            File outputFile = new File(outputPath, outputName);
            System.out.println(outputFile);
            opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), result);
            LogWriter logger = new LogWriter();
            logger.logToFile(imageName + " FilterBlur",filename);

            return result;
        }catch (Exception e){
            throw new FilterException("Problème de filtre flou",e);
        }
    }

}



