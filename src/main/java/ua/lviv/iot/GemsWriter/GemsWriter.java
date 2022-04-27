package ua.lviv.iot.GemsWriter;


import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import ua.lviv.iot.Gem.Gem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GemsWriter {

    public static void writeToFile(List<Gem> gemList, String fileName) throws IOException {
        String sep = File.separator;
        try (FileWriter fileWriter = new FileWriter("src"+sep+"test"+sep+"resources"+sep+fileName)){

            Collections.sort(gemList, Comparator.comparing(o -> o.getClass().getSimpleName()));

            String previousClassName = "";

            for(Gem gem : gemList){
                if(!gem.getClass().getSimpleName().equals(previousClassName)){
                    fileWriter.write(gem.getClass().getSimpleName()+"s:");
                    fileWriter.write("\n");
                    fileWriter.write(gem.getHeaders());
                    fileWriter.write("\n");
                    previousClassName = gem.getClass().getSimpleName();
                }

                fileWriter.write(gem.toCSV());
                fileWriter.write("\n");
            }
        }
    }
}
