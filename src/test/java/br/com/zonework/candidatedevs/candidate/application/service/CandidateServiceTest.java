package br.com.zonework.candidatedevs.candidate.application.service;

import br.com.zonework.candidatedevs.candidate.TestUtils;
import br.com.zonework.candidatedevs.candidate.domain.agregator.ContactAggregator;
import br.com.zonework.candidatedevs.candidate.domain.entity.Candidate;
import br.com.zonework.candidatedevs.candidate.domain.entity.Contact;
import br.com.zonework.candidatedevs.candidate.domain.repository.CandidateRepository;
import br.com.zonework.candidatedevs.security.domain.entity.Credential;
import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;
import suiteTests.AbstractTest;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class CandidateServiceTest extends AbstractTest {
    @BeforeClass
    public static void initializeDatabase() {
        TestUtils.readerDatabase(em);
    }

    @Test
    public void deve_retornar_candidato_em_branco() {
        CandidateService service = new CandidateService();

        Credential credential = new Credential();
        credential.setUsername("nao@existe.com.br");

        Candidate candidateFromCredentials = service.getCandidateFromCredentials(credential);
        assertNotNull(candidateFromCredentials);
    }

    @Test
    public void deve_retornar_um_candidato_corretamente() {
        CandidateService service = new CandidateService();

        Credential credential = new Credential();
        credential.setUsername("marcus@candidate.com.br");

        Candidate candidateFromCredentials = service.getCandidateFromCredentials(credential);
        assertNotNull(candidateFromCredentials);
        assertThat(candidateFromCredentials.getName(), CoreMatchers.is("marcus"));
    }

    @Test
    public void deve_salvar_candidato_com_sucesso() {
        Contact contact = new ContactAggregator().getNewContactWithCity("Pinhão", "Paraná","rua tal testes");

        Candidate candidate = new Candidate();
        candidate.setContact(contact);

        CandidateRepository candidateRepository = new CandidateRepository();
        Optional<Candidate> save = candidateRepository.save(candidate);

        assertNotNull(save.get());
    }
}