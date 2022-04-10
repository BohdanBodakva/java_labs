package GemsManager;

import Gem.*;


import java.util.*;
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

        List<Gem> necklace = new ArrayList<>();

        private Necklace(int currentPrice){
            this.currentPrice = currentPrice;
        }
    }

    private Necklace necklace;

    public void makeNecklace(List<Gem> list, int aboveThePrice) throws Exception {
        if(necklace != null)
            throw new Exception("You cannot make more than one necklace!");

        necklace = new Necklace(aboveThePrice);

        for(Gem gem : list)
            if (gem.getPrice() > aboveThePrice)
                necklace.necklace.add(gem);


    }

    public void printNecklace(){
        necklace.necklace.forEach(System.out::println);
    }

    public void printPriceInNeckLace() throws Exception {
        if(necklace == null)
            throw new Exception("Firstly you must make a necklace!");
        System.out.println("Necklace MIN gems price: " + necklace.currentPrice + " usd");
    }

    public void addGemToNecklace(Gem gem) throws Exception {
        if(necklace == null)
            throw new Exception("Firstly you must make a necklace!");

        if(gem.getPrice() >= necklace.getCurrentPrice())
            necklace.necklace.add(gem);
        else
            System.out.println("You can add only gems with price higher than " + necklace.getCurrentPrice());

    }

    public void setPriceInNecklace(int price) throws Exception {
        if(necklace == null)
            throw new Exception("Firstly you must make a necklace!");
        if(price >= necklace.getCurrentPrice())
            necklace.setCurrentPrice(price);
        else
            System.out.println("You cannot set smaller price that " + necklace.getCurrentPrice());

    }

    public List<Gem> findInNecklaceByPurity(double from, double to){
        return necklace.necklace.stream().
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