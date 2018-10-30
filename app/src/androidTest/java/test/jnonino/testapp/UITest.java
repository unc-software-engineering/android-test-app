package test.jnonino.testapp;

import android.content.Intent;
import android.os.SystemClock;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by jnonino on 05/10/2016.
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class UITest {

    private static final int EVENTS_DELAY = 1000;

    @Rule
    public ActivityTestRule<CalculadoraActivity> calculadoraActivityRule = new ActivityTestRule<CalculadoraActivity>(CalculadoraActivity.class, false, false);

    @Before
    public void setUp() {
        calculadoraActivityRule.launchActivity(new Intent());
    }

    @Test
    public void suma() {
        ingresarOperadores("25", "30.5");
        validarResultado(R.id.signo_suma, "55.5");
    }

    @Test
    public void resta() {
        ingresarOperadores("25", "20");
        validarResultado(R.id.signo_resta, "5.0");
    }

    @Test
    public void multiplicacion() {
        ingresarOperadores("25.5", "15.1");
        validarResultado(R.id.signo_multiplicacion, "385.05");
    }

    @Test
    public void division() {
        ingresarOperadores("29", "5");
        validarResultado(R.id.signo_division, "5.8");
    }

    private void ingresarOperadores(String primerOperador, String segundoOperador) {
        // Ingresar primer operador
        onView(withId(R.id.primerOperador))
                .perform(typeText(primerOperador), closeSoftKeyboard());
        SystemClock.sleep(EVENTS_DELAY);
        // Ingresar segundo operador
        onView(withId(R.id.segundoOperador))
                .perform(typeText(segundoOperador), closeSoftKeyboard());
        SystemClock.sleep(EVENTS_DELAY);
    }

    private void validarResultado(int operationButtonId, String expectedResult) {
        // Hacer click en el boton sumar
        onView(withId(operationButtonId))
                .perform(click());
        SystemClock.sleep(EVENTS_DELAY);
        // Verificar el resultado
        onView(withId(R.id.display)).check(matches(withText(expectedResult)));
        SystemClock.sleep(EVENTS_DELAY);
    }
}
