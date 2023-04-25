package kg.askaromurkanov;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private final File[] files;
    private final Graph graph;

    public FileReader(String directoryName) {
        this.graph = new Graph();
        File directory = new File(directoryName);
        this.files = directory.listFiles();
    }

    public Graph readFiles(){
        int num = 0;
        for (File file : this.files){
            String fileName = file.getName().replace(".txt","");
            if (file.isFile() && file.getName().endsWith(".txt")) {
                List<String> lines = readFile(file);
                num = processFileData(lines, fileName, num);
            }
        }

        return graph;
    }


    private List<String> readFile(File file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private int processFileData(List<String> stations, String lineName, int num) {
        String previous = "";
        for (String station : stations) {
            if (!graph.containsStation(station)) {
                num = graph.addStation(num, station);
            }

            if (graph.containsLine(lineName)){
                graph.addLine(lineName,station);
            } else{
                graph.createLine(lineName,station);
            }

            if (previous.isEmpty()) {
                previous = station;
                continue;
            }
            addEdgeToGraph(num, previous, station);
            previous = station;
        }
        return num;
    }

    private void addEdgeToGraph(int index, String station1, String station2) {
        graph.addEdge(index, station1, station2);
    }
}
