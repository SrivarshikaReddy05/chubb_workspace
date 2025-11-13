
public class CarLoan {

    protected String model;
    protected int cost;
    protected int loanAmount;
    protected int time; // in years
    protected int rate; // annual interest rate in %

    // Constructor to initialize the loan
    public CarLoan(String model, int paid, int time, int rate) {
        this.model = model;
        this.cost = getCostByModel(model);
        this.loanAmount = this.cost - paid;
        this.time = time;
        this.rate = rate;
    }

    // Private method to get car cost based on model
    private int getCostByModel(String model) {
        switch(model.toLowerCase()) {
            case "alpha": return 1200000;
            case "beta":  return 1000000;
            case "delta": return 800000;
            default:
                System.out.println("Invalid model! Setting cost = 0");
                return 0;
        }
    }

    // Method to calculate Simple Interest and EMI
    public void calculateSI() {
        double si = (loanAmount * time * rate) / 100.0;
        System.out.println("Simple Interest: " + si);

        double total = loanAmount + si;
        double emi = total / (time * 12);
        System.out.println("EMI (Simple Interest): " + emi);
    }

    // Method to calculate Compound Interest and EMI
    public void calculateCI() {
        double amount = loanAmount * Math.pow((1 + rate / 100.0), time);
        double ci = amount - loanAmount;
        System.out.println("Compound Interest: " + ci);

        double emi = amount / (time * 12);
        System.out.println("EMI (Compound Interest): " + emi);
    }
}
