package entities;

public class Fisica extends Contribuidor {
    private Double healthExpenses;

    public Fisica(){
        super();
    }

    public Fisica(String name, Double annualIncome, Double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    @Override
    public Double taxCalc() {
        double tax = 0.0;

        if (super.annualIncome < 20000.00 ){
            tax = (super.annualIncome  * 0.15) - (healthExpenses * 0.5);
        } else {
            tax = (super.annualIncome * 0.25) - (healthExpenses * 0.5);
        }

        return tax;
    }
}
