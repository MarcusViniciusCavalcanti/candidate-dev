package br.com.zonework.candidatedevs.candidate.domain.repository;

import br.com.zonework.candidatedevs.candidate.domain.entity.Candidate;
import br.com.zonework.candidatedevs.structure.JPA.Repository;

public class CandidateRepository extends Repository<Candidate> {
    public CandidateRepository() {
        super(Candidate.class);
    }
}
