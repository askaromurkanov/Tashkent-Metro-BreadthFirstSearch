package kg.askaromurkanov;

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
