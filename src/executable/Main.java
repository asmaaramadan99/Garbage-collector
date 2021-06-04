package executable;

import interfaces.INode;
import modules.CopyGC;
import utils.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException {
       FileManager f=FileManager.getInstance();
       ArrayList<INode> n=f.getHeapObjects("/home/asmaa/Lab2/src/testFiles/heap.csv");
        f.readPointers("/home/asmaa/Lab2/src/testFiles/pointers.csv");
        //modules.MarkAndCompactGC g=new modules.MarkAndCompactGC();
        CopyGC c= new CopyGC();
      ArrayList<INode> roots= f.readRoots("/home/asmaa/Lab2/src/testFiles/roots.txt");
      c.setRoots(roots);
      c.garbageCollect();
      for (INode node: c.getCopied())
      {
          System.out.println(node.getID());
          System.out.println(node.getHeapStartIndex());
          System.out.println(node.getHeapEndIndex());
           //g.dfs(node);
      }

      //System.out.println(n.get("555555").isMarked());
      //System.out.println(n.get("444444").isMarked());

    }
}
