package suiteTests.security;

import br.com.zonework.candidatedevs.security.domain.repository.CredentialsRepositoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {
        CredentialsRepositoryTest.class
})
public class SuiteSecurityTest {
}
