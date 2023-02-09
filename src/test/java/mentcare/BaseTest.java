package mentcare;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import mentapp.config.InitializeDB;

//run spring boot before tests
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BaseTest {

    public String baseUrl = "http://localhost:8080";
    @Autowired
    private InitializeDB initializeDB;

    public void clearDb(){
        initializeDB.clearDB();
    }
    @AfterEach
    public void resetDb(){
        initializeDB.resetDB();
    }
}