package br.com.zonework.candidatedevs.candidate.domain.repository;

import br.com.zonework.candidatedevs.candidate.domain.entity.Candidate;
import br.com.zonework.candidatedevs.security.domain.entity.Credential;
import br.com.zonework.candidatedevs.security.domain.entity.Role;
import br.com.zonework.candidatedevs.security.domain.repository.CredentialsRepository;
import br.com.zonework.candidatedevs.security.domain.repository.CredentialsRepositoryTest;
import br.com.zonework.candidatedevs.structure.JPA.Repository;
import org.h2.tools.RunScript;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import suiteTests.AbstractTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

public class CandidateRepositoryTest extends AbstractTest {
    @BeforeClass
    public static void initializeDatabase() {
        Session session = em.unwrap(Session.class);
        session.doWork(connection -> {
            try {
                File createCandidate = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_candidates.sql").getFile());
                File createCredentials = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_credentials.sql").getFile());
                File createRoles = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_credentials_roles.sql").getFile());

//                RunScript.execute(connection, new FileReader(createRoles));
                RunScript.execute(connection, new FileReader(createCredentials));
                RunScript.execute(connection, new FileReader(createCandidate));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("could not initialize with script");
            }
        });
    }

    @Test
    public void should_return_correct_candidate() {
        CandidateRepository repository = new CandidateRepository();
        Optional<Candidate> candidate = repository.finByName("marcus");
        assertNotNull(candidate.get());

    }

    @Test
    public void should_have_save_correct_candidate() {
        Credential candidateCredentials = new Credential();
        candidateCredentials.setUsername("candidate@candidate.com");
        candidateCredentials.setPassword("65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5");

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setName("candidate");
        roles.add(role);

        candidateCredentials.setRoles(roles);
        candidateCredentials.setLocked(false);

        CredentialsRepository credentialsRepository = new CredentialsRepository();
        credentialsRepository.save(candidateCredentials);


        Candidate candidate = new Candidate();
        candidate.setCredentials(candidateCredentials);
    }

    @Test
    public void should_have_correct_candidate_by_credentials() {

    }

    private void checkObjectIsNotNull(String name) {
        Candidate candidate = em.find(Candidate.class, name);
        assertNotNull(candidate);
    }

}