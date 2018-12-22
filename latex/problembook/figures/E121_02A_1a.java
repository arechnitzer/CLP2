                  /*  File:  E121_02A_1a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class E121_02A_1a extends Template {

     static {templateClass = new E121_02A_1a() ; }

     public void setup() {
          filePrefix = "E121_02A_1a" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1*1.5 ;      // in inches
          ysize = 1.2*1.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -5 ;
          xmax = 5 ;
          ymin = -2 ;
          ymax = 10 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.3, "tr", "$x$") ;
          fTeXlabel(-0.3, ymax, "tr", "$y$") ;
          fEnv("lineWidth", 1.0) ;
          fCurve("[t*(t*t-4), 2*(4-t*t)]",1, -2, 2, OPEN);

          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          double t = 1.0 ;
          double x = -t*(t*t-4) ;
          double y = 2*(4-t*t) ;
          fLine(0,y,x,y) ;
          canvas.append(new fPsWrite(Black+"\n")) ;


     }
}
