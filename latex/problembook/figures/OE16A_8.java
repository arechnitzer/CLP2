                  /*  File:  OE16A_8.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE16A_8 extends Template {

     static {templateClass = new OE16A_8() ; }

     public void setup() {
          filePrefix = "OE16A_8" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   
          ysize = 1.5 ;   
          xmin = -0.2  ;
          xmax = 2.5 ;
          ymin = -0.5 ;
          ymax = 7 ;
          topmargin = 0.025 ;
          bottommargin = 0.1 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.8) ;
          fCurve("y=x*x", 0, -3, 2, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          { 
             double[] xlist = { 0, 0, -4,   -4} ;
             double[] ylist = { 0, 10, 10, 0} ;
             fPolygon(xlist, ylist, 4, FILLED) ;
               }
          fEnv("psFillGray", 0.0) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("y=x*x", 0, 0, 2, OPEN) ;
          fCurve("y=6-x", 0, 0, 2, OPEN) ;
          fLine(0, 0, 0, 6) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.06 ;
          double h = 0.075 ;
          fDisk(2, 4, r, r*aspect, FILLED) ;
          fTeXlabel(2.05, 4, "bl", "$(2,4)$") ;


          fTeXlabel(1.5, 1.5*1.5, "tl", "$y=x^2$") ;
          fTeXlabel(0.6, 6.2-0.5, "bl", "$y=6-x$") ;
          fTeXlabel(xmax, -h*aspect, "tr", "$x$") ;
          fTeXlabel(-h, ymax, "tr", "$y$") ;

          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          double x = 0.8 ;
          fLine(x,x*x, x,6-x) ;
          x=1.2 ;
          fTeXlabel(x, 0.5*(x*x+6-x), "cc", "$A$") ;



     }
}
