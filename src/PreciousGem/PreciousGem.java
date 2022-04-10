package PreciousGem;


import Gem.*;

public class PreciousGem extends Gem {
    private SortOfPreciousGem sort;

    public SortOfPreciousGem getSort() {
        return sort;
    }

    public PreciousGem(SortOfPreciousGem sort, PurityOfGem purity,
                       double weight, Hardness hardness, int price){
        super(weight, hardness, purity, price);
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "PreciousGem {" +
                "sort=" + sort +
                ",\tweight=" + super.getWeight() +
                ",\thardness=" + super.getHardness() +
                ",\tprice=" + super.getPrice() +
                " usd,\tpurity=" + super.getPurity() +
                '}';
    }


}

