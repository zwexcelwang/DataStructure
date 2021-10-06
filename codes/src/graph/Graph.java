package graph;

public interface Graph {
    public int n();
    public int e();
    public Edge first(int v);
    public Edge next(Edge w);
    public boolean isEdge(Edge w);
    public boolean isEdge(int i, int j);
    public int v1(Edge w);
    public int v2(Edge w);
    public void setEdge(int i, int j, int weight);
    public void setEdge(Edge w, int weight);
    public void delEdge(int i, int j);
    public void delEdge(Edge w);
    public int weight(Edge w);
    public int weight(int i, int j);
    public void setMark(int v, int val);
    public int getMark(int v);



}
