package Classes;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Newton {

    Ecuacion ecuacionClass;
    ArrayList<Object[]> datos ;

    public Newton(Ecuacion ecuacionesClass){
        this.ecuacionClass = ecuacionesClass;
        this.datos = new ArrayList<>();

    }

    public double metodoNewton(double xnValue) {
        double xn = xnValue;
        double gxAux = 0;
        double n = 1;
        double error = 0;
        DecimalFormat formato = new DecimalFormat("#.######");
    
        
        while (true) {
            double fxn = Ecuacion.evaluarExpresion(this.ecuacionClass.ecuacion, xn);
            double fxnDiff = Ecuacion.evaluarExpresion(this.ecuacionClass.obtenerDerivada(), xn);
            double gx = calcularGxnNewton(xn, fxn, fxnDiff);
        
            if (n > 1) {
                error = Math.abs(gxAux - gx);
                datos.add(new Object[]{formato.format(n), formato.format(xn), formato.format(fxn), formato.format(fxnDiff), formato.format(gx), formato.format(error) });
                if (error <= 0.001) {
                    return gx;
                }
            }
            xn = gx;
            gxAux = xn;
            
            if (n > 1000) {
                System.out.println("No se encuentra la Raiz");
                return 0;
            }
            
            n++;
        }
    }
    
    
    
    
    
    
    

    public double calcularGxnNewton( double xn,  double fxn,  double fxnDiff) {
        
        return (xn - (fxn/fxnDiff));
    }

}
