package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;

public class App extends JavaCVHelper{
    public static void main(String[] args) {

        FilterBlackWrite bw = new FilterBlackWrite();
        bw.process();






    }
}
