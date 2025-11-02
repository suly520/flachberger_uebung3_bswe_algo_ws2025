package at.hochschule.burgenland.bswe.algo;

import at.hochschule.burgenland.bswe.algo.utils.TreeWorker;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hauptklasse für die Benutzerinteraktion über die Konsole.
 */
public class Driver {
    
    /**
     * Startet die Konsolenanwendung für AVL-Baum Traversierung.
     * Liest Zahlen und Traversierungsart vom Benutzer ein.
     */
    public static void run() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter numbers separated by comma:");
            String input = scanner.nextLine();

            if (input == null || input.trim().isEmpty()) {
                System.out.println("Error: No input provided");
                return;
            }

            int[] numbers = parseNumbers(input);
            System.out.println("Numbers: " + Arrays.toString(numbers));

            System.out.println("\nEnter traversal order (inorder, preorder, postorder, levelorder):");
            String order = scanner.nextLine().toLowerCase().trim();

            int[] result = TreeWorker.buildTreeAndTraverse(numbers, order);

            System.out.println("\nTraversal result (" + order + "): " + Arrays.toString(result));
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static int[] parseNumbers(String input) {
        String[] parts = input.split(",");
        int[] numbers = new int[parts.length];
        
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i].trim());
        }
        
        return numbers;
    }
}
