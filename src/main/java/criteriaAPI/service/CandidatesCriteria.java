package criteriaAPI.service;

import java.util.ArrayList;
import java.util.List;

import static criteriaAPI.service.CriteriaOperation.Operation.*;

public class CandidatesCriteria {

    private List<CriteriaOperation> criteriaState;

    public CandidatesCriteria(List<CriteriaOperation> criteriaState) {
        this.criteriaState = criteriaState;
    }

    public String toSqlString() {
        String selectSql = "select candidates.* from candidates";
        StringBuilder sql = new StringBuilder();
        if (criteriaState != null && !criteriaState.isEmpty()) {
            sql.append(" where");
            for (CriteriaOperation operation : criteriaState) {
                sql.append(operation.getColumn() != null ? " " + operation.getColumn() + " " : "");
                sql.append(operation.getOperation() != null ? " " + operation.getOperation().getSqlVal() : "");
                if (ENDWITH == operation.getOperation()) {
                    selectSql = selectSql + " join gender on gender.id=genderid";
                    sql.append(" '%" + operation.getValue() + "'");
                } else {
                    sql.append(operation.getValue() != null ? " '" + operation.getValue() + "'" : "");
                }
            }
        }
        sql.insert(0, selectSql);
        sql.append(";");
        return sql.toString();
    }

    public static class Builder {
        private List<CriteriaOperation> criteriaState;

        public Builder() {
            criteriaState = new ArrayList<>();
        }

        public Builder eq(String column, String value) {
            criteriaState.add(new CriteriaOperation(column, value, EQ));
            return this;
        }

        public Builder or() {
            criteriaState.add(new CriteriaOperation(OR));
            return this;
        }

        public Builder and() {
            criteriaState.add(new CriteriaOperation(AND));
            return this;
        }

        public Builder endWith(String column, String value) {
            criteriaState.add(new CriteriaOperation(column, value, ENDWITH));
            return this;
        }

        public CandidatesCriteria build() {
            return new CandidatesCriteria(criteriaState);
        }
    }
}
