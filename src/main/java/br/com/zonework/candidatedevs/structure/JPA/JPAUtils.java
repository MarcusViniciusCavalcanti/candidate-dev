package br.com.zonework.candidatedevs.structure.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private static EntityManager entityManager;

    public static EntityManager entityManager() {

        if (entityManager == null) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("candidate");
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
}
