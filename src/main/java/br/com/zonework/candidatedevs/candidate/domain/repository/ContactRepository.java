package br.com.zonework.candidatedevs.candidate.domain.repository;

import br.com.zonework.candidatedevs.candidate.domain.entity.Contact;
import br.com.zonework.candidatedevs.structure.JPA.Repository;

public class ContactRepository extends Repository<Contact> {
    public ContactRepository() {
        super(Contact.class);
    }

}
