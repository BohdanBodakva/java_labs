package ua.lviv.iot.PreciousGem;

import ua.lviv.iot.Gem.Gem;
import ua.lviv.iot.Gem.Hardness;

import java.util.Objects;

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
                ",\tweight=" + getWeight() +
                " carats,\thardness=" + getHardness() +
                ",\tprice=" + getPrice() +
                " usd,\tpurity=" + getPurity() +
                "}";
    }


}
