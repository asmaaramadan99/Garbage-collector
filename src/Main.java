import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {
        FileManager f=FileManager.getInstance();
        HashMap<String,INode> n=f.getHeapObjects();
        n.forEach((K,V) -> System.out.println(K + ", Stock : " + V));
        // n.get("111111").addChild(n.get("222222"));
        n.get("222222").addChild(n.get("333333"));
        n.get("222222").addChild(n.get("444444"));
        n.get("444444").addChild(n.get("555555"));
        MarkAndCompactGC g=new MarkAndCompactGC();
        g.dfs(n.get("222222"));
       System.out.println( n.get("555555").isMarked());
    }
}
