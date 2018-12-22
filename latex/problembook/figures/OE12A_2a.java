                  /*  File:  OE12A_2a.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE12A_2a extends Template {

     static {templateClass = new OE12A_2a() ; }

     public void setup() {
          filePrefix = "OE12A_2a" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0*0.5 ;   
          ysize = 3.5*0.5 ;   
          xmin = -1.5 ;
          xmax =  3.0 ;
          ymin = -0.5 ;
          ymax =  4.5 ;
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
          double x = 0.8 ; double y = 4-(x-1)*(x-1) ;
          double yrot = 5 ;
          double XMAX = 2.5 ;

          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.8) ;
          fCurve("4-(x-1)*(x-1)" , 0, -1, 2, CLOSED+FILLED) ;
//          fCurve("x+1" , 0, -1, 2, OPEN) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, XMAX, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(-0.07, ymax, "tr", "$y$") ;
          fTeXlabel(XMAX, -0.07, "tr", "$x$") ;
          fCurve("4-(x-1)*(x-1)" , 0, xmin, XMAX, OPEN) ;
          fCurve("x+1" , 0, xmin, XMAX, OPEN) ;
          


          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(x,x+1, x, y) ;
//          fTeXlabel(xmin-0.3, yrot, "cr", "$y=5$") ;


//          fEnv("lineWidth", 1.0) ;
//          canvas.append( new fPsWrite(Blue+"\n")) ;
//          fLine(xmin, yrot, XMAX, yrot) ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
//          double a = 0.2*0.5 ; double b=0.4*0.75 ;
//          fEllipticalArc (XMAX,yrot, a, b, 40, 320, OPEN) ;
//          double th = 330*Math.PI/180.0 ;
//          fArrowhead(XMAX + a*Math.cos(th),   b*Math.sin(th)+yrot, 72) ;
          

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.075 ;
          fDisk(-1, 0, r, r*aspect, FILLED) ;
          fDisk(2, 3, r, r*aspect, FILLED) ;
          fTeXlabel(-1-0.05, 0.1, "br", "$(-1,0)$") ;
          fTeXlabel( 2+0.15, 3-0.07, "cl", "$(2,3)$") ;


          fTeXlabel(XMAX+0.1, 4-(XMAX-1)*(XMAX-1), "cl", "$y=4-(x-1)^2$") ;
          fTeXlabel(XMAX+0.1, XMAX+1, "bl", "$y=x+1$") ;






     }
}
