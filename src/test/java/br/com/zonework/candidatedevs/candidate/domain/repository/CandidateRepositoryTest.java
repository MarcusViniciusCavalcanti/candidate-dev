package br.com.zonework.candidatedevs.candidate.domain.repository;

import br.com.zonework.candidatedevs.candidate.domain.entity.Candidate;
import br.com.zonework.candidatedevs.security.domain.entity.Credential;
import br.com.zonework.candidatedevs.security.domain.entity.Role;
import br.com.zonework.candidatedevs.security.domain.repository.CredentialsRepositoryTest;
import org.h2.tools.RunScript;
import org.hamcrest.CoreMatchers;
import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;
import suiteTests.AbstractTest;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class CandidateRepositoryTest extends AbstractTest {
    @BeforeClass
    public static void initializeDatabase() {
        Session session = em.unwrap(Session.class);
        session.doWork(connection -> {
            try {
                File createCandidate = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_candidates.sql").getFile());
                File createCredentials = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_credentials.sql").getFile());

                RunScript.execute(connection, new FileReader(createCredentials));
                RunScript.execute(connection, new FileReader(createCandidate));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("could not initialize with script");
            }
        });
    }

    @Test
    public void should_return_correct_candidate() {
        checkObjetNull("marcus");
    }

    @Transactional
    @Test
    public void deve_salvar_corretamente_um_candidato() {
        Credential candidateCredentials = new Credential();
        candidateCredentials.setUsername("candidate@candidate.com");
        candidateCredentials.setPassword("65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5");

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setName("candidate");
        roles.add(role);

        candidateCredentials.setRoles(roles);
        candidateCredentials.setLocked(false);
        Candidate candidate = new Candidate();
        candidate.setName("test-candidate");
        candidate.setCredential(candidateCredentials);

        CandidateRepository repository = new CandidateRepository();
        Optional<Candidate> save = repository.save(candidate);

        checkObjetNull(save.get().getName());
    }

    @Test
    public void deve_retornar_corretamente_umca_candidato_pela_credentials() {
        CandidateRepository repository = new CandidateRepository();

        Credential credential = em.find(Credential.class, "marcus@candidate.com.br");
        assertNotNull(credential);

        Candidate candidate = repository.findByCredentials(credential).get();
        assertNotNull(candidate);
        assertThat(candidate.getName(), CoreMatchers.is("marcus"));

    }

    private void checkObjetNull(String name) {
        CandidateRepository repository = new CandidateRepository();
        Optional<Candidate> candidate = repository.finByName(name);
        assertNotNull(candidate.get());
    }
}