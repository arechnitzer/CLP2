                  /*  File:  OQ16_4_4r.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OQ16_4_4r extends Template {

     static {templateClass = new OQ16_4_4r() ; }

     public void setup() {
          filePrefix = "OQ16_4_4r" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   
          ysize = 1.5 ;   
          xmin = -0.2  ;
          xmax = 4 ;
          ymin = -0.5 ;
          ymax = 10 ;
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
          { 
             double[] xlist = { 1, 1, xmax-0.02,   xmax-0.02} ;
             double[] ylist = { 0, 7.995,  8/(xmax*xmax*xmax), 0} ;
             fPolygon(xlist, ylist, 4, FILLED) ;
               }
          fEnv("psFillGray", 1.0) ;
          fCurve("y=8/(x*x*x)", 0, 1, xmax, FILLED) ;
          fEnv("psFillGray", 0.0) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("y=8/(x*x*x)", 0, 1, xmax, OPEN) ;
          fLine(1, 0, 1, 8) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.075 ;
          double h = 0.1 ;
          fDisk(1, 8, r, r*aspect, FILLED) ;
          fTeXlabel(1.05, 8, "bl", "$(1,8)$") ;


          fTeXlabel(1.5, 3.0, "bl", "$x=\\frac{2}{y^{1/3}}$") ;
          fTeXlabel(xmax, -h*aspect, "tr", "$x$") ;
          fTeXlabel(-h, ymax, "tr", "$y$") ;
          fLine(1, 0, 1, -2*h*aspect) ;
          fTeXlabel(1.05, -3*h*aspect, "tc", "$1$") ;

          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          double x = 1.6 ; double y = 8/(x*x*x) ;
          fLine(1,y, x,y) ;



     }
}
