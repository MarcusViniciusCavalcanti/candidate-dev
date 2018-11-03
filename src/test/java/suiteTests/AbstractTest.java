package suiteTests;

import br.com.zonework.candidatedevs.structure.JPA.JPAUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class AbstractTest {
    protected static EntityManager em;

    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        em = JPAUtils.entityManager("candidate-dev-test");
    }

    @AfterClass
    public static void tearDown(){
        em.clear();
        em.close();
    }
}
