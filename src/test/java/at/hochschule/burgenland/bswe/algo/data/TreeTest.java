package at.hochschule.burgenland.bswe.algo.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {

    @Test
    public void testSingleNode() {
        Tree tree = new Tree();
        tree.fill(new int[]{5});
        
        Node root = tree.getRoot();
        assertEquals(5, root.getKey());
        assertNull(root.getLeft());
        assertNull(root.getRight());
        assertEquals(1, root.getHeight());
    }

    @Test
    public void testMultipleNodes() {
        Tree tree = new Tree();
        tree.fill(new int[]{10, 20, 30, 40, 50, 25});

        Node root = tree.getRoot();
        assertEquals(30, root.getKey());
        assertEquals(20, root.getLeft().getKey());
        assertEquals(40, root.getRight().getKey());
        assertEquals(10, root.getLeft().getLeft().getKey());
        assertEquals(25, root.getLeft().getRight().getKey());
        assertEquals(50, root.getRight().getRight().getKey());
    }

    @Test
    public void testLeftRotation() {
        Tree tree = new Tree();
        tree.fill(new int[]{1, 2, 3});
        
        Node root = tree.getRoot();
        assertEquals(2, root.getKey());
        assertEquals(1, root.getLeft().getKey());
        assertEquals(3, root.getRight().getKey());
    }

    @Test
    public void testRightRotation() {
        Tree tree = new Tree();
        tree.fill(new int[]{3, 2, 1});
        
        Node root = tree.getRoot();
        assertEquals(2, root.getKey());
        assertEquals(1, root.getLeft().getKey());
        assertEquals(3, root.getRight().getKey());
    }

    @Test
    public void testLeftRightRotation() {
        Tree tree = new Tree();
        tree.fill(new int[]{3, 1, 2});
        
        Node root = tree.getRoot();
        assertEquals(2, root.getKey());
        assertEquals(1, root.getLeft().getKey());
        assertEquals(3, root.getRight().getKey());
    }

    @Test
    public void testRightLeftRotation() {
        Tree tree = new Tree();
        tree.fill(new int[]{1, 3, 2});
        
        Node root = tree.getRoot();
        assertEquals(2, root.getKey());
        assertEquals(1, root.getLeft().getKey());
        assertEquals(3, root.getRight().getKey());
    }

    @Test
    public void testComplexTreeBalanced() {
        Tree tree = new Tree();
        tree.fill(new int[]{3, 4, 34, 2, 5, 6, 8, 10});
        
        Node root = tree.getRoot();
        assertEquals(4, root.getKey());
        assertEquals(-1, Tree.getBalance(root));
        assertEquals(1, Tree.getBalance(root.getLeft()));
        assertEquals(-1, Tree.getBalance(root.getRight()));
    }

    @Test
    public void testDuplicateValues() {
        Tree tree = new Tree();
        tree.fill(new int[]{5, 3, 7, 3, 7});
        
        Node root = tree.getRoot();
        assertEquals(5, root.getKey());
        assertEquals(3, root.getLeft().getKey());
        assertEquals(7, root.getRight().getKey());
        assertNull(root.getLeft().getLeft());
        assertNull(root.getLeft().getRight());
        assertNull(root.getRight().getLeft());
        assertNull(root.getRight().getRight());
    }


}
