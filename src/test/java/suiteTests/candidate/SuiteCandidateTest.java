package suiteTests.candidate;

import br.com.zonework.candidatedevs.candidate.application.service.CandidateServiceTest;
import br.com.zonework.candidatedevs.candidate.domain.repository.CandidateRepositoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {
        CandidateRepositoryTest.class,
        CandidateServiceTest.class
})
public class SuiteCandidateTest {
}

