package GemsManager;

import Gem.*;
import PreciousGem.PreciousGem;
import SemiPreciousGem.SemiPreciousGem;


import java.util.*;

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

    public void makeNecklace(List<Gem> list, int aboveThePrice){}

    public void printNecklace(){}

    public void printPriceInNeckLace(){}

    public void addGemToNecklace(Gem gem){}

    public void setPriceInNecklace(int price){}

    //public List<Gem> findInNecklaceByPurity(PurityOfGem purity){}

    public void sortByWeight(List<Gem> list, boolean ascending){}

    public void sortByCost(List<Gem> list, boolean ascending){}

}