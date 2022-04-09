package Main;

import Gem.Gem;
import Gem.Hardness;
import GemsManager.GemsManager;
import PreciousGem.*;
import SemiPreciousGem.*;


import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        Gem gem3 = new SemiPreciousGem("quartz", MineralityOfSemiPreciousGem.MINERAL,
                6.0, 0.4, Hardness.HARD, 7500);
        Gem gem4 = new SemiPreciousGem("aquamarine", MineralityOfSemiPreciousGem.NON_MINERAL,
                1.4, 2.5, Hardness.SOFT, 2500);
        Gem gem1 = new PreciousGem(SortOfPreciousGem.Diamond, 10.9,
                9.6, Hardness.HARD, 20000);
        Gem gem2 = new PreciousGem(SortOfPreciousGem.Sapphire, 8.4,
                3.9, Hardness.SEMI_HARD, 15000);



        List<Gem> gemlist = Arrays.asList(gem3, gem4, gem1, gem2);

        GemsManager manager = new GemsManager();

        System.out.println(manager.sortByCostDesc(gemlist));
        //System.out.println(manager.sortByCostDesc(gemlist));

        //System.out.println(manager.sortByWeightAsc(gemlist));

    }
}
