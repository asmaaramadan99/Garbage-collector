import java.util.ArrayList;

public class CopyGC implements GarbageCollector{

    private ArrayList<INode> roots = new ArrayList<>();
    private ArrayList<INode> copied = new ArrayList<>();


    public ArrayList<INode> getRoots() {
        return roots;
    }

    public void setRoots(ArrayList<INode> roots) {
        this.roots = roots;
    }

    @Override
    public void garbageCollect() {

    }
    public void copy(){
        for (int i=0;i<roots.size();i++){
            copied.add(roots.get(i));
        }
        int i=0;
        while (i < copied.size()){
            for (int j=0;j< copied.get(i).getChildren().size();j++){
                INode n=copied.get(i).getChildren().get(j);
                if (! copied.contains(n))
                    copied.add(n);
            }
            i++;
        }
    }
}
