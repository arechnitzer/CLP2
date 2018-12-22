                  /*  File:  OEM105_13A_1e.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OEM105_13A_1e extends Template {

     static {templateClass = new OEM105_13A_1e() ; }

     public void setup() {
          filePrefix = "OEM105_13A_1e" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   
          ysize = 1.5 ;   
          xmin = -1.3 ;
          xmax = 2.5 ;
          ymin = -0.2 ;
          ymax = 5.1 ;
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
          double hx = 0.1 ;  double hy = hx*aspect ; 
          double xl = -1.0 ; double yl = 2.0 ;
          double xr =  2.0 ; double yr = 4.0 ;

          fEnv("psFillGray", 0.8) ;
          { 
             double[] xlist = { xl, xl, 0} ;
             double[] ylist = { 0, yl,  0} ;
             fPolygon(xlist, ylist, 3, FILLED) ;
               }
          { 
             double[] xlist = { xr, xr, 0} ;
             double[] ylist = { 0, yr,  0} ;
             fPolygon(xlist, ylist, 3, FILLED) ;
               }

          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fLine(-1, 0, -1, -hy) ;
          fLine(2, 0, 2, -hy) ;
          fLine(0, 2, -hx, 2) ;
          fLine(0, 4, -hx, 4) ;

          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fTeXlabel(xl, -hy*1.5, "tc", "$-1$") ;
          fTeXlabel(xr, -hy*1.5, "tc", "$2$") ;
          fTeXlabel(-hx*1.5, 2, "cr", "$2$") ;
          fTeXlabel(-hx*1.5, 4, "cr", "$4$") ;

          fEnv("lineWidth", 1.0) ;
          fLine(xl,yl, 0,0) ;
          fLine(xl,yl, xl,0) ;
          fLine(xr,yr, 0,0) ;
          fLine(xr,yr, xr,0) ;
          fLine(xl,0, xr,0) ;

     }
}
