package entities;

public class NaturalPerson extends Person {
    private Double healthExpenses;

    public NaturalPerson() {
        super();
    }

    public NaturalPerson (String name, Double annualIncome, Double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses (Double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    @Override
    public double incomeTax() {
        double healthCare = healthExpenses * 0.5;
        if (getAnnualIncome() < 20000.0) {
            return getAnnualIncome() * 0.15 - healthCare;
        }
        else {
            return getAnnualIncome() * 0.25 - healthCare;
        }
    }
}
