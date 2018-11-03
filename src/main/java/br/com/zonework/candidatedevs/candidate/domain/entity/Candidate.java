package br.com.zonework.candidatedevs.candidate.domain.entity;

import br.com.zonework.candidatedevs.security.domain.entity.Credential;
import br.com.zonework.candidatedevs.structure.JPA.EntityApplication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "candidates")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidate extends EntityApplication {
    @Column private String name;
    @Column private LocalDate birthday;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Credential credential;
}

