package ua.lviv.iot.lab5_6.Gem;

public abstract class Gem {
    private double weightInCarats;
    private Hardness hardness;

    private int price;
    private double purity;
    public double getWeight() {
        return weightInCarats;
    }

    public Hardness getHardness() {
        return hardness;
    }

    public int getPrice() {
        return price;
    }

    public double getPurity() {
        return purity;
    }

    public Gem(double weightInCarats, Hardness hardness, double purity, int price) {
        this.weightInCarats = weightInCarats;
        this.hardness = hardness;
        this.price = price;
        this.purity = purity;
        this.cost = weightInCarats * price;
    }

    //only for sorting
    private double cost;

    public double getCost() {
        return cost;
    }


    public String getHeaders(){
        return "weightInCarats;hardness;price;purity";
    }


    public String toCSV(){
        return String.format("%.3f;%s;%d;%.3f", weightInCarats, hardness, price, purity);
    }


}
