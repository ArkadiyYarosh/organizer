package by.bsuir.yarosh.dao.test;

import by.bsuir.yarosh.domain.*;
import by.bsuir.yarosh.sevice.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class TestUser {

    @Autowired
    private IUserService service;

    @Test
    @Rollback(false)
    public void testCreate() {
        User user = new User();
        user.setFirstName("Arkadiy");
        user.setLastName("Yarosh");
        user.setLogin("arkadiy");
        user.setPassword("root");
        user.setRights(1);
        user.setSecondName("Yarosh");

        HashMap<String, Object> map = new LinkedHashMap<>();

        map.put("login", "ar");

        for(User u: service.getUsers(map, 0, 0, null)) {
            System.out.println(u.toString());
        }
    }
}
