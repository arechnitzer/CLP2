                  /*  File:  OQ16_2_4.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OQ16_2_4 extends Template {

     static {templateClass = new OQ16_2_4() ; }

     public void setup() {
          filePrefix = "OQ16_2_4" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   
          ysize = 1.5 ;   
          xmin = -0.2  ;
          xmax = 2.5 ;
          ymin = -1.5 ;
          ymax = 15.5 ;
          topmargin = 0.1 ;
          bottommargin = 0 ;
          leftmargin = 0.2 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double h = 0.05 ;
          fEnv("lineWidth", 0.5) ;
          fCurve("y=3*x*x", 0, 0, xmax, OPEN) ;
          fCurve("y=x*x*sqrt(1+x*x*x)", 0, 0, xmax, OPEN) ;
          fEnv("psFillGray", 0.8) ;
          fCurve("y=x*x*sqrt(1+x*x*x)", 0, 0.1, 1.99, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fCurve("y=3*x*x", 0, 0, 2, FILLED) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("y=3*x*x", 0, 0, 2, OPEN) ;
          fCurve("y=x*x*sqrt(1+x*x*x)", 0, 0, 2, OPEN) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fTeXlabel(xmax, -h*aspect, "tr", "$x$") ;
          fTeXlabel(-h, ymax, "tr", "$y$") ;
          fTeXlabel(1.5, 7, "rc", "$y=3x^2$") ;
          fTeXlabel(1.5, 4, "lc", "$y=x^2\\sqrt{x^3+1}$") ;

          double r = 0.07 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(2, 12, r, r*aspect, FILLED) ;
          fDisk(0, 0, r, r*aspect, FILLED) ;
          fTeXlabel(2.1, 12, "cl", "$(2,12)$") ;


          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          double x = 1.2 ; double yb = x*x*Math.sqrt(x*x*x+1) ; double yt = 3*x*x ;
          fLine(x, yb, x, yt) ;



     }
}
