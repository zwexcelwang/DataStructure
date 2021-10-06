package graph;

public class Graphm implements Graph{
    private int[][] matrix;
    private int numEdge;
    public int[] Mark;

    public Graphm(int n) {
        Mark = new int[n];
        matrix= new int[n][n];
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
        for (int i=0; i< Mark.length; i++) {
            if(matrix[v][i] != 0) {
                return new Edgem(v, i);
            }
        }
        return null;
    }

    @Override
    public Edge next(Edge w) {
        if(w == null) {
            return null;
        }else {
            for (int i=w.v2()+1; i<Mark.length; i++) {
                if(matrix[w.v1()][i] != 0) {
                    return new Edgem(w.v1(), i);
                }
            }
            return null;
        }
    }

    @Override
    public boolean isEdge(Edge w) {
        if(w == null) {
            return false;
        }else {
            return matrix[w.v1()][w.v2()] != 0;
        }
    }

    @Override
    public boolean isEdge(int i, int j) {
        return matrix[i][j] != 0;
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
        if(weight == 0) {
            System.out.println("cannot set weight to 0");
        }else {
            matrix[i][j] = weight;
            numEdge++;
        }
    }

    @Override
    public void setEdge(Edge w, int weight) {
        if(w != null) {
            setEdge(w.v1(), w.v2(), weight);
        }
    }

    @Override
    public void delEdge(Edge w) {
        if(w != null) {
            if(matrix[w.v1()][w.v2()] != 0) {
                matrix[w.v1()][w.v2()] = 0;
                numEdge--;
            }
        }
    }

    @Override
    public void delEdge(int i, int j) {
        if(matrix[i][j] != 0) {
            matrix[i][j] = 0;
            numEdge--;
        }
    }

    @Override
    public int weight(Edge w) {
        if (w == null) {
            System.out.println("Can not take weight of null edge");
            return Integer.MAX_VALUE;
        } else {
            if (matrix[w.v1()][w.v2()] == 0) {
                return Integer.MAX_VALUE;
            } else {
                return matrix[w.v1()][w.v2()];
            }
        }
    }

    @Override
    public int weight(int i, int j) {
        if(matrix[i][j] == 0) {
            return Integer.MAX_VALUE;
        }else {
            return matrix[i][j];
        }
    }

    @Override
    public void setMark(int v, int val) {
        Mark[v] = val;
    }

    @Override
    public int getMark(int v) {
        return Mark[v];
    }
}
