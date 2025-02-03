package org.jvnet.jaxb2_commons.tests.commons_lang;

import generated.ExtendedSequence;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ExtendedSequenceTest {

    @Test
    public void testToString() throws Exception {
        ExtendedSequence extended = new ExtendedSequence();
        extended.setA("a");
        extended.getB().add(1L);
        extended.getB().add(2L);
        extended.setC(date("2025-02-03"));
        extended.setD(new byte[] {1, 2, 3});

        assertEquals("ExtendedSequence[a=a,b=[1, 2],c=2025-02-03,d={1,2,3}]", extended.toString());
    }

    @Test
    public void testEqualsAndHashCode() throws Exception {
        ExtendedSequence a = new ExtendedSequence();
        a.setA("a");
        a.setC(date("2025-02-03"));
        a.setD(new byte[] {1, 2, 3});

        ExtendedSequence b = new ExtendedSequence();
        b.setA("a");
        b.setC(date("2025-02-03"));
        b.setD(new byte[] {1, 2, 3});

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertEquals(a.toString(), b.toString());

        b.getB(); // Force lazy initialization
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a.toString(), b.toString());

        b.setA("b");
        assertNotEquals(a, b);
        assertNotEquals(a.hashCode(), b.hashCode());
    }

    private static XMLGregorianCalendar date(String date) throws Exception {
        return DatatypeFactory.newInstance()
            .newXMLGregorianCalendar(date);
    }
}
