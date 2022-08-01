package entities;

public class Juridica extends Contribuidor {
    private Integer workerQuant;

    public Juridica(){
        super();
    }

    public Juridica(String name, Double annualIncome, Integer workerQuant) {
        super(name, annualIncome);
        this.workerQuant = workerQuant;
    }

    public Integer getWorkerQuant() {
        return workerQuant;
    }

    public void setWorkerQuant(Integer workerQuant) {
        this.workerQuant = workerQuant;
    }

    @Override
    public Double taxCalc() {
        double tax = 0.0;

        if (workerQuant <= 10){
            tax = super.annualIncome * 0.16;
        } else {
            tax = super.annualIncome * 0.14;
        }

        return tax;
    }
}
