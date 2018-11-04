package br.com.zonework.candidatedevs.candidate.domain.entity;

import br.com.zonework.candidatedevs.candidate.domain.valueObject.City;
import br.com.zonework.candidatedevs.structure.JPA.ObjectPersistence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "contact")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contact extends ObjectPersistence {
    @Column private String street;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;
}
