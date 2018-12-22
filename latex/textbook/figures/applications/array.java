                  /*  File:  array.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class array extends Template {

     static {templateClass = new array() ; }

     public void setup() {
          filePrefix = "array" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.6*1.0 ;      // in inches
          ysize = 2.0*1.0 ;   // in inches. 
          xmin = -30 ;
          xmax =  30 ;
          ymin = -10 ;
          ymax = 190 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0.2 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fArrow(0, ymin,0, ymax) ;
          fTeXlabel( 5, ymax, "lc", "$z$") ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;

          double r = 4 ;
          double R = 6 ;
          double[] ylist = {0, 40, 80, 120} ;
          double[] xlist = {0 ,  0, 0,   0} ;
//          canvas.append( new fPsWrite("0.7 setgray\n")) ;
//          for (int i=0; i< 3; i++) {
//               fLine(xlist[i], ylist[i], xlist[i+1], ylist[i+1]) ;
//          }

          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          for (int i=1; i<= xlist.length; i++) {
               fDisk(xlist[i-1], ylist[i-1], r, r, FILLED) ;
               fTeXlabel(xlist[i-1]-7, ylist[i-1], "rc", "$m_"+i+"$") ;
               fTeXlabel(xlist[i-1]+7, ylist[i-1], "lc", "$z_"+i+"$") ;
          }
   
          fEnv("psFillColor", Blue) ;
          double Z = 160 ;
          fDisk(0, Z, R, R, FILLED) ;
          fTeXlabel(-7, Z, "rc", "$M$") ;
          fTeXlabel( 7, Z, "lc", "$Z$") ;




          
     }
}
