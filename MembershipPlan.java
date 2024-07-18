package gymmanagement;

public class MembershipPlan {
    private int id;
    private String name;
    private int durationMonths;
    private double pricePerMonth;

    public MembershipPlan(String name, int durationMonths, double pricePerMonth) {
        this.name = name;
        this.durationMonths = durationMonths;
        this.pricePerMonth = pricePerMonth;
    }

    public MembershipPlan(int id, String name, int durationMonths, double pricePerMonth) {
        this.id = id;
        this.name = name;
        this.durationMonths = durationMonths;
        this.pricePerMonth = pricePerMonth;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public double getPricePerMonth() {
        return pricePerMonth;
    }
}
