package org.operationDragon.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;

/**
 * all filter's Interface
 */
public interface Filter {

    Mat process (String imageName, File outputDirectory,String filename)throws FilterException;
}
