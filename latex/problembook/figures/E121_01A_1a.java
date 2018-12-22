                  /*  File:  E121_01A_1a.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class E121_01A_1a extends Template {

     static {templateClass = new E121_01A_1a() ; }

     public void setup() {
          filePrefix = "E121_01A_1a" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0 ;   
          ysize = 1.0 ;   
          xmin = -1  ;
          xmax = 5 ;
          ymin = -1 ;
          ymax = 5 ;
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
          fCurve("y=sqrt(4*x)", 0, 0, xmax, OPEN) ;
          fCurve("y=-sqrt(4*x)", 0, 0, xmax, OPEN) ;
          fCurve("y=x*x/4", 0, xmin, xmax, OPEN) ;
          fEnv("lineWidth", 1.0) ;
          fCurve("y=sqrt(4*x)", 0, 0, 4, OPEN) ;
          fCurve("y=x*x/4", 0, 0, 4, OPEN) ;

          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          double x = 2 ;
          fLine(x, x*x/4, x, Math.sqrt(4*x)) ;
          canvas.append(new fPsWrite(Black+"\n")) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.2 ;
          fDisk(0, 0, r, r*aspect, FILLED) ;
          fDisk(4, 4, r, r*aspect, FILLED) ;
          fTeXlabel(4-0.03, 4+0.05, "br", "$(4a,4a)$") ;



          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          fTeXlabel(2.5, 1, "lc", "$x^2=4ay$") ;
          fTeXlabel(xmax+0.2, 4.6, "cl", "$y^2=4ax$") ;


     }
}
