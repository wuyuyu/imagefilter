package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;

public class FilterBlackWhite implements Filter{

    /**
     * This method is used to filter an image in black and white and store it in the outPut file
     * @param imageName
     * @return
     * @throws FilterException
     */
    @Override
    public Mat process(String imageName, File outputDirectory,String filename) throws FilterException {
        File img = new File(imageName);
        Mat image = opencv_imgcodecs.imread(img.getAbsolutePath());
        String outputPath = outputDirectory.getAbsolutePath();

        try {
            Mat result = new Mat(image.rows(), image.cols(), CvType.CV_8UC3);
            cvtColor(image, result, Imgproc.COLOR_RGB2GRAY);

            /* Enregistrement dans fichier de sortie */
            String [] name = img.getName().split("\\.");
            String outputName = name[0] + "_bw." + name[1];
            File outputFile = new File(outputPath, outputName);
            System.out.println(outputFile);
            opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), result);
            LogWriter logger = new LogWriter();
            logger.logToFile(imageName + " FilterBlackWhite",filename);


            return result;
        }catch (Exception e){
            throw new FilterException("Problème avec le filtre noir et blanc");
        }
    }
}


    /*
    public FilterBlackWhite(String imageName) throws FilterException {
        File img = new File(imageName);
        Mat image = opencv_imgcodecs.imread(img.getAbsolutePath());
        String [] name = imageName.split("\\.");
        image = filterGrayscale(image);
        File outputDir = new File("output");
        String outputName = name[0] + "_bw." + name[1];
        File outputFile = new File(outputDir, outputName);
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
    }

     */
