package com.fsd.assignment.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
public class HelloTest {


    @Test
    public void whenFindByName_thenReturnEmployee() {

        assertThat("Hello")
                .isEqualTo("Hello");
    }
}
