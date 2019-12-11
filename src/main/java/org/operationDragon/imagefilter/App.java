package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.io.IOException;

public class App extends JavaCVHelper{
    public static void main(String[] args) throws Exception {


        File f = new File("imagefilter.log");
        File image = new File("dragon.jpeg");


        try{
            FilterDilatation dilatation1 = new FilterDilatation();
            dilatation1.process("dragon.jpeg");
            FilterBlackWhite bw1 = new FilterBlackWhite();
            bw1.process("dragon2.jpeg");
            FilterBlur blur = new FilterBlur();
            blur.process("dragon3.jpeg");

        }catch (FilterException e){

            System.out.println(e.getMessage());
        }
    }
}
