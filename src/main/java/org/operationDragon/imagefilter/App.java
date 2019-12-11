package org.operationDragon.imagefilter;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.io.IOException;

public class App extends JavaCVHelper{

    static void filterDossier (File input, Filter filter ){



        for (File f: input.listFiles()){
            if(f.getName().endsWith(".jpeg")) {
                String chemin;
                chemin = f.getAbsolutePath();

                try {
                    filter.process(chemin);
                }catch (Exception e){
                    e.getMessage();
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {


        File input = new File("input");

        String filterArg = "dilatation";
        Filter filter = null;

        switch (filterArg){
            case "blur":
                filter = new FilterBlur();
                break;
            case "dilatation":
                filter = new FilterDilatation();
                break;
            case "blackWhite":
                filter = new FilterBlackWhite();
                break;
        }
        App.filterDossier(input,filter);


        try{
            FilterDilatation dilatation1 = new FilterDilatation();
            dilatation1.process("dragon.jpeg");
            FilterBlackWhite bw1 = new FilterBlackWhite();
            bw1.process("dragon2.jpeg");
            FilterBlur blur = new FilterBlur();
            blur.process("dragon3.jpeg");

            FilterDilatation dilatation2 = new FilterDilatation();
            dilatation2.process("image ");


        }catch (FilterException e){
            System.out.println(e.getMessage());
        }
    }
}
