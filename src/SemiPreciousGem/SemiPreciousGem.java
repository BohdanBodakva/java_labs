package SemiPreciousGem;


import Gem.*;

public class SemiPreciousGem extends Gem {
    private String sort;
    private MineralityOfSemiPreciousGem minerality;

    public String getSort() {
        return sort;
    }

    public MineralityOfSemiPreciousGem getMinerality() {
        return minerality;
    }

    public SemiPreciousGem(String sort, MineralityOfSemiPreciousGem minerality, double purity,
                           double weightInCarats, Hardness hardness, int price){
        super(weightInCarats, hardness, purity, price);
        this.sort = sort;
        this.minerality = minerality;
    }

    @Override
    public String toString() {
        return "\nSemiPreciousGem {" +
                "sort=" + sort +
                ",\tweight=" + super.getWeight() +
                " carats,\thardness=" + super.getHardness() +
                ",\tprice=" + super.getPrice() +
                " usd,\tpurity=" + super.getPurity() +
                ",\tminerality=" + minerality +
                "}";
    }
}
