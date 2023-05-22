

import Classes.Ecuacion;
import Classes.Newton;

public class App {
    public static void main(String[] args) throws Exception {

		
		Ecuacion ecuacion = new Ecuacion("(x+3)^3-5x^2-5");
		Newton procesoNewton = new Newton(ecuacion);
		procesoNewton.metodoNewton(4);

		System.out.println(procesoNewton.metodoNewton(0));
		// ecuacion.obtenerDerivada();
		// ecuacion.evaluarExpresion(ecuacion.ecuacion, 4.0);
      

    }
}

