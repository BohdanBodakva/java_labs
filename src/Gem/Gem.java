package Gem;

public abstract class Gem {
    private double weight;
    private Hardness hardness;
    private int price;
    private PurityOfGem purity;

    public double getWeight() {
        return weight;
    }

    public Hardness getHardness() {
        return hardness;
    }

    public int getPrice() {
        return price;
    }

    public PurityOfGem getPurity() {
        return purity;
    }

    public Gem(double weight, Hardness hardness, PurityOfGem purity, int price) {
        this.weight = weight;
        this.hardness = hardness;
        this.price = price;
        this.purity = purity;
    }
}
