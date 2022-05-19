package ua.lviv.iot.lab5_6.SemiPreciousGem;

import ua.lviv.iot.lab5_6.Gem.Gem;
import ua.lviv.iot.lab5_6.Gem.Hardness;

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
                ",\tweight=" + getWeight() +
                " carats,\thardness=" + getHardness() +
                ",\tprice=" + getPrice() +
                " usd,\tpurity=" + getPurity() +
                ",\tminerality=" + minerality +
                "}";
    }

    @Override
    public String getHeaders(){
        return "sort;"+super.getHeaders()+";minerality";
    }

    @Override
    public String toCSV(){
        return sort+";"+super.toCSV()+";"+minerality;
    }


}
