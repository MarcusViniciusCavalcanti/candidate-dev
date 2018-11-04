package br.com.zonework.candidatedevs.candidate.domain.valueObject;

import br.com.zonework.candidatedevs.candidate.domain.entity.Contact;
import br.com.zonework.candidatedevs.structure.JPA.ObjectPersistence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City extends ObjectPersistence {
    @Column private String name;

    @OneToMany(mappedBy = "city")
    private List<Contact> contacts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province")
    private Province province;

    public City(String name) {
        this.name = name;
    }
}
