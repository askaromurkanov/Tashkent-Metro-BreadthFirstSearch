package kg.askaromurkanov;

import java.util.*;

public class Graph {
    private List<String> stationNames;
    private Map<String, Set<String>> lines;
    private Map<String, Integer> stationNumbers;
    private List<Edge> adjacencyList;



    public Graph(){
        stationNames = new ArrayList<>(500);
        lines = new HashMap<>(500);
        stationNumbers = new HashMap<>();
        adjacencyList = new ArrayList<>(500);
        for (int i = 0; i<500; i++){
            adjacencyList.add(new Edge());
        }
    }

    public int addStation(int index, String station){
        if (index == 0){
            stationNames.add(null);
        }

        stationNumbers.put(station, index);
        stationNames.add(index++, station);


        return index;
    }

    public void addLine(String line,String station){
        lines.get(line).add(station);
    }

    public void createLine(String line, String station){
        Set<String> lineStations = new HashSet<>();
        lineStations.add(station);
        lines.put(line, lineStations);
    }

    public boolean containsLine(String line){
        return lines.containsKey(line);
    }

    public boolean containsStation(String station){
        return stationNumbers.containsKey(station);
    }

    public void addEdge(int index, String previous, String present){
        if (index == 0){
            adjacencyList.add(null);
        }
        adjacencyList.get(stationNumbers.get(previous)).getEdges().add(stationNumbers.get(present));
        adjacencyList.get(stationNumbers.get(present)).getEdges().add(stationNumbers.get(previous));
    }


    public boolean isLinesEqual(String line, int index, List<Integer> results){
        return lines.get(line).contains(stationNames.get(results.get(index))) == lines.get(line).contains(stationNames.get(results.get(index+1)));
    }

    public boolean isLineChanged(String line, int index, List<Integer> results){
        return lines.get(line).contains(stationNames.get(results.get(index+1))) && lines.get(line).contains(stationNames.get(results.get(index)));
    }

    public List<String> getStationNames() {
        return stationNames;
    }

    public Map<String, Set<String>> getLines() {
        return lines;
    }

    public Map<String, Integer> getStationNumbers() {
        return stationNumbers;
    }

    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    }
}
