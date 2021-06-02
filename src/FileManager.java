import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileManager {
    private static FileManager fileManager;
    HashMap<String, INode> nodes = new HashMap<>();

    private FileManager() {
    }

    public static FileManager getInstance() {
        if (fileManager == null)
            return new FileManager();
        return fileManager;
    }

    public ArrayList<INode> readRoots() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("src/roots.txt"));
        String row;
        ArrayList<INode> roots = new ArrayList<>();
        while ((row = csvReader.readLine()) != null) {
            INode root = nodes.get(row);
            roots.add(root);

        }
        csvReader.close();

        return roots;
    }

    public void readPointers() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("src/pointers.csv"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            data[0] = data[0].replaceAll("[^0-9]+", "");
            INode nodeA = nodes.get(data[0]);
            INode nodeB = nodes.get(data[1]);
            nodeA.addChild(nodeB);
        }
        csvReader.close();

    }

    public HashMap<String, INode> getHeapObjects() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("src/heap.csv"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            data[0] = data[0].replaceAll("[^0-9]+", "");
            String id = data[0];
            int start = Integer.parseInt(data[1]);
            int end = Integer.parseInt(data[2]);
            INode node = new Node(id, start, end);
            nodes.put(id, node);
        }
        csvReader.close();
        return nodes;
    }

}
