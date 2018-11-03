package br.com.zonework.candidatedevs.candidate.domain.entity;

import br.com.zonework.candidatedevs.security.domain.entity.Credential;
import br.com.zonework.candidatedevs.structure.JPA.EntityApplication;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "candidates")
public class Candidate extends EntityApplication {
    @ManyToOne
    private Credential credentials;

    public void setCredentials(Credential credentials) {
        this.credentials = credentials;
    }

    public Credential getCredentials() {
        return credentials;
    }
}
