package org.jvnet.jaxb2_commons.tests.commons_lang;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import generated.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testPerson() {
        Person p = new Person();
        // No plugin default-value present, checking everything is null or default java value
        Assertions.assertEquals(false, p.isMailingAddressIdentical());

        String expected = new ToStringBuilder(p, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("firstName", p.getFirstName())
                .append("middleName", p.getMiddleName())
                .append("lastName", p.getLastName())
                .append("residentialAddress", p.getResidentialAddress())
                .append("mailingAddress", p.getMailingAddress())
                .append("mailingAddressIdentical", p.isMailingAddressIdentical())
                .build();
        Assertions.assertEquals(expected, p.toString());
    }
}
