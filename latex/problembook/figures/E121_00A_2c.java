                  /*  File:  E121_00A_2c.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class E121_00A_2c extends Template {

     static {templateClass = new E121_00A_2c() ; }

     public void setup() {
          filePrefix = "E121_00A_2c" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1 ;   
          ysize = 0.75 ;   
          xmin = -0.05 ;
          xmax = 1.5 ;
          ymin = -0.05 ;
          ymax = 1.5 ;
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
          fCurve("y = x*x*x", 0, 0, 1, OPEN) ;
          fCurve("y = 1", 0, 0, 1, OPEN) ;

          fEnv("lineWidth", 2) ;
          double y = 0.6 ;
          fLine(0, y, Math.pow(y,1/3.0), y) ;


          fEnv("lineWidth", 0.3) ;
          fCurve("y = x*x*x", 0, 0, xmax, OPEN) ;
          fCurve("y = 1", 0, 0, xmax, OPEN) ;

          fLine(xmin, 0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax+0.1, 0, "lc", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fTeXlabel(0.75, 0.2, "bl", "$y=x^3,\\ x=y^{1/3}$") ;


     }
}
