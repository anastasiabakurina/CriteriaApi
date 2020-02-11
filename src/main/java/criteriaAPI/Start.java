package criteriaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import criteriaAPI.service.CandidatesCriteria;
import criteriaAPI.service.CandidatesService;

@SpringBootApplication
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
        CandidatesService candidatesService = new CandidatesService();
        CandidatesCriteria candidatesCriteria = new CandidatesCriteria.Builder().endWith("surname", "ов")
                .or().eq("gender", "female").build();
        System.out.println(candidatesService.execute(candidatesCriteria));
    }
}


