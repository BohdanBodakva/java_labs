package ua.lviv.iot.lab5_6.PreciousGem;

import ua.lviv.iot.lab5_6.Gem.Gem;
import ua.lviv.iot.lab5_6.Gem.Hardness;

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

    @Override
    public String getHeaders(){
        return "sort;"+super.getHeaders();
    }

    @Override
    public String toCSV(){
        return sort+";"+super.toCSV();
    }

}
