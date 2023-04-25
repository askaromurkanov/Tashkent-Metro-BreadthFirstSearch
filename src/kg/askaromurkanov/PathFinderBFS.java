package kg.askaromurkanov;

import java.util.*;

public class PathFinderBFS {
    boolean[] visited;
    int[] path;
    Graph graph;

    public PathFinderBFS(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getStationNames().size()];
        path = new int[graph.getStationNames().size()];
    }

    public void searchPath(String start, String finish){
        Map<String, Integer> stationNumbers = graph.getStationNumbers();
        List<Edge> edgeList = graph.getAdjacencyList();


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(stationNumbers.get(start));
        visited[stationNumbers.get(start)] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x==stationNumbers.get(finish)){
                break;
            }
            for (int to : edgeList.get(x).getEdges()) {
                if (!visited[to]) {
                    queue.offer(to);
                    visited[to] = true;
                    path[to] = x;
                }
            }
        }
        List<Integer> results = new ArrayList<>();
        int x = stationNumbers.get(finish);
        while (path[x] != 0) {
            results.add(x);
            x = path[x];
        }
        results.add(x);

        Collections.reverse(results);

        setResults(results);

    }

    public void setResults(List<Integer> results){
        Map<String, Set<String>> lines = graph.getLines();
        List<String> stations = graph.getStationNames();

        Printer.printAusgabeMark();

        String presentLine = null;
        for (String station : lines.keySet()){
            if (lines.get(station).contains(stations.get(results.get(0)))){
                presentLine = station;
                break;
            }
        }

        for (int i = 0; i<results.size(); i++){
            if (i+1 < results.size()){
                if (graph.isLinesEqual(presentLine,i,results)){
                    Printer.printStationLine(stations.get(results.get(i)), presentLine);
                }

                else{
                    for (String line : lines.keySet()){
                        if (graph.isLineChanged(line, i, results)){
                            Printer.printStationChangedLine(stations.get(results.get(i)), line);
                            presentLine = line;
                            break;
                        }
                    }
                }
            } else
                Printer.printStationLine(stations.get(results.get(i)), presentLine);
        }
    }
}
