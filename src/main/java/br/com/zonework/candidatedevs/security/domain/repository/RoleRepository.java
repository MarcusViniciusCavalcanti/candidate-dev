package br.com.zonework.candidatedevs.security.domain.repository;

import br.com.zonework.candidatedevs.security.domain.entity.Credential;
import br.com.zonework.candidatedevs.security.domain.entity.Role;
import br.com.zonework.candidatedevs.structure.JPA.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RoleRepository {
    private EntityManager entityManager;
    public RoleRepository() {
        this.entityManager = JPAUtils.entityManager("candidate");
    }

    public List<Role> findByCredentials(Credential credential) {

        TypedQuery<Role> list = entityManager.createQuery("SELECT Role FROM Credential c JOIN c.roles Role", Role.class);

        return Collections.unmodifiableList(list.getResultList());
    }

    public Optional<Role> findByName(String name) {
        Role role = entityManager.createQuery("SELECT r FROM Role r where r.name = :name", Role.class)
                .setParameter("name", name)
                .getSingleResult();
        return Optional.ofNullable(role);
    }
}
