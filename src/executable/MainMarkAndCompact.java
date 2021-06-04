package executable;

import interfaces.GarbageCollector;
import interfaces.INode;
import modules.MarkAndCompactGC;
import utils.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class MainMarkAndCompact {
    public static void main(String[]Args) throws IOException {
        FileManager f=FileManager.getInstance();
        ArrayList <INode>a=new ArrayList<>();
         a=f.getHeapObjects("/home/asmaa/Lab2/src/testFiles/heap.csv");
        f.readPointers("/home/asmaa/Lab2/src/testFiles/pointers.csv");
        ArrayList<INode> roots= f.readRoots("/home/asmaa/Lab2/src/testFiles/roots.txt");
        //modules.MarkAndCompactGC g=new modules.MarkAndCompactGC();
        GarbageCollector g=new MarkAndCompactGC(f.getHeap(),roots);
        ArrayList<INode> l= g.garbageCollect();
        for(INode node : l)
        {
            System.out.println(node.getID()+ ","+ node.getHeapStartIndex()+ ","+ node.getHeapEndIndex());
        }

    }
}
