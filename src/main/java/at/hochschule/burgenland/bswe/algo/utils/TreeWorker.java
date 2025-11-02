package at.hochschule.burgenland.bswe.algo.utils;

import at.hochschule.burgenland.bswe.algo.data.Node;
import at.hochschule.burgenland.bswe.algo.data.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Hilfsklasse für Baum-Traversierungen.
 */
public class TreeWorker {

    /**
     * Erstellt einen AVL-Baum aus den Zahlen und traversiert ihn.
     * @param numbers Array von Ganzzahlen
     * @param order Traversierungsart (inorder, preorder, postorder, levelorder)
     * @return Array mit traversierten Knoten
     */
    public static int[] buildTreeAndTraverse(int[] numbers, String order) {
        Tree tree = new Tree();
        tree.fill(numbers);
        Node root = tree.getRoot();

        List<Integer> result = new ArrayList<>();
        System.out.println("\nStart Traversing: ");
        switch (order) {
            case "inorder" -> inOrder(root, result);
            case "preorder" -> preOrder(root, result);
            case "postorder" -> postOrder(root, result);
            case "levelorder" -> levelOrder(root, result);
            default -> System.out.println("Traversal not known");
        }

        System.out.println("\nHorizontal Tree Graph: \n");
        TreeViewer.showTree(root);

        return convertToIntArray(result);
    }

    private static int[] convertToIntArray(List<Integer> result){
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    private static List<Integer> inOrder(Node rootNode, List<Integer> result) {
        if(rootNode == null) return result;

        inOrder(rootNode.getLeft(), result);
        result.add(rootNode.getKey());
        inOrder(rootNode.getRight(), result);

        return result;
    }

    private static List<Integer> preOrder(Node rootNode, List<Integer> result) {
        if(rootNode == null) return result;

        result.add(rootNode.getKey());
        preOrder(rootNode.getLeft(), result);
        preOrder(rootNode.getRight(), result);

        return result;
    }

    private static List<Integer> postOrder(Node rootNode, List<Integer> result) {
        if(rootNode == null) return result;

        postOrder(rootNode.getLeft(), result);
        postOrder(rootNode.getRight(), result);
        result.add(rootNode.getKey());

        return result;
    }

    private static List<Integer> levelOrder(Node rootNode, List<Integer> result) {
        if(rootNode == null) return result;
        List<Node> currentLevel = new ArrayList<>();
        currentLevel.add(rootNode);

        while (!currentLevel.isEmpty()) {
            List<Node> nextLevel = new ArrayList<>();

            for (Node node : currentLevel) {
                result.add(node.getKey());
                if(node.getLeft() != null)
                    nextLevel.add(node.getLeft());
                if(node.getRight() != null)
                    nextLevel.add(node.getRight());
            }

            currentLevel = nextLevel;
        }

        return result;
    }

}
