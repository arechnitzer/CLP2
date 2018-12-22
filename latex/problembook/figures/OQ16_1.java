                  /*  File:  OQ16_1.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OQ16_1 extends Template {

     static {templateClass = new OQ16_1() ; }

     public void setup() {
          filePrefix = "OQ16_1" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.8*0.7 ;   
          ysize = 1.8*0.7 ;   
          xmin = -0.3 ;
          xmax = 3.5 ;
          ymin = -0.3 ;
          ymax = 1.5 ;
          topmargin = 0 ;
          bottommargin = 0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          double aspect = (ymax-ymin)*xsize/(xmax-xmin)/ysize ;
          double hx = 0.07 ;  double hy = hx*aspect ; 
          double xl =  1.0 ; double yl = 1.0 ;
          double xr =  3.0 ; double yr = 1.0 ;

          fEnv("psFillGray", 0.8) ;
          { 
             double[] xlist = { xl, xl, 0} ;
             double[] ylist = { 0, yl,  0} ;
             fPolygon(xlist, ylist, 3, FILLED) ;
               }
          { 
             double[] xlist = { xl, xl, xr, xr} ;
             double[] ylist = { 0,  yl , yr, 0} ;
             fPolygon(xlist, ylist, 4, FILLED) ;
               }

          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fLine(xl, 0, xl, -hy) ;
          fLine(xr, 0, xr, -hy) ;
          fLine(0, yl, -hx, yl) ;

          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fTeXlabel(xl, -hy*1.5, "tc", "$1$") ;
          fTeXlabel(xr, -hy*1.5, "tc", "$3$") ;
          fTeXlabel(-hx*1.5, 1, "cr", "$1$") ;

          fEnv("lineWidth", 1.0) ;
          fLine(xmin,xmin, xl,yl) ;
          fLine(xl,yl, xmax,yr) ;
          fTeXlabel(xmax+hx/2, yl, "cl", "$y=f(x)$") ;
          canvas.append( new fPsWrite("[2 2] 1 setdash\n")) ;
          fLine(xr,0, xr,yr) ;
          fLine(0,0, xr,0) ;
          fLine(xl,0, xl,yl) ;

     }
}
