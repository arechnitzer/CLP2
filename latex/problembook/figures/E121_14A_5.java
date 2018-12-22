                  /*  File:  E121_14A_5.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class E121_14A_5 extends Template {

     static {templateClass = new E121_14A_5() ; }

     public void setup() {
          filePrefix = "E121_14A_5" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.9*1.3 ;   
          ysize = 1.1*1.3 ;   
          double pi= Math.PI ;
          xmin = -0.25  ;
          xmax =  pi+0.5 ;
          ymin = -0.2 ;
          ymax = 1.2 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          double pi= Math.PI ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.7) ;
          fCurve("sin(x)", 0, 0.0, pi, FILLED) ;
          
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("sin(x)", 0, 0.0, pi, OPEN) ;
          fTeXlabel(0.85*pi, 0.6, "cl", "$y=\\sin x$") ;
          fLine(0, 0, pi, 0) ;

          double r = 0.07 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fEnv("psFillGray", 0.0) ;
          fDisk(pi,0, r,r*aspect, FILLED) ;
          fTeXlabel(pi+0.07, 0.05, "lb", "$(\\pi,0)$") ;
       

          fTeXlabel(xmax, -0.04, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 4.0) ;
          double x = 0.4 ; double xr = pi -x ; double y = Math.sin(x) ; 
          fLine (x, y,   xr, y) ;

     }
}
