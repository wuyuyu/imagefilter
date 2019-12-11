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
    public Mat process(String imageName, File outputDirectory) throws FilterException{

        File file = new File(imageName);
        System.out.println(file);
        Mat image = opencv_imgcodecs.imread(imageName);
        String outputPath = outputDirectory.getAbsolutePath();
        try {
            int size = 8;
            Mat result = image.clone();
            Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
            dilate(image, result, element);
            String [] name = file.getName().split("\\.");
            String outputName = name[0] + "_dilate." + name[1];
            File outputFile = new File(outputPath, outputName);
            System.out.println(outputFile);
            opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), result);
            return result;

        }catch (Exception e){
            throw new FilterException("Problème de filtre dilatation");
        }
    }
}

