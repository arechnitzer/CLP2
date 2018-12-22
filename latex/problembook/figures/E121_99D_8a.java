                  /*  File:  E121_99D_8a.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class E121_99D_8a extends Template {

     static {templateClass = new E121_99D_8a() ; }

     public void setup() {
          filePrefix = "E121_99D_8a" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;   
          ysize = 2.0 ;   
          xmin = -1 ;
          xmax = 2.5 ;
          ymin = -1 ;
          ymax = 2.5 ;
          topmargin = 0.1 ;
          bottommargin = 0.1 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1) ;
          double p4 = Math.PI/4 ;
          fEnv("psFillGray", 0.7) ;
          fCurve("[2*sin(t)*cos(t), 2*sin(t)*sin(t)]",1, 0, p4, FILLED);
          fCurve("[2*cos(t)*cos(t), 2*cos(t)*sin(t)]",1, p4, 2*p4, FILLED);
          fEnv("psFillGray", 0.0) ;

          fCurve("[2*sin(t)*cos(t), 2*sin(t)*sin(t)]",1, 0, p4, OPEN);
          fCurve("[2*cos(t)*cos(t), 2*cos(t)*sin(t)]",1, p4, 2*p4, OPEN);


          fEnv("lineWidth", 0.5) ;
          fDisk(1,0,1,1, CLOSED) ;
          fDisk(0,1,1,1, CLOSED) ;
          fLine(xmin, 0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          canvas.append( new fPsWrite("[2 2] 1 setdash\n")) ;
          fLine(0,0,  1.5,1.5) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel(1.55, 1.55, "bl", "$y=x$") ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.06 ;
          fDisk(1, 1, r, r*aspect, FILLED) ;
          fTeXlabel(1-0.03, 1+0.05, "br", "$(1,1)$") ;


          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 4.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          double y = 0.4 ; double x = 1 - Math.sqrt(1-y*y) ;
          fLine(x, y, y, y) ;
          canvas.append(new fPsWrite(Blue+"\n")) ;
          y = 0.7 ; x = 1 - Math.sqrt(1-y*y) ; double xx = Math.sqrt(1-(y-1)*(y-1)) ;
          fLine(x, y,  xx, y) ;
          canvas.append(new fPsWrite(Black+"\n")) ;


          fTeXlabel(-1.05, 1, "cr", "$x^2+(y-1)^2=1$") ;
          fTeXlabel(1, -1.05, "tc", "$(x-1)^2+y^2=1$") ;
//          fTeXlabel(-1.05, 1, "cr", "$r=2\\sin(\\theta)$") ;
//          fTeXlabel(1, -1.05, "tc", "$r=2\\cos(\\theta)$") ;

     }
}
