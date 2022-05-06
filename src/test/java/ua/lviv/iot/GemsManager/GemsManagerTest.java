package ua.lviv.iot.GemsManager;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.Exceptions.MakeMoreThanOneNecklaceException;
import ua.lviv.iot.Exceptions.NecklaceDoesNotExistException;
import ua.lviv.iot.Gem.Gem;
import ua.lviv.iot.Gem.Hardness;
import ua.lviv.iot.PreciousGem.PreciousGem;
import ua.lviv.iot.PreciousGem.SortOfPreciousGem;
import ua.lviv.iot.SemiPreciousGem.MineralityOfSemiPreciousGem;
import ua.lviv.iot.SemiPreciousGem.SemiPreciousGem;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GemsManagerTest {

    static List<Gem> list = new ArrayList<>();

    @BeforeAll
    public static void createListOfGems()  {

        Gem gem1 = new PreciousGem(SortOfPreciousGem.Diamond, 10.9,
                9.6, Hardness.HARD, 20000);
        Gem gem2 = new PreciousGem(SortOfPreciousGem.Sapphire, 8.4,
                3.9, Hardness.SEMI_HARD, 15000);
        Gem gem3 = new SemiPreciousGem("quartz", MineralityOfSemiPreciousGem.MINERAL,
                6.0, 0.4, Hardness.HARD, 7500);
        Gem gem4 = new SemiPreciousGem("aquamarine", MineralityOfSemiPreciousGem.NON_MINERAL,
                1.4, 2.5, Hardness.SOFT, 2500);

        list = Arrays.asList(gem1, gem2, gem3, gem4);
    }

    @Test
    public void testMakeNecklace() throws MakeMoreThanOneNecklaceException {
        List<Gem> expectedList = Arrays.asList(list.get(0), list.get(1), list.get(2));

        GemsManager manager = new GemsManager();

        Assertions.assertEquals(expectedList, manager.makeNecklace(list, 7000));

        Assertions.assertThrows(MakeMoreThanOneNecklaceException.class, () ->
            manager.makeNecklace(list, 10000)
        );
    }

    @Test
    public void testAddGemToNecklace() throws NecklaceDoesNotExistException, MakeMoreThanOneNecklaceException {
        Gem g1 = new PreciousGem(SortOfPreciousGem.Emerald, 17.4,
                7.8, Hardness.HARD, 6000);
        Gem g2 = new PreciousGem(SortOfPreciousGem.Ruby, 1.4,
                2.2, Hardness.SEMI_HARD, 9700);


        GemsManager manager = new GemsManager();

        Assertions.assertThrows(NecklaceDoesNotExistException.class, () ->
                manager.addGemToNecklace(g1)
        );

        manager.makeNecklace(list, 7000);

        List<Gem> expectedList1 = Arrays.asList(list.get(0), list.get(1), list.get(2), g2);
        Assertions.assertEquals(expectedList1, manager.addGemToNecklace(g2));

        List<Gem> expectedList2 = Arrays.asList(list.get(0), list.get(1), list.get(2), g2);
        Assertions.assertEquals(expectedList2, manager.addGemToNecklace(g1));
    }


    @Test
    public void testPrintPriceInNecklace() throws NecklaceDoesNotExistException, MakeMoreThanOneNecklaceException {
        GemsManager manager = new GemsManager();

        Assertions.assertThrows(NecklaceDoesNotExistException.class, () ->
                manager.printPriceInNeckLace()
            );

        manager.makeNecklace(list, 7000);

        Assertions.assertEquals(7000, manager.printPriceInNeckLace());
    }

    @Test
    public void testPrintNecklace() throws NecklaceDoesNotExistException, MakeMoreThanOneNecklaceException {
        GemsManager manager = new GemsManager();

        Assertions.assertThrows(NecklaceDoesNotExistException.class, () ->
                manager.printNecklace()
            );

        manager.makeNecklace(list, 7000);
        List<Gem> expectedList = Arrays.asList(list.get(0), list.get(1), list.get(2));

        Assertions.assertEquals(expectedList, manager.printNecklace());
    }

    @Test
    public void testSetPriceInNecklace() throws NecklaceDoesNotExistException, MakeMoreThanOneNecklaceException {
        GemsManager manager = new GemsManager();

        Assertions.assertThrows(NecklaceDoesNotExistException.class, () ->
                manager.setPriceInNecklace(8000)
            );

        manager.makeNecklace(list, 2500);

        Assertions.assertEquals(2000, manager.setPriceInNecklace(2000));

        Assertions.assertEquals(2000, manager.setPriceInNecklace(2100));
    }


    @Test
    public void testFindInNecklaceByPurity() throws NecklaceDoesNotExistException, MakeMoreThanOneNecklaceException {
        GemsManager manager = new GemsManager();

        Assertions.assertThrows(NecklaceDoesNotExistException.class, () ->
                manager.findInNecklaceByPurity(6, 9)
            );

        manager.makeNecklace(list, 7000);

        List<Gem> expectedList = Arrays.asList(list.get(1), list.get(2));

        Assertions.assertEquals(expectedList, manager.findInNecklaceByPurity(6, 9));
    }


    @Test
    public void testSortByWeightAsc(){
        GemsManager manager = new GemsManager();
        List<Gem> expectedList = Arrays.asList(list.get(2), list.get(3), list.get(1), list.get(0));

        Assertions.assertEquals(expectedList, manager.sortByWeightAsc(list));

    }


    @Test
    public void testSortByWeightDesc(){
        GemsManager manager = new GemsManager();
        List<Gem> expectedList = Arrays.asList(list.get(0), list.get(1), list.get(3), list.get(2));

        Assertions.assertEquals(expectedList, manager.sortByWeightDesc(list));

    }

    @Test
    public void sortByCostAsc(){
        GemsManager manager = new GemsManager();
        List<Gem> expectedList = Arrays.asList(list.get(2), list.get(3), list.get(1), list.get(0));

        Assertions.assertEquals(expectedList, manager.sortByCostAsc(list));

    }

    @Test
    public void sortByCostDesc(){
        GemsManager manager = new GemsManager();
        List<Gem> expectedList = Arrays.asList(list.get(0), list.get(1), list.get(3), list.get(2));

        Assertions.assertEquals(expectedList, manager.sortByCostDesc(list));

    }


}
