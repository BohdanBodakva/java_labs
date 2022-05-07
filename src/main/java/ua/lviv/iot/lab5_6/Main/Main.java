package ua.lviv.iot.lab5_6.Main;

import ua.lviv.iot.lab5_6.Exceptions.MakeMoreThanOneNecklaceException;
import ua.lviv.iot.lab5_6.Exceptions.NecklaceDoesNotExistException;
import ua.lviv.iot.lab5_6.Gem.Gem;
import ua.lviv.iot.lab5_6.Gem.Hardness;
import ua.lviv.iot.lab5_6.GemsManager.GemsManager;
import ua.lviv.iot.lab5_6.PreciousGem.PreciousGem;
import ua.lviv.iot.lab5_6.PreciousGem.SortOfPreciousGem;
import ua.lviv.iot.lab5_6.SemiPreciousGem.MineralityOfSemiPreciousGem;
import ua.lviv.iot.lab5_6.SemiPreciousGem.SemiPreciousGem;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MakeMoreThanOneNecklaceException, NecklaceDoesNotExistException {
        Gem gem1 = new PreciousGem(SortOfPreciousGem.Diamond, 10.9,
                9.6, Hardness.HARD, 20000);
        Gem gem2 = new PreciousGem(SortOfPreciousGem.Sapphire, 8.4,
                3.9, Hardness.SEMI_HARD, 15000);
        Gem gem3 = new SemiPreciousGem("quartz", MineralityOfSemiPreciousGem.MINERAL,
                6.0, 0.4, Hardness.HARD, 7500);
        Gem gem4 = new SemiPreciousGem("aquamarine", MineralityOfSemiPreciousGem.NON_MINERAL,
                1.4, 2.5, Hardness.SOFT, 2500);




        List<Gem> gemlist = Arrays.asList(gem3, gem4, gem1, gem2);

        GemsManager manager = new GemsManager();

        System.out.println(manager.sortByCostDesc(gemlist));

        manager.makeNecklace(gemlist, 7000);
        manager.addGemToNecklace(new PreciousGem(SortOfPreciousGem.Emerald,
                20.2, 14.4, Hardness.SOFT, 21000));

        manager.printNecklace();
        manager.printPriceInNeckLace();



    }
}
