package ua.lviv.iot.GemsManager;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import ua.lviv.iot.Exceptions.MakeMoreThanOneNecklaceException;
import ua.lviv.iot.Exceptions.NecklaceDoesNotExistException;
import ua.lviv.iot.Gem.Gem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GemsManager {

    private class Necklace{
        private int currentPrice;
        private int getCurrentPrice() {
            return currentPrice;
        }
        private void setCurrentPrice(int currentPrice) {
            this.currentPrice = currentPrice;
        }

        List<Gem> neckList = new ArrayList<>();

        private Necklace(int currentPrice){
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
                necklace.neckList.add(gem);


        return necklace.neckList;

    }

    public List<Gem> printNecklace() throws NecklaceDoesNotExistException {
        if(necklace == null)
            throw new NecklaceDoesNotExistException();

        necklace.neckList.forEach(System.out::println);

        return necklace.neckList;
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
            necklace.neckList.add(gem);

            return necklace.neckList;
        }else{
            System.out.println("Gem was not added to necklace, because its price is lower than in necklace");

            return necklace.neckList;
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

        return necklace.neckList.stream().
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
