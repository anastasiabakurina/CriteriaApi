package criteriaAPI.service;

import criteriaAPI.model.Candidates;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertTrue;

public class CandidatesServiceTest {

    private CandidatesService service = new CandidatesService();

    @Test
    public void findNameAndSurnameAndMiddleName() {
        CandidatesCriteria candidatesCriteria = new CandidatesCriteria.Builder().eq("name", "Мария").and()
                .eq("surname", "Морская").and().eq("middlename", "Васильевна").build();
        List<Candidates> result = service.execute(candidatesCriteria);

        assertThat(result, is(notNullValue()));
        assertThat(result.size(), is(1));
        Candidates candidat = result.get(0);
        assertThat(candidat.getName(), is("Мария"));
        assertThat(candidat.getSurname(), is("Морская"));
        assertThat(candidat.getPatronymic(), is("Васильевна"));
    }

    @Test
    public void findEndSurnameOrGender() {
        CandidatesCriteria candidatesCriteria = new CandidatesCriteria.Builder().endWith("surname", "ов")
                .or().eq("gender", "female").build();
        List<Candidates> result = service.execute(candidatesCriteria);

        assertThat(result, is(notNullValue()));
        assertThat(result.size(), is(3));
        assertTrue(hasItemWithProperty(result, "Петр", "Петров", "Петрович"));
        assertTrue(hasItemWithProperty(result, "Иван", "Иванов", "Иванович"));
        assertTrue(hasItemWithProperty(result, "Мария", "Морская", "Васильевна"));
    }

    private boolean hasItemWithProperty(List<Candidates> candidates, String name, final String surname, final String patronymic) {
        return candidates.stream()
                .anyMatch(c -> name.equals(c.getName())
                        && surname.equals(c.getSurname())
                        && patronymic.equals(c.getPatronymic()));
    }
}