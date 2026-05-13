package com.mecaps.blogApp.serviceTest;

import com.mecaps.blogApp.entity.Users;
import com.mecaps.blogApp.repository.UsersRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UsersRepository usersRepository;
    @Disabled
    @Test
    public  void TestMethod(){
        assertEquals(4,2+2);
        assertNotNull(4,String.valueOf(2+2));
    }
    @Test
    public void test(){
        assertEquals(4,2+2);
        assertNotNull(4,String.valueOf(2+2));
        assertTrue(5 > 3);
    }
    @Test
    public void testFindByEmailMethod(){
        Optional<Users> byEmail = usersRepository.findByEmail("john.doe@example.com");
        assertEquals("john.doe@example.com",byEmail.get().getEmail());
    }

    @ParameterizedTest
    @CsvSource({
            "john.doe@example.com",
            "john.doe@555example.com"
    })
    public void testFindByEmailMethod(String email){
        Optional<Users> byEmail = usersRepository.findByEmail(email);
        assertEquals(byEmail,byEmail.get().getEmail());
    }

    @ParameterizedTest
    @CsvSource({
         "2,2,4",
            "5,6,2",
            "2,8,10",
            "6,6,12"
    })
    public void paraMeterTesting(int a,int b ,int excepted){
        assertEquals(excepted, a+b);
    }
}
