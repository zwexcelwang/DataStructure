package graph;

import list.Link;

public class Edgel implements Edge{
    private int vert1;
    private int vert2;
    private Link itself;
    public Edgel(int v1, int v2, Link it) {
        vert1 = v1;
        vert2 = v2;
        itself = it;
    }
    @Override
    public int v1() {
        return vert1;
    }

    @Override
    public int v2() {
        return vert2;
    }

    Link theLink() {
        return itself;
    }
}
