package ua.lviv.iot.lab7_RegEx;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpressionClass {
    public static String text;
    public static String regEx;

    public RegularExpressionClass(String text, String regEx){
        this.text = text;
        this.regEx = regEx;
    }

    public List<String> checkRegEx() {
        List<String> allMissionNumbers = new ArrayList<>();
        List<String> allMissionNames = new ArrayList<>();
        List<String> uniqueMissionNames = new ArrayList<>();

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            allMissionNames.add(matcher.group(1));
            allMissionNumbers.add(matcher.group(2));
        }

        for(int i = 0; i < allMissionNumbers.size(); i++){
            int counter = 0;

            for(int j = 0; j < allMissionNumbers.size(); j++){
                if(allMissionNumbers.get(i).equals(allMissionNumbers.get(j))){
                    counter++;
                }
            }

            if(counter == 1){
                uniqueMissionNames.add(allMissionNames.get(i));
            }
        }


        System.out.println(uniqueMissionNames);
        return uniqueMissionNames;
    }
}
