# Komplexität

Hier wird die Zeit- und Speicherkomplexität der AVL-Baum-Operationen beschrieben.

## AVL-Baum erstellung

### AVL-Baum insert

Die insert-Methode fügt ein Element in den AVL-Baum ein. Dabei wird der Baum von der Wurzel bis zu einem Blatt durchlaufen, wobei der Suchraum ähnlich wie bei der Binärsuche jedes Mal halbiert wird. Durch die AVL-Balancierung bleibt die Baumhöhe immer bei O(log n). Andere Operationen wie Rotationen oder das Berechnen der Balance haben eine konstante Zeitkomplexität O(1). Dadurch ergibt sich für die insert-Methode eine Zeitkomplexität von O(log n).

### AVL-Baum fill

Die fill-Methode ruft für jedes der n Elemente die insert-Methode auf. Die Gesamtzeitkomplexität beträgt daher `O(n log n)`, da für jedes der n Elemente insert() mit O(log n) ausgeführt wird. Dies gilt in jedem Fall (Best, Average, Worst Case), da jedes Element eingefügt werden muss.

### AVL Komplexitäts Auflistung

* Average, Worst und Best Case Time Complexity:
  * `O(n log n)`


 n ... Anzahl der Elemente, die eingefügt werden

## Tree Worker

### Tree erstellen und traversieren

Bei der Traversierung wird, egal bei welcher der implementierten Traversierungsarten, jeder Knoten genau einmal besucht. Daher hat jede Traversierungsart eine Zeitkomplexität von O(n). Die anderen Operationen innerhalb der Traversierungsmethoden, wie z.B. das Hinzufügen eines Elements zu einer Liste, haben eine konstante Zeitkomplexität von O(1).Das visulisieren und das konvertieren des Baumes in ein int Array hat ebenfalls eine Zeitkomplexität von O(n). Ändert also nichts an der Gesamtzeitkomplexität.

### Traversierungs Komplexitäts Auflistung

* Average, Worst und Best Case Time Complexity:
  * `O(n)`

## Fazit

In Summe bleibt also die Gesamtzeitkomplexität für das erstellen und Traversieren des AVL-Baumes bei `O(n log n)`.
