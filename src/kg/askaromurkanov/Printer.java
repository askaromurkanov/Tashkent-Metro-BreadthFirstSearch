package kg.askaromurkanov;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Printer {

    public static void printAusgabeMark() {
        System.out.println("\nAusgabe: \n");
    }

    public static void printStationLine(String station, String line){
        System.out.println(station + " (" + line+")");
    }

    public static void printStationChangedLine(String station, String line){
        System.out.println(station + " (Changed to " + line+")");
    }
}
