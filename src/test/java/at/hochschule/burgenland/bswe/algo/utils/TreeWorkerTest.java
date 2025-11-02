package at.hochschule.burgenland.bswe.algo.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TreeWorkerTest {
    int[] arr;

    @BeforeEach
    public void prepTest() {
        arr = new int[]{8, 4, 9, 7, 2, 13, 11, 46};
    }

    @Test
    public void testInOrder(){
        int[] result = new int[]{2, 4, 7, 8, 9, 11, 13, 46};

        assertArrayEquals(TreeWorker.buildTreeAndTraverse(arr, "inorder"), result);
    }

    @Test
    public void testPreOrder(){
        int[] result = new int[]{8, 4, 2, 7, 11, 9, 13, 46};

        assertArrayEquals(TreeWorker.buildTreeAndTraverse(arr, "preorder"), result);
    }


    @Test
    public void testPostOrder(){
        int[] result = new int[]{2, 7, 4, 9, 46, 13, 11, 8};

        assertArrayEquals(TreeWorker.buildTreeAndTraverse(arr, "postorder"), result);
    }

    @Test
    public void testLevelOrder(){
        int[] result = new int[]{8, 4, 11, 2, 7, 9, 13, 46};

        assertArrayEquals(TreeWorker.buildTreeAndTraverse(arr, "levelorder"), result);
    }

}
