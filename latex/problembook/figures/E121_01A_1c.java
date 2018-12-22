                  /*  File:  E121_01A_1c.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class E121_01A_1c extends Template {

     static {templateClass = new E121_01A_1c() ; }

     public void setup() {
          filePrefix = "E121_01A_1c" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   
          ysize = 1.0 ;   
          xmin = -2  ;
          xmax = 6 ;
          ymin = -1.5 ;
          ymax = 0.5 ;
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
          fCurve("y=x*x-1", 0, xmin, xmax, OPEN) ;
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.8) ;
          fCurve("y=x*x-1", 0, -1, 1, OPEN+FILLED) ;
          fLine(-1, 0, 1, 0) ;
          fEnv("psFillGray", 0.0) ;


          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          double y = -0.5 ;
          fLine(-Math.sqrt(y+1), y, Math.sqrt(y+1), y) ;
          canvas.append(new fPsWrite(Black+"\n")) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.15 ;
          fDisk(0, -1, r, r*aspect, FILLED) ;
          fTeXlabel(0+0.03, -1-0.08, "tl", "$(0,-1)$") ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("lineWidth", 0.7) ;
          canvas.append( new fPsWrite("[3 2] 1 setdash\n")) ;
          fLine(5, ymin, 5, ymax) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          fTeXlabel(-0.7, -0.5, "tr", "$y=x^2-1$") ;
          fTeXlabel(5, ymax+0.05, "bc", "$x=5$") ;


     }
}
