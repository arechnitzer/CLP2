                  /*  File:  centroidHalfCircle.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class centroidHalfCircle extends Template {

     static {templateClass = new centroidHalfCircle() ; }

     public void setup() {
          filePrefix = "centroidHalfCircle" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.2*0.3 ;      // in inches
          ysize = 2.7*0.3 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -2.3 ;
          xmax = 2.5 ;
          ymin = -0.2 ;
          ymax = 2.5 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {

          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.8) ;
          fEllipticalArc(0, 0, 2, 2, 0, 180, WEDGE+FILLED) ;
          fEllipticalArc(0, 0, 2, 2, 0, 180, OPEN) ;
          fLine(-2,0,  2,0) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          fTeXlabel(1.1, 1.7, "bl", "$x^2+y^2=r^2$") ;

     }
}
