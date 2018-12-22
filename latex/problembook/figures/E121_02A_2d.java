                  /*  File:  E121_02A_2d.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class E121_02A_2d extends Template {

     static {templateClass = new E121_02A_2d() ; }

     public void setup() {
          filePrefix = "E121_02A_2d" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   
          ysize = 1.5 ;   
          xmin = -0.1  ;
          xmax = 1.1 ;
          ymin = -0.1 ;
          ymax = 1.3 ;
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
          fCurve("y=1-x*x", 0, xmin, xmax, OPEN) ;
          fCurve("y=x", 0, xmin, xmax, OPEN) ;
          fEnv("lineWidth", 1.0) ;
          double xi = 0.5*(-1+Math.sqrt(5) ) ;
          fCurve("y=1-x*x", 0, 0, xi, OPEN) ;
          fCurve("y=x", 0, 0, xi, OPEN) ;
          fLine(0,0, 0,1) ;

          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          double x = 0.3 ;
          fLine(x, x, x, 1-x*x) ;
          canvas.append(new fPsWrite(Black+"\n")) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fTeXlabel(xmax+0.03, 0, "lc", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fTeXlabel(0.9, 0.35, "lc", "$y=1-x^2$") ;
          fTeXlabel(xmax+0.03, xmax, "cl", "$y=x$") ;


     }
}
