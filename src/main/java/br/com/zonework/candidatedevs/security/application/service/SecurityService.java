package br.com.zonework.candidatedevs.security.application.service;

import br.com.zonework.candidatedevs.security.domain.entity.Credential;
import br.com.zonework.candidatedevs.security.domain.entity.Role;
import br.com.zonework.candidatedevs.security.domain.repository.CredentialsRepository;
import br.com.zonework.candidatedevs.security.domain.repository.RoleRepository;

import javax.security.auth.login.LoginException;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SecurityService {

    public Credential getCredentialWith(String username) throws LoginException {
        CredentialsRepository credentialsRepository = new CredentialsRepository();
        Optional<Credential> credential = credentialsRepository.findByName(username);

        return credential.orElseThrow(LoginException::new);
    }

    public Set<Role> getRoleWith(String... names) {
        RoleRepository roleRepository = new RoleRepository();
        return Arrays.stream(names)
                .map(name -> roleRepository.findByName(name).orElseThrow(IllegalArgumentException::new))
                .collect(Collectors.toSet());

    }

    public Credential createCredentialsFor(String username, String email, String password) {
//        Members members = new Members();
//        members.setName(username);
//
//        Credential credential = new Credential();
//        credential.setMember(members);
//        credential.setUsername(email);
//        String encode = EncoderPassword.encode(password);
//        credential.setPassword(encode);
//        credential.setLocked(false);
//
//        Set<Role> roles = getRoleWith("candidate");
//
//        credential.setRoles(roles);
//
//        members.setCredential(credential);
//
//        CredentialsRepository repository = new CredentialsRepository();
//        repository.save(credential);

        return null;
    }

    @Transactional
    public void createCredentialsFor(Credential credentials) {
        CredentialsRepository credentialsRepository = new CredentialsRepository();
        credentialsRepository.save(credentials);
    }
}
