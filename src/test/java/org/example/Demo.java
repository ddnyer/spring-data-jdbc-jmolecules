package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Demo {

    @Autowired
    private JdbcCustomConversions jdbcCustomConversions;

    @Test
    void test() {
       var barTargetType = jdbcCustomConversions.getCustomWriteTarget(BarId.class).orElseThrow();
       var fooTargetType = jdbcCustomConversions.getCustomWriteTarget(FooId.class).orElseThrow();

       // One of this assertion is failing as the same target type is returned for all Identifier objects.
       assertEquals(barTargetType, UUID.class);
       assertEquals(fooTargetType, String.class);
    }

}
