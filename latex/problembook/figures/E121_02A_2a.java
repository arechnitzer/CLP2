                  /*  File:  E121_02A_2a.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class E121_02A_2a extends Template {

     static {templateClass = new E121_02A_2a() ; }

     public void setup() {
          filePrefix = "E121_02A_2a" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   
          ysize = 1.5 ;   
          xmin = -1  ;
          xmax = 2 ;
          ymin = -1 ;
          ymax = 2 ;
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
          fEnv("lineWidth", 0.5) ;
          fCurve("y=x*(x*x-1)", 0, xmin, xmax, OPEN) ;
          fCurve("y=x", 0, xmin, xmax, OPEN) ;
          fEnv("lineWidth", 1.0) ;
          fCurve("x*(x*x-1)", 0, 0, Math.sqrt(2), OPEN) ;
          fCurve("y=x", 0, 0, Math.sqrt(2), OPEN) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.05 ;
          fDisk(0, 0, r, r*aspect, FILLED) ;
          fDisk(Math.sqrt(2), Math.sqrt(2), r, r*aspect, FILLED) ;
          fTeXlabel(Math.sqrt(2)+0.03, Math.sqrt(2)-0.05, "cl", "$(\\sqrt{2},\\sqrt{2})$") ;


          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          double x = 0.5 ;
          fLine(x, x, x, x*(x*x-1)) ;
          canvas.append(new fPsWrite(Black+"\n")) ;



          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          fTeXlabel(1.32, 0.6, "lc", "$y=x^3-x$") ;
          fTeXlabel(xmax+0.07, ymax, "cl", "$y=x$") ;


     }
}
