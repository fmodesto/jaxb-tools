package org.jvnet.jaxb2_commons.tests.commons_lang;

import generated.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    public void testAddress() {
        Address a = new Address();
        // No plugin default-value present, checking everything is null or default java value
        Assertions.assertEquals(0, a.getNumber());
        Assertions.assertNull(a.getCareOf());
        Assertions.assertNull(a.getStreet());
    }

    @Test
    public void testEquals() {
        Address a = new Address();
        Address b = new Address();
        Assertions.assertEquals(a, b);
        Assertions.assertEquals(a.toString(), b.toString());

        b.getList();
        Assertions.assertEquals(a, b);
        Assertions.assertNotEquals(a.toString(), b.toString());
    }

    @Test
    public void testHashCode() {
        Address a = new Address();
        Address b = new Address();
        Assertions.assertEquals(a.hashCode(), b.hashCode());
        Assertions.assertEquals(a.toString(), b.toString());

        b.getList();
        Assertions.assertEquals(a.hashCode(), b.hashCode());
        Assertions.assertNotEquals(a.toString(), b.toString());
    }
}
