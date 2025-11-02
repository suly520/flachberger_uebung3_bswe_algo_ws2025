package at.hochschule.burgenland.bswe.algo.data;

import lombok.Getter;

/**
 * AVL-Baum Implementierung mit automatischer Balancierung.
 */
@Getter
public class Tree {
    private Node root;

    /**
     * Füllt den AVL-Baum mit den gegebenen Zahlen.
     * @param keys Array von Ganzzahlen zum Einfügen
     */
    public void fill(int[] keys) {
        for(int key : keys) {
            root = insert(root, key);
        }
    }
    
    /**
     * Berechnet die Höhe eines Knotens.
     * @param node Der Knoten
     * @return Höhe des Knotens
     */
    public static int height(Node node) {
        if( node == null) return 0;
        return node.getHeight();
    }

    /**
     * Berechnet den Balancefaktor eines Knotens.
     * @param node Der Knoten
     * @return Balancefaktor (Höhe links - Höhe rechts)
     */
    public static int getBalance(Node node) {
        if(node == null) return 0;
        return height(node.getLeft()) - height(node.getRight());
    }

    private static void calculateHeight(Node node) {
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
    }


    private Node leftRotate(Node node) {
        Node right = node.getRight();
        Node rLeft = right.getLeft();
        right.setLeft(node);
        node.setRight(rLeft);
        calculateHeight(node);
        calculateHeight(right);
        return right;
    }

    private Node rightRotate(Node node) {
        Node left = node.getLeft();
        Node lRight = left.getRight();
        left.setRight(node);
        node.setLeft(lRight);
        calculateHeight(node);
        calculateHeight(left);
        return left;
    }

    private Node insert(Node currentNode, int key) {
        if(currentNode == null) {
            System.out.println("Insert: " + key);
            return new Node(key);
        }

        int nodeKey = currentNode.getKey();

        if (key < nodeKey)
            currentNode.setLeft(insert(currentNode.getLeft(), key));
        else if(key > nodeKey)
            currentNode.setRight(insert(currentNode.getRight(), key));
        else
            return currentNode;

        calculateHeight(currentNode);
        int currentBalance = getBalance(currentNode);

        Node leftNode = currentNode.getLeft();
        Node rightNode = currentNode.getRight();

        if (currentBalance > 1) {
            int leftBalance = getBalance(leftNode);
            if(leftBalance < 0) {
                System.out.println("Node " + currentNode.getKey() + " (Balance: " + currentBalance + ", Left: " + leftBalance + ") -> Left-Right Rotation");
                currentNode.setLeft(leftRotate(leftNode));
            } else {
                System.out.println("Node " + currentNode.getKey() + " (Balance: " + currentBalance + ", Left: " + leftBalance + ") -> Right Rotation");
            }
            return rightRotate(currentNode);
        }

        if (currentBalance < -1) {
            int rightBalance = getBalance(rightNode);
            if(rightBalance > 0) {
                System.out.println("Node " + currentNode.getKey() + " (Balance: " + currentBalance + ", Right: " + rightBalance + ") -> Right-Left Rotation");
                currentNode.setRight(rightRotate(rightNode));
            } else {
                System.out.println("Node " + currentNode.getKey() + " (Balance: " + currentBalance + ", Right: " + rightBalance + ") -> Left Rotation");
            }
            return leftRotate(currentNode);
        }

        return currentNode;
    }


}
