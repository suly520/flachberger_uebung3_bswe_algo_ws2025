package at.hochschule.burgenland.bswe.algo.data;


import lombok.Getter;
import lombok.Setter;

/**
 * Knoten eines AVL-Baums mit Schlüssel, Kindern und Höhe.
 */
@Getter
public class Node {
    private final int key;
    @Setter
    private Node left;
    @Setter
    private Node right;
    @Setter
    private int height;

    Node(int key) {
        this.key = key;
        this.height = 1;
    }

    @Override
    public String toString() {
        String leftKey = null;
        String rightKey = null;
        if(left != null)
            leftKey = String.valueOf(left.key);
        if(right != null)
            rightKey = String.valueOf(right.key);

        return "{key: " + key + ", left: " + leftKey + ", right: " + rightKey + "}";
    }
}
