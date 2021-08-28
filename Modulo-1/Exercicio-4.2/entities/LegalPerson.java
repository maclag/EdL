package entities;

public class LegalPerson extends Person {
    private Integer employees;

    public LegalPerson() {
        super();
    }

    public LegalPerson (String name, Double annualIncome, Integer employees) {
        super(name, annualIncome);
        this.employees = employees;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees (Integer employees) {
        this.employees = employees;
    }

    @Override
    public double incomeTax() {
        if (employees > 10) {
            return getAnnualIncome() * 0.14;
        }
        return getAnnualIncome() * 0.16;
    }
}
