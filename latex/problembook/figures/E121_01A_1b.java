                  /*  File:  E121_01A_1b.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class E121_01A_1b extends Template {

     static {templateClass = new E121_01A_1b() ; }

     public void setup() {
          filePrefix = "E121_01A_1b" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.8 ;   
          ysize = 1.5 ;   
          xmin = -2  ;
          xmax = 2.5 ;
          ymin = -2 ;
          ymax = 6 ;
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
          fCurve("y=1-x*x", 0, xmin, xmax, OPEN) ;
          fCurve("y=4-4*x*x", 0, xmin, xmax, OPEN) ;
          fEnv("lineWidth", 1.0) ;
          fCurve("y=1-x*x", 0, -1, 1, OPEN) ;
          fCurve("y=4-4*x*x", 0, -1, 1, OPEN) ;

          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          double x = 0.5 ;
          fLine(x, 1-x*x, x, 4-4*x*x) ;
          canvas.append(new fPsWrite(Black+"\n")) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.1 ;
          fDisk(-1, 0, r, r*aspect, FILLED) ;
          fDisk(1, 0, r, r*aspect, FILLED) ;
          fTeXlabel(-1-0.03, 0+0.08, "br", "$(-1,0)$") ;
          fTeXlabel(1+0.03, 0+0.08, "bl", "$(1,0)$") ;




          fEnv("lineWidth", 0.7) ;
          canvas.append( new fPsWrite("[3 2] 1 setdash\n")) ;
          fLine(xmin, -1, xmax, -1) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;


          fEnv("lineWidth", 0.8) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fTeXlabel(xmax+0.1, 0.0, "cl", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          fTeXlabel(1.7, 2.8, "bc", "$y=4-4x^2$") ;
          fTeXlabel(1.87, ymin, "cl", "$y=1-x^2$") ;
          fTeXlabel(xmin, -1, "cr", "$y=-1$") ;


     }
}
