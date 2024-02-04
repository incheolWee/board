package com.example.myapp;

import com.example.SpringMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@SpringMvcTest
public class EntityTest {

    @Autowired
    private NameRepository nameRepository;

    @Test
    void test() {
        Name savedName = nameRepository.save(new Name("test"));

        assertThat(nameRepository.findById(savedName.getNameId()))
                .isPresent();
    }
}
