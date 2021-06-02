public class MarkAndCompactGC implements GarbageCollector {
    @Override
    public void garbageCollect() {


    }

    public void dfs(INode current) {
        current.setMarked();
        if (current.getChildren().size() == 0) return;
        for (INode node : current.getChildren()) {
            dfs(node);
        }
    }

    private void reverse(INode current, INode prev) {
        if (prev.getChildren().size() != 0) {
            prev.getChildren().remove(current);
            current.getChildren().add(prev);
        }

    }
}
