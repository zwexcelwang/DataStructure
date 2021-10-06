package graph;

import list.Link;
import list.LinkList;

public class GraphList extends LinkList {
    public Link currLink() {
        return curr;
    }

    public void setCurr(Link who) {
        curr = who;
    }
}
