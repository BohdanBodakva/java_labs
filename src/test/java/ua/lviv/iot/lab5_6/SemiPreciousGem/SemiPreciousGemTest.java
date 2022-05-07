package ua.lviv.iot.lab5_6.SemiPreciousGem;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.lab5_6.Gem.Hardness;

public class SemiPreciousGemTest {

    @Test
    public void testToString()
    {
        SemiPreciousGem gem = new SemiPreciousGem("Quartz", MineralityOfSemiPreciousGem.MINERAL,
                3.42,15, Hardness.HARD, 12000);

        String expected = "\nSemiPreciousGem {sort=Quartz,\tweight=15.0 carats" +
                ",\thardness=HARD,\tprice=12000 usd" +
                ",\tpurity=3.42,\tminerality=MINERAL}";
        Assertions.assertEquals(expected, gem.toString());
    }


}
