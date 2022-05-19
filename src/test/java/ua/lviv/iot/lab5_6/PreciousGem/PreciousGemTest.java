package ua.lviv.iot.lab5_6.PreciousGem;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.lab5_6.Gem.Hardness;

public class PreciousGemTest {

    @Test
    public void testToString()
    {
        PreciousGem gem = new PreciousGem(SortOfPreciousGem.Diamond, 18.4,
                1.25, Hardness.SEMI_HARD, 25000);

        String expected = "\nPreciousGem {sort=Diamond,\tweight=1.25 carats" +
                        ",\thardness=SEMI_HARD,\tprice=25000 usd" +
                        ",\tpurity=18.4}";
        Assertions.assertEquals(expected, gem.toString());
    }
}

