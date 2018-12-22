                  /*  File:  E121_02A_2c.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class E121_02A_2c extends Template {

     static {templateClass = new E121_02A_2c() ; }

     public void setup() {
          filePrefix = "E121_02A_2c" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   
          ysize = 1.5 ;   
          xmin = -0.1  ;
          xmax = 1.5 ;
          ymin = -0.1 ;
          ymax = 1.5 ;
          topmargin = 0.1 ;
          bottommargin = 0.1 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fCurve("y=1", 0, xmin, xmax, OPEN) ;
          fCurve("y=x", 0, xmin, xmax, OPEN) ;
          fCurve("y=4*x", 0, xmin, xmax, OPEN) ;
          fEnv("lineWidth", 1.0) ;
          fCurve("y=1", 0, 0.25, 1, OPEN) ;
          fCurve("y=x", 0, 0, 1, OPEN) ;
          fCurve("y=4*x", 0, 0, 0.25, OPEN) ;

          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          double y = 0.5 ;
          fLine(y/4, y, y, y) ;
          canvas.append(new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fTeXlabel(xmax+0.05, 1, "lc", "$y=1$") ;
          fTeXlabel(ymax/4, ymax+0.05, "bc", "$y=4x$") ;
          fTeXlabel(xmax+0.05, ymax, "cl", "$y=x$") ;


     }
}
