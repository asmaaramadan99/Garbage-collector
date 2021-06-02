import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {
        FileManager f=FileManager.getInstance();
        HashMap<String,INode> n=f.getHeapObjects();
        f.readPointers();
        //MarkAndCompactGC g=new MarkAndCompactGC();
        CopyGC c= new CopyGC();
      ArrayList<INode> roots= f.readRoots();
      c.setRoots(roots);
      c.copy();
      for (INode node: c.getCopied())
      {
          System.out.println(node.getID());
           //g.dfs(node);
      }

      //System.out.println(n.get("555555").isMarked());
      //System.out.println(n.get("444444").isMarked());

    }
}
