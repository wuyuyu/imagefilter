package org.operationDragon.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;

public interface Filter {

    Mat process (String imageName)throws FilterException;
}
