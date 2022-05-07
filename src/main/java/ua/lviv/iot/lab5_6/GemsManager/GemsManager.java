package ua.lviv.iot.lab5_6.GemsManager;

import ua.lviv.iot.lab5_6.Exceptions.MakeMoreThanOneNecklaceException;
import ua.lviv.iot.lab5_6.Exceptions.NecklaceDoesNotExistException;
import ua.lviv.iot.lab5_6.Gem.Gem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GemsManager {

    private class Necklace{
        private int currentPrice;
        public int getCurrentPrice() {
            return currentPrice;
        }
        public void setCurrentPrice(int currentPrice) {
            this.currentPrice = currentPrice;
        }

        List<Gem> necklaseList = new ArrayList<>();

        public Necklace(int currentPrice){
            this.currentPrice = currentPrice;
        }
    }

    private Necklace necklace;

    public List<Gem> makeNecklace(List<Gem> list, int aboveThePrice) throws MakeMoreThanOneNecklaceException {
        if(necklace != null)
            throw new MakeMoreThanOneNecklaceException();

        necklace = new Necklace(aboveThePrice);

        for(Gem gem : list)
            if (gem.getPrice() > aboveThePrice)
                necklace.necklaseList.add(gem);


        return necklace.necklaseList;

    }

    public List<Gem> printNecklace() throws NecklaceDoesNotExistException {
        if(necklace == null)
            throw new NecklaceDoesNotExistException();

        necklace.necklaseList.forEach(System.out::println);

        return necklace.necklaseList;
    }

    public int printPriceInNeckLace() throws NecklaceDoesNotExistException {
        if(necklace == null)
            throw new NecklaceDoesNotExistException();
        System.out.println("Necklace MIN gems price: " + necklace.currentPrice + " usd");

        return necklace.getCurrentPrice();
    }

    public List<Gem> addGemToNecklace(Gem gem) throws NecklaceDoesNotExistException {
        if(necklace == null)
            throw new NecklaceDoesNotExistException();

        if(gem.getPrice() >= necklace.getCurrentPrice()){
            necklace.necklaseList.add(gem);

            return necklace.necklaseList;
        }else{
            System.out.println("Gem was not added to necklace, because its price is lower than in necklace");

            return necklace.necklaseList;
        }

    }

    public int setPriceInNecklace(int price) throws NecklaceDoesNotExistException {
        if(necklace == null)
            throw new NecklaceDoesNotExistException();
        if(price <= necklace.getCurrentPrice())
            necklace.setCurrentPrice(price);
        else
            System.out.println("You cannot set higher price that " + necklace.getCurrentPrice()
                                + ", because some gems will be removed from necklace");


        return necklace.getCurrentPrice();
    }

    public List<Gem> findInNecklaceByPurity(double from, double to) throws NecklaceDoesNotExistException {
        if(necklace == null)
            throw new NecklaceDoesNotExistException();

        return necklace.necklaseList.stream().
                filter(gem -> gem.getPurity() >= from && gem.getPurity() <= to).
                collect(Collectors.toList());
    }

    public List<Gem> sortByWeightAsc(List<Gem> list){

        return list.stream()
                .sorted(Comparator.comparing(Gem::getWeight))
                .collect(Collectors.toList());

    }

    public List<Gem> sortByWeightDesc(List<Gem> list){

        return list.stream()
                .sorted(Comparator.comparing(Gem::getWeight).reversed())
                .collect(Collectors.toList());

    }

    public List<Gem> sortByCostAsc(List<Gem> list){

        return list.stream()
                .sorted(Comparator.comparing(Gem::getCost))
                .collect(Collectors.toList());

    }

    public List<Gem> sortByCostDesc(List<Gem> list){

        return list.stream()
                .sorted(Comparator.comparing(Gem::getCost).reversed())
                .collect(Collectors.toList());

    }


}
