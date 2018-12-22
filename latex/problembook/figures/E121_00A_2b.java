                  /*  File:  E121_00A_2b.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class E121_00A_2b extends Template {

     static {templateClass = new E121_00A_2b() ; }

     public void setup() {
          filePrefix = "E121_00A_2b" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1 ;   
          ysize = 0.75 ;   
          xmin = -0.05 ;
          xmax = 3 ;
          ymin = -0.02 ;
          ymax = 0.3 ;
          topmargin = 0.1 ;
          bottommargin = 0.1 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1) ;
          fCurve("y = x*exp(-2*x)", 0, 0, xmax, OPEN) ;

          fEnv("lineWidth", 2) ;
          double x = 1 ;
          fLine(x, x*Math.exp(-2*x), x, 0) ;


          fEnv("lineWidth", 0.3) ;

          fLine(xmin, 0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax+0.1, 0, "lc", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fTeXlabel(0.75, 0.2, "bl", "$y=xe^{-2x}$") ;


     }
}
