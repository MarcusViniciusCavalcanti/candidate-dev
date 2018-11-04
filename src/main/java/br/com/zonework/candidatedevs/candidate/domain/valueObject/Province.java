package br.com.zonework.candidatedevs.candidate.domain.valueObject;

import br.com.zonework.candidatedevs.structure.JPA.ObjectPersistence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "province")
public class Province extends ObjectPersistence {
    @Column private String name;
    @Column private String uf;

    @OneToMany(mappedBy = "province")
    private List<City> cities;
}
