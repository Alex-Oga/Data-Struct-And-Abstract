public class BFS {

    static void findShortest(UndirectedGraph<Integer> G, Integer a, Integer b) {

    }

    public static void main(String[] args) {

    }
}
class UndirectedAdjMap<Vertex> implements UndirectedGraph<Vertex>{

    @Override
    public int numEdges() {
        return 0;
    }

    @Override
    public int numVertices() {
        return 0;
    }

    @Override
    public int deg(Vertex v) {
        return 0;
    }

    @Override
    public Iterable<Vertex> adj(Vertex v) {
        return null;
    }

    @Override
    public boolean isEdge(Vertex u, Vertex v) {
        return false;
    }

    @Override
    public void addVertex(Vertex v) {

    }

    @Override
    public void addEdge(Vertex u, Vertex v) {

    }

    @Override
    public void removeEdge(Vertex u, Vertex v) {

    }
}