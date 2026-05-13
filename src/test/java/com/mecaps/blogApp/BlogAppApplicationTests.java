package com.mecaps.blogApp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BlogAppApplicationTests {

	@Test
	void contextLoads() {
	}


    @Test
    public void addTwoNum(){
        assertEquals(4,2+2);
    }
}
