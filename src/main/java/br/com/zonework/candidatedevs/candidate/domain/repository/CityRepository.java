package br.com.zonework.candidatedevs.candidate.domain.repository;

import br.com.zonework.candidatedevs.candidate.domain.valueObject.City;
import br.com.zonework.candidatedevs.structure.JPA.Repository;

import javax.persistence.NoResultException;
import java.util.Optional;

public class CityRepository extends Repository<City> {
    public CityRepository() {
        super(City.class);
    }

    public Optional<City> finByNameInProvince(String name, String province) {
        try {
            City city = entityManager
                    .createQuery("SELECT c FROM City c join c.province p WHERE  c.name = :name and  p.name = :province", City.class)
                    .setParameter("name", name)
                    .setParameter("province", province)
                    .getSingleResult();
            return Optional.of(city);
        } catch (NoResultException ex) {
            return Optional.empty();
        }

    }
}
