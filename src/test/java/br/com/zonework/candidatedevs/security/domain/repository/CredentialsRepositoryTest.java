package br.com.zonework.candidatedevs.security.domain.repository;

import br.com.zonework.candidatedevs.security.domain.entity.Credential;
import org.h2.tools.RunScript;
import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;
import suiteTests.AbstractTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.assertNotNull;

public class CredentialsRepositoryTest extends AbstractTest {

    @BeforeClass
    public static void initializeDatabase() {
        Session session = em.unwrap(Session.class);
        session.doWork(connection -> {
            try {
                File script = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_credentials.sql").getFile());
                RunScript.execute(connection, new FileReader(script));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("could not initialize with script");
            }
        });
    }

    @Test
    public void should_have_get_credentials() {
        checkObjectIsNotNull("marcus@admin.com.br");
    }

    @Test
    public void should_have_save_credentials() {
        Credential credential = new Credential();
        String username = "marcus";
        credential.setUsername(username);
        credential.setPassword("password");
        credential.setLocked(false);

        CredentialsRepository repository = new CredentialsRepository();
        repository.save(credential);

        checkObjectIsNotNull(username);
    }

    private void checkObjectIsNotNull(String username) {
        Credential credential = em.find(Credential.class, username);
        assertNotNull(credential);
    }

}