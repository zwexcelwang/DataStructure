package graph;

public class Edgem implements Edge{
    private int vert1;
    private int vert2;
    public Edgem(int v1, int v2) {
        vert1 = v1;
        vert2 = v2;
    }
    @Override
    public int v1() {
        return vert1;
    }

    @Override
    public int v2() {
        return vert2;
    }
}
