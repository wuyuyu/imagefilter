package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.GaussianBlur;

public class FilterBlur implements Filter{

    /**
     * This method allows to filter an image with a blur and store it in outPut file
     * @param imageName
     * @return
     * @throws FilterException
     */
    @Override
    public Mat process(String imageName, File outputDirectory) throws FilterException{
        File img = new File(imageName);
        Mat image = opencv_imgcodecs.imread(imageName);
        String outputPath = outputDirectory.getAbsolutePath();

        try {
            int size = 3;
            Mat result = image.clone();
            GaussianBlur(image, result, new Size(size, size), 0);

            /* Enregistrement dans fichier de sortie */
            String [] name = img.getName().split("\\.");
            String outputName = name[0] + "_blur." + name[1];
            File outputFile = new File(outputPath, outputName);
            System.out.println(outputFile);
            opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), result);
            LogWriter logger = new LogWriter();
            logger.logToFile(imageName + " FilterBlur");

            return result;
        }catch (Exception e){
            throw new FilterException("Problème de filtre flou",e);
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

