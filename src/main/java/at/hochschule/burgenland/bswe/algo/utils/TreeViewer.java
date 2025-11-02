package at.hochschule.burgenland.bswe.algo.utils;

import at.hochschule.burgenland.bswe.algo.data.Node;

/**
 * Hilfsklasse zur Darstellung von Bäumen in horizontaler Form.
 */
public class TreeViewer {

    /**
     * Zeigt den Baum in horizontaler Darstellung.
     * @param root Wurzelknoten des Baums
     */
    public static void showTree(Node root) {
        if (root == null) return;

        StringBuilder stringBuilder = new StringBuilder();

        showTreeHelper(root, 0, stringBuilder);

        System.out.println(stringBuilder);

    }

    private static void showTreeHelper(Node node, int level, StringBuilder stringBuilder) {
        if (node == null) return;

        showTreeHelper(node.getRight(), level + 1, stringBuilder);

        if(node.getRight() != null) {
            stringBuilder.append("   ".repeat(Math.max(0, level)));
            stringBuilder.append(" /\n");
        }

        stringBuilder.append("   ".repeat(Math.max(0, level)));

        stringBuilder.append(node.getKey());
        if(level == 0) stringBuilder.append(" <- root");
        stringBuilder.append("\n");

        if(node.getLeft() != null) {
            stringBuilder.append("   ".repeat(Math.max(0, level)));
            stringBuilder.append(" \\\n");
        }

        showTreeHelper(node.getLeft(), level + 1, stringBuilder);

    }
}
