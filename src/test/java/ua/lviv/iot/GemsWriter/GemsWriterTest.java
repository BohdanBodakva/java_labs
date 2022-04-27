package ua.lviv.iot.GemsWriter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.Gem.Gem;
import ua.lviv.iot.Gem.Hardness;
import ua.lviv.iot.PreciousGem.PreciousGem;
import ua.lviv.iot.PreciousGem.SortOfPreciousGem;
import ua.lviv.iot.SemiPreciousGem.MineralityOfSemiPreciousGem;
import ua.lviv.iot.SemiPreciousGem.SemiPreciousGem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class GemsWriterTest {

    //system separator
    public static final String sep = File.separator;

    public static List<Gem> emptyGemList;
    public static List<Gem> gemList1;
    public static List<Gem> gemList2;
    public static List<Gem> gemList3;

    @BeforeAll
    public static void createGemList(){
        Gem gem1 = new PreciousGem(SortOfPreciousGem.Diamond, 10.9,
                9.6, Hardness.HARD, 20000);
        Gem gem2 = new PreciousGem(SortOfPreciousGem.Sapphire, 8.4,
                3.9, Hardness.SEMI_HARD, 15000);
        Gem gem3 = new SemiPreciousGem("Quartz", MineralityOfSemiPreciousGem.MINERAL,
                6.0, 0.4, Hardness.HARD, 7500);
        Gem gem4 = new SemiPreciousGem("Aquamarine", MineralityOfSemiPreciousGem.NON_MINERAL,
                1.4, 2.5, Hardness.SOFT, 2500);
        Gem gem5 = new SemiPreciousGem("Moonstone", MineralityOfSemiPreciousGem.MINERAL,
                0.25, 4.0, Hardness.SOFT, 14500);
        Gem gem6 = new PreciousGem(SortOfPreciousGem.Emerald, 5.55,
                4.4, Hardness.HARD, 27250);
        Gem gem7 = new SemiPreciousGem("Amazonite", MineralityOfSemiPreciousGem.NON_MINERAL,
                7.48, 2.51, Hardness.SEMI_HARD, 11490);
        Gem gem8 = new PreciousGem(SortOfPreciousGem.Ruby, 9.8,
                9.0, Hardness.SOFT, 12450);


        emptyGemList = Arrays.asList();
        gemList1 = Arrays.asList(gem1, gem2, gem3, gem4, gem5, gem6, gem7, gem8);
        gemList2 = Arrays.asList(gem1, gem2, gem6, gem8);
        gemList3 = Arrays.asList(gem3, gem4, gem5, gem7);
    }

    @Test
    public void testWriteEmptyFile() throws IOException {
        GemsWriter.writeToFile(emptyGemList, "actualEmptyFile.csv");

        List<String> expectedFile = Files.readAllLines(Path.of("expectedEmptyFile.csv"));
        List<String> actualFile = Files.readAllLines(Path.of("src"+sep+"test"+sep+"resources"
                +sep+"actualEmptyFile.csv"));



        Assertions.assertEquals(expectedFile, actualFile);
    }

    @Test
    public void testWriteAllGemsToFile() throws IOException {
        GemsWriter.writeToFile(gemList1, "actualListFile1.csv");

        List<String> expectedFile = Files.readAllLines(Path.of("expectedListFile1.csv"));
        List<String> actualFile = Files.readAllLines(Path.of("src"+sep+"test"+sep+"resources"
                +sep+"actualListFile1.csv"));

        System.out.println(expectedFile);

        Assertions.assertEquals(expectedFile, actualFile);
    }

    @Test
    public void testWritePreciousGemsToFile() throws IOException {
        GemsWriter.writeToFile(gemList2, "actualListFile2.csv");

        List<String> expectedFile = Files.readAllLines(Path.of("expectedListFile2.csv"));
        List<String> actualFile = Files.readAllLines(Path.of("src"+sep+"test"+sep+"resources"
                +sep+"actualListFile2.csv"));

        Assertions.assertEquals(expectedFile, actualFile);
    }

    @Test
    public void testWriteSemiPreciousGemsToFile() throws IOException {
        GemsWriter.writeToFile(gemList3, "actualListFile3.csv");

        List<String> expectedFile = Files.readAllLines(Path.of("expectedListFile3.csv"));
        List<String> actualFile = Files.readAllLines(Path.of("src"+sep+"test"+sep+"resources"
                +sep+"actualListFile3.csv"));

        Assertions.assertEquals(expectedFile, actualFile);
    }
}

