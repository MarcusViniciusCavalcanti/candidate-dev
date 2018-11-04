package br.com.zonework.candidatedevs.security.domain.repository;

import br.com.zonework.candidatedevs.security.domain.entity.Credential;
import br.com.zonework.candidatedevs.structure.JPA.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CredentialsRepository  {
    private EntityManager entityManager;

    public CredentialsRepository(){
        entityManager = JPAUtils.entityManager("candidate");
    }

    public Optional<Credential> findByName(String username) {
        Credential credential = entityManager
                .createQuery("SELECT c FROM Credential As c WHERE c.username = :username", Credential.class)
                .setParameter("username", username)
                .getSingleResult();

        return Optional.ofNullable(credential);
    }

    public List<Credential> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Credential> criteriaQuery = criteriaBuilder.createQuery(Credential.class);
        Root<Credential> rootEntry = criteriaQuery.from(Credential.class);
        CriteriaQuery<Credential> all = criteriaQuery.select(rootEntry);
        TypedQuery<Credential> list = entityManager.createQuery(all);

        return Collections.unmodifiableList(list.getResultList());
    }

    public void save(Credential credential) {

        if (entityManager.getTransaction().isActive()) {
            entityManager.persist(credential);
        } else {
            entityManager.getTransaction().begin();
            entityManager.persist(credential);
            entityManager.getTransaction().commit();
        }

    }
}
