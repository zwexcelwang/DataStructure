package graph;

import java.security.spec.ECGenParameterSpec;

public class Graphl implements Graph{
    private GraphList[] vertex;
    private int numEdge;
    public int[] Mark;

    public Graphl(int n) {
        Mark = new int[n];
        vertex= new GraphList[n];
        for(int i=0; i<n; i++) {
            vertex[i] = new GraphList();
        }
        numEdge = 0;
    }
    @Override
    public int n() {
        return Mark.length;
    }

    @Override
    public int e() {
        return numEdge;
    }

    @Override
    public Edge first(int v) {
       vertex[v].setFirst();
       if(vertex[v].currValue() == null) {
           return null;
       }else {
           return new Edgel(v, ((int[]) vertex[v].currValue())[0], vertex[v].currLink());
       }
    }

    @Override
    public Edge next(Edge w) {
        vertex[w.v1()].setCurr(((Edgel)w).theLink());
        vertex[w.v1()].next();
        if(vertex[w.v1()].currValue() == null) {
            return null;
        }else {
            return new Edgel(w.v1(), ((int[]) vertex[w.v1()].currValue())[0], vertex[w.v1()].currLink());
        }
    }

    @Override
    public boolean isEdge(Edge w) {
        if(w == null) {
            return false;
        }else {
            vertex[w.v1()].setCurr(((Edgel)w).theLink());
            if(!vertex[w.v1()].isInList()) {
                return false;
            }else {
                return ((int[]) vertex[w.v1()].currValue())[0] == w.v2();
            }
        }
    }

    @Override
    public boolean isEdge(int i, int j) {
        return false;
    }

    @Override
    public int v1(Edge w) {
        return w.v1();
    }

    @Override
    public int v2(Edge w) {
        return w.v2();
    }

    @Override
    public void setEdge(int i, int j, int weight) {

    }

    @Override
    public void setEdge(Edge w, int weight) {

    }

    @Override
    public void delEdge(int i, int j) {

    }

    @Override
    public void delEdge(Edge w) {

    }

    @Override
    public int weight(Edge w) {
        return 0;
    }

    @Override
    public int weight(int i, int j) {
        return 0;
    }

    @Override
    public void setMark(int v, int val) {

    }

    @Override
    public int getMark(int v) {
        return 0;
    }
}
