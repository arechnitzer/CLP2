                  /*  File:  OE14D_4.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE14D_4 extends Template {

     static {templateClass = new OE14D_4() ; }

     public void setup() {
          filePrefix = "OE14D_4" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.8 ;   
          ysize = 1.5 ;   
          xmin = -0.2  ;
          xmax = 1.5 ;
          ymin = -1.5 ;
          ymax = 3 ;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.8) ;
          double ym = Math.exp(1) ;
          { 
             double[] xlist = { 0, 0, 1,  1} ;
             double[] ylist = { -1, 1, ym, -1} ;
             fPolygon(xlist, ylist, 4, FILLED) ;
               }
          fEnv("psFillGray", 1.0) ;
          fCurve("y=e^x", 0, 0, 1, FILLED) ;
          fEnv("psFillGray", 0.0) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("y=e^x", 0, 0, 1, OPEN) ;
          fLine(0, -1, 0, 1) ;
          fLine(1, -1, 1, ym) ;
          fLine(0, -1, 1, -1) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.03 ;
          double h = 0.03 ;
          fDisk(0, -1, r, r*aspect, FILLED) ;
          fTeXlabel(-0.04, -1, "cr", "$(0,-1)$") ;
          fDisk(1, -1, r, r*aspect, FILLED) ;
          fTeXlabel(0.99, -1.15, "tr", "$(1,-1)$") ;


          double x = 0.7 ;
          fTeXlabel(x, Math.exp(x)-0.1, "br", "$y=e^x$") ;
          fTeXlabel(xmax, -h*aspect, "tr", "$x$") ;
          fTeXlabel(-h, ymax, "tr", "$y$") ;

          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          x = 0.8 ;
          fLine(x,-1, x,Math.exp(x)) ;
          x = 0.4 ;
          fTeXlabel(x, Math.exp(x)/2.0, "cc", "$R$") ;
          canvas.append(new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 0.5) ;
          double XMAX = 1.43 ;
          canvas.append( new fPsWrite("[2 2] 1 setdash\n")) ;
          fLine(0, -1, xmax, -1) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel(xmax+0.05,-1, "cl", "$y=-1$") ;
          double a = 0.2*0.3 ; double b=0.4*aspect*0.3 ;
          fEllipticalArc (XMAX,-1, a, b, 40, 320, OPEN) ;
          double th = 320*Math.PI/180.0 ;
          fArrowhead(XMAX + a*Math.cos(th),  -1+ b*Math.sin(th), 80) ;





     }
}
