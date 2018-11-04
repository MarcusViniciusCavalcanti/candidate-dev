package br.com.zonework.candidatedevs.candidate;

import br.com.zonework.candidatedevs.security.domain.repository.CredentialsRepositoryTest;
import org.h2.tools.RunScript;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestUtils {
    public static void readerDatabase(EntityManager em) {
        Session session = em.unwrap(Session.class);
        session.doWork(connection -> {
            try {

                File createProvince = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_province.sql").getFile());
                File createCity = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_city.sql").getFile());
                File createContacts = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_contacts.sql").getFile());
                File createCandidate = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_candidates.sql").getFile());
                File createCredentials = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_credentials.sql").getFile());

                RunScript.execute(connection, new FileReader(createCredentials));
                RunScript.execute(connection, new FileReader(createCandidate));
                RunScript.execute(connection, new FileReader(createProvince));
                RunScript.execute(connection, new FileReader(createCity));
                RunScript.execute(connection, new FileReader(createContacts));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("could not initialize with script");
            }
        });
    }
}
