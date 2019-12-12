package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Point;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.io.File;


public class FilterZeTeam implements Filter {

    public Mat process(String imageName, File outputDirectory,String filename) throws FilterException {


        File img = new File(imageName);
        System.out.println(img);
        Mat image = opencv_imgcodecs.imread(imageName);
        String outputPath = outputDirectory.getAbsolutePath();
        String[] name = img.getName().split("\\.");
        String outputName = name[0] + "_zeTeam." + name[1];
        File outputFile = new File(outputPath, outputName);
        System.out.println(image);

        opencv_imgproc.putText(image, "JAG team", new Point(10, 30), Imgproc.FONT_HERSHEY_PLAIN, 2.2, new Scalar(255,255,0,255));

        System.out.println(outputFile);
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
        LogWriter logger = new LogWriter();
        logger.logToFile(imageName + " ZeTeam",filename);
        return image;

    }
}
