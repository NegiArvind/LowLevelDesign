import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisjointSet(int n) {
        for(int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    int findParent(int x) {
        if(parent.get(x) == x) {
            return x;
        }
        int ultimateParent = findParent(parent.get(x));
        parent.set(x, ultimateParent);
        return parent.get(x);
    }

    void unionBySize(int u, int v) {
        int ultimateParentU = findParent(u);
        int ultimateParentV = findParent(v);

        if(ultimateParentU == ultimateParentV) {
            return;
        }
        if(size.get(ultimateParentU) < size.get(ultimateParentV)) {
            parent.set(ultimateParentU, ultimateParentV);
            size.set(ultimateParentV, size.get(ultimateParentV) + size.get(ultimateParentU));
        } else {
            parent.set(ultimateParentV, ultimateParentU);
            size.set(ultimateParentU, size.get(ultimateParentU) + size.get(ultimateParentV));
        }
    }
}
