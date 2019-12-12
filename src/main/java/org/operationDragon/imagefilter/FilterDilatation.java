package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.imgproc.Imgproc;

import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.dilate;
import static org.bytedeco.opencv.global.opencv_imgproc.getStructuringElement;

public class FilterDilatation implements Filter{

    /**
     * This method filters an image by dilating the pixels and stores it in outPut.
     * @param imageName
     * @return
     * @throws FilterException
     */
    @Override
    public Mat process(String imageName, File outputDirectory,String filename) throws FilterException{

        File img = new File(imageName);
        System.out.println(img);
        Mat image = opencv_imgcodecs.imread(imageName);
        String outputPath = outputDirectory.getAbsolutePath();
        try {
            int size = 8;
            Mat result = image.clone();
            Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
            dilate(image, result, element);

            /* Enregistrement dans fichier de sortie */
            String [] name = img.getName().split("\\.");
            String outputName = name[0] + "_dilate." + name[1];
            File outputFile = new File(outputPath, outputName);
            System.out.println(outputFile);
            opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), result);
            LogWriter logger = new LogWriter();
            logger.logToFile(imageName + " FilterDilatation", filename);

            return result;

        }catch (Exception e){
            throw new FilterException("Problème de filtre dilatation");
        }
    }
}

