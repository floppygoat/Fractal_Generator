package Test;

import Complex.ComplexNumber;
import Complex.Mandelbrot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestMandelbrot {

    @Test
    public void testIsMandelbrot() {
        ComplexNumber c = new ComplexNumber(3, 4);
        Mandelbrot m = new Mandelbrot(c);
        assertFalse(m.is_mandelbrot());
        c.re = 0;
        c.im = 0;
        assertTrue(m.is_mandelbrot());
        c.re = 0;
        c.im = -0.6;
        assertTrue(m.is_mandelbrot());
    }
}
