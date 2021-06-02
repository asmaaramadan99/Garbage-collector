import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {
        FileManager f=FileManager.getInstance();
        HashMap<String,INode> n=f.getHeapObjects();
        f.readPointers();
        MarkAndCompactGC g=new MarkAndCompactGC();
      ArrayList<INode> roots= f.readRoots();
      for (INode node: roots)
      {
           g.dfs(node);
      }

      System.out.println(n.get("555555").isMarked());
        System.out.println(n.get("444444").isMarked());

    }
}
