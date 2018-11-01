package br.com.zonework.candidatedevs.security.domain.repository;

import br.com.zonework.candidatedevs.security.domain.entity.Credential;
import br.com.zonework.candidatedevs.security.domain.entity.Role;
import br.com.zonework.candidatedevs.structure.utils.EncoderPassword;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class CredentialsRepositoryTest {



    @Test
    public void should_have_save_success() {

        Credential credential = new Credential();
        credential.setUsername("marcus@lero.com.br");
        credential.setPassword(EncoderPassword.encode("qwerty"));
        credential.setLocked(false);
//
        RoleRepository roleRepository = new RoleRepository();
        Role role = roleRepository.findByName("candidate").get();
        HashSet<Role> roles = new HashSet<>();
        roles.add(role);

        credential.setRoles(roles);
        //
//
        CredentialsRepository repository = new CredentialsRepository();
        repository.save(credential);
    }

}