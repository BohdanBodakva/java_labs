package PreciousGem;


import Gem.*;

public class PreciousGem extends Gem {
    private SortOfPreciousGem sort;

    public SortOfPreciousGem getSort() {
        return sort;
    }

    public PreciousGem(SortOfPreciousGem sort, double purity,
                       double weightInCarats, Hardness hardness, int price){
        super(weightInCarats, hardness, purity, price);
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "\nPreciousGem {" +
                "sort=" + sort +
                ",\tweight=" + super.getWeight() +
                " carats,\thardness=" + super.getHardness() +
                ",\tprice=" + super.getPrice() +
                " usd,\tpurity=" + super.getPurity() +
                "}";
    }


}


