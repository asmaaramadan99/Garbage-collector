package utils;

import interfaces.INode;
import modules.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileManager {
    private static FileManager fileManager;
    HashMap<String, INode> nodes = new HashMap<>();

    public ArrayList<INode> getHeap() {
        return heap;
    }

    private ArrayList<INode> heap=new ArrayList<>();

    private FileManager() {
    }

    public static FileManager getInstance() {
        if (fileManager == null)
            return new FileManager();
        return fileManager;
    }

    public ArrayList<INode> readRoots(String absolutePath) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(absolutePath));
        String row;
        ArrayList<INode> roots = new ArrayList<>();
        while ((row = csvReader.readLine()) != null) {
            INode root = nodes.get(row);
            roots.add(root);

        }
        csvReader.close();

        return roots;
    }

    public void readPointers(String absolutePath) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(absolutePath));
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

    public ArrayList<INode> getHeapObjects(String absolutePath) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(absolutePath));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            data[0] = data[0].replaceAll("[^0-9]+", "");
            String id = data[0];
            int start = Integer.parseInt(data[1]);
            int end = Integer.parseInt(data[2]);
            INode node = new Node(id, start, end);
            nodes.put(id, node);
            heap.add(node);
        }
        csvReader.close();
        return heap;
    }

}
