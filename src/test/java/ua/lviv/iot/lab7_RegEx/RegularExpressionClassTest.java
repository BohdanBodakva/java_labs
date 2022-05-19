package ua.lviv.iot.lab7_RegEx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class RegularExpressionClassTest {
    public static final String text = "The first shuttle mission's name was /shuttle/missions/MoonMission_1" +
            "The second shuttle mission's name was /shuttle/missions/NoNameMission_102" +
            "The third shuttle mission's name was /shuttle/missions/MarsMission_152" +
            "The fourth shuttle mission's name was /shuttle/missions/StrangeMission_1" +
            "The fifth shuttle mission's name was /shuttle/missions/MoonMission_14" +
            "The sixth shuttle mission's name was /shuttle/missions/VenusMission_178" +
            "The seventh shuttle mission's name was /shuttle/missions/JupiterMission_something" +
            "The eighth and the last shuttle mission's name was /shuttle/missions/SaturnMission_8";

    public static final String regEx = "/shuttle/missions/(\\w+)_(\\d+)";

    public static final List<String> expectedList = Arrays.asList("NoNameMission", "MarsMission",
             "MoonMission", "VenusMission", "SaturnMission");

    @Test
    public void testCheckRegEx(){
        RegularExpressionClass regularExpressionClass = new RegularExpressionClass(text, regEx);

        List<String> actualList = regularExpressionClass.checkRegEx();

        Assertions.assertEquals(expectedList, actualList);
    }
}
