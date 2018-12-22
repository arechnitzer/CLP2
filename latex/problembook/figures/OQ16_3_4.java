                  /*  File:  OQ16_3_4.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OQ16_3_4 extends Template {

     static {templateClass = new OQ16_3_4() ; }

     public void setup() {
          filePrefix = "OQ16_3_4" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0*0.5 ;   
          ysize = 4.0*0.5 ;   
          xmin = -4.0 ;
          xmax =  4.5 ;
          ymin = -4.0 ;
          ymax =  1.5 ;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          double x = 1.5 ;
          double yrot = -0.35*3.14159*3.14159 ;
          double XMAX = 4.0 ;

          fEnv("psFillGray", 0.8) ;
          fCurve("cos(x/2)" , 0, -3.14159, 3.14159, FILLED) ;
          fCurve("0.35*(x*x-3.14159*3.14159)" , 0, -3.14159, 3.14159, FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, XMAX, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(-0.07, ymax, "tr", "$y$") ;
          


          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(x,Math.cos(x/2) -0.015, x, 0.35*(x*x-3.14159*3.14159)+0.015) ;
          fTeXlabel(xmin-0.3, yrot, "cr", "$y=-\\pi^2$") ;


          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(xmin, yrot, XMAX, yrot) ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          double a = 0.2*0.75 ; double b=0.4*0.75 ;
          fEllipticalArc (XMAX,yrot, a, b, 40, 320, OPEN) ;
          double th = 320*Math.PI/180.0 ;
          fArrowhead(XMAX + a*Math.cos(th),   b*Math.sin(th)+yrot, 55) ;
          
          double X = XMAX+1.5 ; double R = 0.53 ; double r = 0.4 ;
          double thdeg = 20 ;
          th = thdeg*Math.PI/180.0 ;
//          fLine(X,2, X-R*Math.cos(th), 2+R*Math.sin(th)) ;
//          fLine(X,2, X-R*Math.cos(th), 2-R*Math.sin(th)) ;
//          fEllipticalArc (X,2, r, r, 180-thdeg, 180+thdeg, OPEN) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          r = 0.15 ;
          fDisk(-3.14159, 0, r, r*aspect, FILLED) ;
          fDisk(3.14159, 0, r, r*aspect, FILLED) ;
          fTeXlabel(-3.14159-0.2, 0.1, "br", "$(-\\pi,0)$") ;
          fTeXlabel( 3.14159+0.3, 0.1, "bl", "$(\\pi,0)$") ;


          fEnv("lineWidth", 1.0) ;
          fCurve("cos(x/2)" , 0, xmin, XMAX-0.2, OPEN) ;
          fCurve("0.35*(x*x-3.14159*3.14159)" , 0, xmin, XMAX-0.2, OPEN) ;
          fTeXlabel(-3.3, -0.5, "tr", "$y=\\cos(\\frac{x}{2})$") ;
          fTeXlabel(2.5, -1.5, "tl", "$y=x^2-\\pi^2$") ;






     }
}
