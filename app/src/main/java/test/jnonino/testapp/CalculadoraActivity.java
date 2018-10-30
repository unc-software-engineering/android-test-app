package test.jnonino.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraActivity extends Activity {

    public static final String ERROR_DIVISION_POR_CERO = "Division por Cero";

    private TextView display = null;
    private EditText primer = null;
    private EditText segundo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        display = (TextView) findViewById(R.id.display);

        primer = (EditText) findViewById(R.id.primerOperador);
        segundo = (EditText) findViewById(R.id.segundoOperador);

        final Button botonSuma = (Button) findViewById(R.id.signo_suma);
        botonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Double> operadores = validarOperadores();
                if (!operadores.isEmpty()) {
                    double resultado = sumar(operadores.get(0), operadores.get(1));
                    display.setText(Double.toString(resultado));
                }
            }
        });

        final Button botonResta = (Button) findViewById(R.id.signo_resta);
        botonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Double> operadores = validarOperadores();
                if (!operadores.isEmpty()) {
                    double resultado = restar(operadores.get(0), operadores.get(1));
                    display.setText(Double.toString(resultado));
                }
            }
        });

        final Button botonMultiplicacion = (Button) findViewById(R.id.signo_multiplicacion);
        botonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Double> operadores = validarOperadores();
                if (!operadores.isEmpty()) {
                    double resultado = multiplicar(operadores.get(0), operadores.get(1));
                    display.setText(Double.toString(resultado));
                }
            }
        });

        final Button botonDivision = (Button) findViewById(R.id.signo_division);
        botonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Double> operadores = validarOperadores();
                try{
                    if (!operadores.isEmpty()) {
                        double resultado = dividir(operadores.get(0), operadores.get(1));
                        display.setText(Double.toString(resultado));
                    }
                } catch (RuntimeException e) {
                    display.setText("Division por Cero");
                }
            }
        });
    }

    protected double sumar(double primerOperador, double segundoOperador) {
        return primerOperador + segundoOperador;
    }

    protected double restar(double primerOperador, double segundoOperador) {
        return primerOperador - segundoOperador;
    }

    protected double multiplicar(double primerOperador, double segundoOperador) {
        return primerOperador * segundoOperador;
    }

    protected double dividir(double primerOperador, double segundoOperador) {
        if (segundoOperador == 0) {
            throw new RuntimeException(ERROR_DIVISION_POR_CERO);
        } else {
            return primerOperador / segundoOperador;
        }
    }

    public List<Double> validarOperadores() {
        String primerValor = String.valueOf(primer.getText());
        String segundoValor = String.valueOf(segundo.getText());
        if (!primerValor.equalsIgnoreCase("") && ! segundoValor.equalsIgnoreCase("")){
            double primerOperador = Double.parseDouble(primerValor);
            double segundoOperador = Double.parseDouble(segundoValor);
            List<Double> retorno = new ArrayList<>();
            retorno.add(primerOperador);
            retorno.add(segundoOperador);
            return retorno;
        } else {
            return new ArrayList<>();
        }
    }
}
