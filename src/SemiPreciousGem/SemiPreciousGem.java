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

    public SemiPreciousGem(String sort, MineralityOfSemiPreciousGem minerality, PurityOfGem purity,
                           double weight, Hardness hardness, int price){
        super(weight, hardness, purity, price);
        this.sort = sort;
        this.minerality = minerality;
    }

    @Override
    public String toString() {
        return "SemiPreciousGem {" +
                "sort=" + sort +
                ",\tminerality=" + minerality +
                ",\tweight=" + super.getWeight() +
                ",\thardness=" + super.getHardness() +
                ",\tprice=" + super.getPrice() +
                " usd,\tpurity=" + super.getPurity() +
                '}';
    }
}