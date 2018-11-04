package br.com.zonework.candidatedevs.candidate.application.service;

import br.com.zonework.candidatedevs.candidate.domain.entity.Candidate;
import br.com.zonework.candidatedevs.candidate.domain.repository.CandidateRepository;
import br.com.zonework.candidatedevs.security.domain.entity.Credential;

import javax.transaction.Transactional;

public class CandidateService {

    @Transactional
    public Candidate getCandidateFromCredentials(Credential credential) {
        CandidateRepository repository = new CandidateRepository();
        return repository.findByCredentials(credential).orElse(new Candidate());
    }
}
