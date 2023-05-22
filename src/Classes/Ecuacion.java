

package Classes;

import org.matheclipse.core.eval.ExprEvaluator;
// import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.math.MathException;
// import Classes.functions;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class Ecuacion {
    
    public String ecuacionFormat;
    public String ecuacion;
    public String derivada;

    public Ecuacion(String ecuacion) {
        this.derivada = "";
        this.ecuacion = ecuacion;
        if(ecuacion == ""){
            this.ecuacionFormat = "";
        }else{

            this.ecuacionFormat = "D("+ ecuacion + ",x)";
        }
    }

    public String obtenerDerivada(){
        try {
			ExprEvaluator util = new ExprEvaluator();
			ISymbol x          = F.Dummy("x");
			IAST function      = F.D(F.Times(F.Sin(x), F.Cos(x)), x);
			IExpr result       = util.eval(function);

			result = util.eval(this.ecuacionFormat);
            this.derivada = result.toString();

            return this.derivada;

		} catch (SyntaxError e) {
			// catch Symja parser errors here
            return e.getMessage();
		} catch (MathException me) {
			// catch Symja math errors here
			return me.getMessage();
		} catch (final Exception ex) {
			return ex.getMessage();
		} catch (final StackOverflowError soe) {
			return soe.getMessage();
		} catch (final OutOfMemoryError oome) {
			return oome.getMessage();
		}
    }

    public static double evaluarExpresion( String ecuacion, double value ){

        // Evaluar la expresión con exp4j
        Expression exp = new ExpressionBuilder(ecuacion.toLowerCase())
                            .variable("x")
                            .build();

        double resultadoEvaluacion = exp.setVariable("x", value).evaluate();

        return resultadoEvaluacion;
    }
}


