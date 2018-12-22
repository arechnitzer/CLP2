                  /*  File:  E121_00A_2a.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class E121_00A_2a extends Template {

     static {templateClass = new E121_00A_2a() ; }

     public void setup() {
          filePrefix = "E121_00A_2a" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1 ;   
          ysize = 0.75 ;   
          xmin = -0.1 ;
          xmax = 3.9 ;
          ymin = -0.5 ;
          ymax = 2.0 ;
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
          fCurve("y = ln(x)", 0, 1, Math.exp(1), OPEN) ;
          fCurve("y = 1-x*x", 0, 0, 1, OPEN) ;
          fCurve("y = 1", 0, 0, Math.exp(1), OPEN) ;

          fEnv("lineWidth", 2) ;
          double y = 0.6 ;
          fLine(Math.sqrt(1-y), y, Math.exp(y), y) ;


          fEnv("lineWidth", 0.3) ;
          fCurve("y = ln(x)", 0, 0.5, xmax, OPEN) ;
          fCurve("y = 1-x*x", 0, 0, xmax, OPEN) ;
          fCurve("y = 1", 0, 0, xmax, OPEN) ;

          fLine(xmin, 0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax+0.1, 0, "lc", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fTeXlabel(xmax+0.2, Math.log(xmax), "bl", "$y=\\ln x,\\ x=e^y$") ;
          fTeXlabel(xmax+0.2, 1, "tl", "$y=1$") ;
          fTeXlabel(1.4, ymin, "lc", "$y=1-x^2,\\ x=\\sqrt{1-y}$") ;


     }
}
