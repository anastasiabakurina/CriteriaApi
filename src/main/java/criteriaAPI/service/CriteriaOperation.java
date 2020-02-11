package criteriaAPI.service;

public class CriteriaOperation {
    public enum Operation {
        OR("or"),
        AND("and"),
        EQ("="),
        ENDWITH("like");

        private String sqlVal;

        Operation(String sqlVal) {
            this.sqlVal = sqlVal;
        }

        public String getSqlVal() {
            return sqlVal;
        }
    }

    private String column;
    private String value;
    private Operation operation;

    public CriteriaOperation(Operation operation) {
        this.operation = operation;
    }

    public CriteriaOperation(String column, String value, Operation operation) {
        this.column = column;
        this.value = value;
        this.operation = operation;
    }

    public String getColumn() {
        return column;
    }

    public String getValue() {
        return value;
    }

    public Operation getOperation() {
        return operation;
    }
}
