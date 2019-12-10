package org.operationDragon.imagefilter;

public class App extends JavaCVHelper{
    public static void main(String[] args) throws Exception {

        new FilterBlackWhite("dragonmignon.jpeg");
        new FilterBlackWhite("dragon3.jpeg");
        new FilterBlackWhite("dragon.jpeg");

        // TODO gérer exception qd le fichier n'existe pas :(
        new FilterBlur("dragonmignon.jpeg");
        new FilterDilatation("dragonmignon");
    }
}
