package Test;

import Complex.ComplexNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestComplexNumber {

    @Test
    public void testComplexSquare() {
        ComplexNumber c = new ComplexNumber(1, 1);
        c.square();
        assertTrue(c.getRe() ==  0 && c.getIm() == 2);
        c.square();
        assertTrue(c.getRe() == -4 && c.getIm() == 0);
        //c.re = -4.56;
        //c.im = 3.59;
        //c.square();
        //assertTrue(c.re == 7.9055 && c.im == -32.7408);
    }

    @Test
    public void testComplexLength() {
        ComplexNumber c = new ComplexNumber(3, 4);
        assertTrue(c.length() == 5);
        c.changeRe(5);
        c.changeIm(-12);
        assertTrue(c.length() == 13);
    }

    @Test
    public void testComplexAdd() {
        ComplexNumber c = new ComplexNumber(3, 4);
        c.add(c);
        assertTrue(c.getRe() == 6 && c.getIm() == 8);
        ComplexNumber d = new ComplexNumber(-6, -13);
        c.add(d);
        assertTrue(c.getRe() == 0 && c.getIm() == -5);
    }
}

