package kg.askaromurkanov;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader("Lines");
        Graph graph = fileReader.readFiles();
        PathFinderBFS pathFinderBFS = new PathFinderBFS(graph);

        pathFinderBFS.searchPath(Input.getStartStation(), Input.getFinishStation());
    }
}
