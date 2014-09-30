package is.ru.honn.ruber.test;

import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.service.RuberService;
import is.ru.honn.ruber.service.ServiceException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-stub.xml")
public class TestRuberService extends TestCase {

    Logger log = Logger.getLogger(TestRuberService.class.getName());

    @Autowired
    private RuberService service;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSignup(){
        User theUser = new User(
                "7354db54-cc9b-4961-81f2-0094b8e2d215",
                "theUser",
                "The",
                "User",
                "p@ssW0rd",
                "theUser@ru.is",
                "thePicture.jpg",
                "");

        try {
            service.signup(theUser);
        } catch (ServiceException e){

        }

        User user = service.getUser("theUser");
        assertNotNull(user);
    }


    @Test(expected = ServiceException.class)
    public void testSignupDuplicate() throws Exception{

        User aUser = new User(
                "7354db54-cc9b-4961-81f2-0094b8e2d217",
                "aUser",
                "A",
                "User",
                "p@ssW0rd",
                "aUser@ru.is",
                "aPicture.jpg",
                "");

        service.signup(aUser);
        service.signup(aUser);
    }

    /*
    @Test
    public void testUser() {
        log.info("testUser");
        fail();

    }

    @Test
    public void testActivity() {
        log.info("testActivity");
        fail();
    }
    */
}
