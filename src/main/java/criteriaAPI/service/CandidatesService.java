package criteriaAPI.service;

import criteriaAPI.model.Candidates;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;


public class CandidatesService {

    private static EntityManager entityManager =
            Persistence.createEntityManagerFactory("unitCandidates").createEntityManager();

    public List<Candidates> execute(CandidatesCriteria candidatesCriteria) {
        return entityManager.createNativeQuery(candidatesCriteria.toSqlString(), Candidates.class).getResultList();
    }

}

