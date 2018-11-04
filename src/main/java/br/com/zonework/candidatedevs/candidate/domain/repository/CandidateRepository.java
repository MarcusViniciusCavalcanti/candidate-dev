package br.com.zonework.candidatedevs.candidate.domain.repository;

import br.com.zonework.candidatedevs.candidate.domain.entity.Candidate;
import br.com.zonework.candidatedevs.security.domain.entity.Credential;
import br.com.zonework.candidatedevs.structure.JPA.Repository;

import javax.persistence.NoResultException;
import java.util.Optional;

public class CandidateRepository extends Repository<Candidate> {
    public CandidateRepository() {
        super(Candidate.class);
    }

    public Optional<Candidate> finByName(String name) {
        Candidate credential = entityManager
                .createQuery("SELECT c FROM Candidate As c WHERE c.name = :name", Candidate.class)
                .setParameter("name", name)
                .getSingleResult();

        return Optional.ofNullable(credential);
    }

    public Optional<Candidate> findByCredentials(Credential credential) {
        String query = "SELECT c FROM Candidate  c WHERE c.credential = :credential";
        try {
            Candidate candidate = entityManager
                    .createQuery(query, Candidate.class)
                    .setParameter("credential", credential)
                    .getSingleResult();
            return Optional.of(candidate);
        } catch (NoResultException exception) {
            return Optional.empty();
        }
    }
}
