package Main;

import Gem.*;
import GemsManager.*;
import PreciousGem.*;
import SemiPreciousGem.*;

public class Main {
    public static void main(String[] args) {
        Gem gem1 = new PreciousGem(SortOfPreciousGem.Diamond, PurityOfGem.PURE,
                0.6, Hardness.HARD, 20000);
        Gem gem2 = new PreciousGem(SortOfPreciousGem.Sapphire, PurityOfGem.SEMI_PURE,
                0.9, Hardness.SEMI_HARD, 15000);
        Gem gem3 = new SemiPreciousGem("quartz", MineralityOfSemiPreciousGem.MINERAL,
                PurityOfGem.NON_PURE, 0.4, Hardness.HARD, 7500);
        Gem gem4 = new SemiPreciousGem("aquamarine", MineralityOfSemiPreciousGem.NON_MINERAL,
                PurityOfGem.SEMI_PURE, 2.5, Hardness.SOFT, 2500);


        GemsManager manager = new GemsManager();


    }
}
