package br.com.zonework.candidatedevs.candidate.domain.repository;

import br.com.zonework.candidatedevs.candidate.domain.entity.Contact;
import br.com.zonework.candidatedevs.candidate.domain.valueObject.City;
import br.com.zonework.candidatedevs.candidate.domain.valueObject.Province;
import br.com.zonework.candidatedevs.security.domain.repository.CredentialsRepositoryTest;
import org.h2.tools.RunScript;
import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;
import suiteTests.AbstractTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.*;

public class ContactRepositoryTest extends AbstractTest {
    @BeforeClass
    public static void initializeDatabase() {
        Session session = em.unwrap(Session.class);
        session.doWork(connection -> {
            try {
                File createCity = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_city.sql").getFile());
                File createProvince = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_province.sql").getFile());
                File createContacts = new File(CredentialsRepositoryTest.class.getResource("/candidate_dev_contacts.sql").getFile());

                RunScript.execute(connection, new FileReader(createProvince));
                RunScript.execute(connection, new FileReader(createCity));
                RunScript.execute(connection, new FileReader(createContacts));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("could not initialize with script");
            }
        });
    }

    @Test
    public void deve_retonar_cidades_com_sucesso_pelo_nome() {
        ContactRepository contactRepository = new ContactRepository();
        Contact contact = contactRepository.findById(1).get();

        City city = contact.getCity();
        Province province = city.getProvince();
        assertNotNull(contact);
        assertNotNull(city);
        assertNotNull(province);
    }
}