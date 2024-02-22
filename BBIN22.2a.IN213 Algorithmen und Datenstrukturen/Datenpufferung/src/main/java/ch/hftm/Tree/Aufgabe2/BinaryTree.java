package ch.hftm.Tree.Aufgabe2;
import java.util.NoSuchElementException;

/**
 * BinaryTree Die generische Klasse "BinaryTree" ist eine Containerklasse zur
 * Einlagerung von Objekten eines bestimmten Typs, welche auf der Grundlage
 * eines binären Suchbaumes konzipiert ist und die gängigsten Operationen über
 * Suchbäumen bereitstellt.
 */
public class BinaryTree<E extends Comparable<E>> {

	// Konstanten

	// Steuerung der Traversierung
	public static final int INORDER = 1;
	public static final int PREORDER = 2;
	public static final int POSTORDER = 3;

	// Instanzvariablen

	private TreeNode<E> root; // Baumwurzel

	// Konstruktor

	/**
	 * Initialisiert den binären Suchbaum als leeren Baum.
	 */
	public BinaryTree() {
		root = null;
	}

	// Instanzmethoden

	/**
	 * Erzeugt aus den in einem Array angeordneten Elementen binären Suchbaum.
	 * Dabei werden die Arrayelemente in aufsteigender Indexreihenfolge im
	 * Suchbaum eingelagert. Wird der null-Array übergeben, dann wird der
	 * Standard- suchbaum generiert.
	 */
	public void array2BTree(E[] dataArr) {
		root = null; // allfällig bestehenden Baum löschen
		if (dataArr != null) {
			for (int i = 0; i < dataArr.length; i++)
				try {
					insert(dataArr[i]);
				} catch (IllegalArgumentException e) {
					// Duplikat darf nicht eingefügt werden --> ignorieren
				}
		}
	}

	/**
	 * Durchläuft den Suchbaum auf der Grundlage der spezifizierten
	 * Traversierungsstrategie und erzeugt eine Stringrepäsentation der
	 * angetroffenen Nutzdatenelemente.
	 */
	public String traverse(int strategy) {
		switch (strategy) {
		case INORDER:
			return toStringInorder(root);
		case PREORDER:
			return toStringPreorder(root);
		case POSTORDER:
			return toStringPostorder(root);
		default:
			return toStringInorder(root);
		}
	}

	/**
	 * Traversiert den Suchbaum inorder und erzeugt eine Stringrepäsentation der
	 * angetroffenen Nutzdatenelemente.
	 */
	private String toStringInorder(TreeNode<E> node) {
		String treeStrg = "";

		// .......

		return treeStrg;
	}

	/**
	 * Traversiert den Suchbaum preorder und erzeugt eine Stringrepäsentation
	 * der angetroffenen Nutzdatenelemente.
	 */
	private String toStringPreorder(TreeNode<E> node) {
		String treeStrg = "";

		// .......

		return treeStrg;
	}

	/**
	 * Traversiert den Suchbaum postorder und erzeugt eine Stringrepäsentation
	 * der angetroffenen Nutzdatenelemente.
	 */
	private String toStringPostorder(TreeNode<E> node) {
		String treeStrg = "";

		// .......

		return treeStrg;
	}

	/**
	 * Prüft, ob das spezifizierte Datenelement im Suchbaum eingelagert ist
	 * (=true) oder nicht (=false). (Iterative Version)
	 */
	public boolean contains(E data) {
		boolean found = false;

		// .......

		return found;
	}

	/**
	 * Ermittelt das im binären Suchbaum eingelagerte Datenelement mit dem
	 * grössten Wert.
	 */
	public E maxElement() {

		// .......

		return null;
	}

	/**
	 * Ermittelt das im binären Suchbaum eingelagerte Datenelement mit dem
	 * grössten Wert.
	 */
	public E minElement() {

		// .......

		return null;
	}

	/**
	 * Fügt ein Datenelement an der korrekten Position im binären Suchbaum ein.
	 */

	public void insert(E data) {
		TreeNode<E> parent = null; // Initialisiert partent als null.
		TreeNode<E> node = root; // Erzeugt die Wurzel des Baumes.
		int compareResult; // Variabel zum Speichern des Vergleichergebnis.

		// Durchlaufe den Baum bis zu einem Blattknoten, um die korrekte Position für das neue Element zu finden.
		while (node != null) {
			parent = node; // Setze den Elternknoten auf den aktuellen Knoten.
			compareResult = data.compareTo(node.data);  // Vergleiche das einzufügende Element mit dem aktuellen Knoten.

			if (compareResult < 0) { // Wenn einzufügende Element kleiner ist, gehe nach links.
				node = node.left;
			} else if (compareResult > 0) { // Wenn einzufügende Element größer ist, gehe nach rechts.
				node = node.right;
			} else { // Wenn das Element bereits im Baum ist, werfe eine Exception.
				throw new IllegalArgumentException("Datenelement bereits im Baum eingefügt!");
			}
		}

		// Nachdem die korrekte Position gefunden wurde, füge das neue Element ein.
		if (parent == null) { // Wenn der Baum leer ist, setze das neue Element als Wurzel des Baumes.
			root = new TreeNode<E>((E) data);
		} else if (data.compareTo(parent.data) < 0) { // Wenn das neue Element kleiner als der Elternknoten ist, füge es links ein.
			parent.left = new TreeNode<E>((E) data);
		} else { // Wenn das neue Element größer oder gleich dem Elternknoten ist, füge es rechts ein.
		}
	}

	/**
	 * Entfernt das spezifizierte Datenelement unter Wahrung der Ordnung aus dem
	 * binären Suchbaum, sofern es vorhanden ist.
	 */
	public void remove(E data) {
		TreeNode<E> parent = null;	// Dient zur Speicherung des Elternknotens des zu entfernenden Knotens.
		TreeNode<E> node = root;	// Wurzel des Baumes.
		TreeNode<E> child = null;	// Hilfsvariable für den Fall, dass der zu löschende Knoten zwei Kinder hat.
		TreeNode<E> temp = null;	// Temporäre Variable für die Umstrukturierung des Baumes.

		// Schritt 1: Suche den zu löschenden Knoten und seinen Elternknoten.
		while (node != null && data.compareTo(node.data) != 0) {
			parent = node;	// Aktualisiere den Elternknoten auf den aktuellen Knoten.
			if (data.compareTo(node.data) < 0) {	// Gehe nach links, wenn das Datenobjekt kleiner ist.
				node = node.left;
			} else {	// Gehe nach rechts, wenn das Datenobjekt größer ist.
				node = node.right;
				}
		}

		// Wenn der Knoten nicht gefunden wurde, werfe eine Exception.
		if (node == null) {
			// Behandlung des Falls, wenn der zu entfernende Knoten die Wurzel ist.
			throw new NoSuchElementException("Das zu entfernende Nutzdatum ist nicht im " + "Baum eingelagert!");
		}

		// Schritt 2: Entferne den Knoten aus dem Baum.
		if (parent == null) {	// Der zu entfernende Knoten ist die Wurzel.
			if (node.left == null) {	// Nur ein rechtes Kind vorhanden.
				root = node.right;	// Das rechte Kind wird zur Wurzel.
			} else if (node.right == null) {	// Nur ein linkes Kind vorhanden.
				root = node.left;	// Das linke Kind wird zur Wurzel.
			} else {	// Die Wurzel hat zwei Kinder. Suche den in-order Nachfolger.
				temp = node;
				child = node.right;
				while (child.left != null) {	// Finde den am weitesten links liegenden Knoten im rechten Unterbaum.
					temp = child;
					child = child.left;
				}
				// Umstrukturieren, um den in-order Nachfolger an die Stelle der ursprünglichen Wurzel zu setzen.
				if (node != temp) {
					temp.left = child.right;
					child.right = root.right;
				}
				child.left = root.left;
				root = child;	// Setze den in-order Nachfolger als neue Wurzel.
			}
		} else	// Der zu entfernende Knoten ist nicht die Wurzel.
		if (node.left == null) {
			if (parent.left == node) {
				parent.left = node.right;
			} else {
				parent.right = node.right;
			}
		} else if (node.right == null) {
			if (parent.left == node) {
				parent.left = node.left;
			} else {
				parent.right = node.left;
			}
		} else {	// Der Knoten hat zwei Kinder. Suche den in-order Nachfolger.
			temp = node;
			child = node.right;
			while (child.left != null) {
				temp = child;
				child = child.left;	// Gehe zum linksten Knoten
			}
			child.left = node.left;
			if (node != temp) {	// Umstrukturieren, um den in-order Nachfolger an die Stelle des zu löschenden Knotens zu setzen.
				temp.left = child.right;
				child.right = node.right;
			}
			if (parent.right == node) { // Ersetze den zu entfernenden Knoten durch den in-order Nachfolger.
				parent.right = child;
			} else {
				parent.left = child;
			}
		}
	}

	/**
	 * Erzeugt eine Stringrepräsentation des binären Suchbaumes.
	 */
	public String toString() {
		int niveau = 0;
		return toBTreeString(root, niveau, "x");
	}

	// private Hilfsmethoden

	/**
	 * Erstellt die Stringrepräsentation rekursiv in Gestalt eines horizontal
	 * angeordneten Binärbaumes.
	 */
	private String toBTreeString(TreeNode<E> node, int niveau, String indentExpr) {
		String btreeString = "\n";
		char nchar = Character.forDigit(niveau % 10, 10);
		if (indentExpr.indexOf('x') >= 0) {
			indentExpr = indentExpr.replace('x', nchar);
			btreeString += indentExpr;
			if (niveau == 0)
				indentExpr = indentExpr.replace(nchar, ' ');
			else
				indentExpr = indentExpr.replace(nchar, '|');
		} else if (indentExpr.indexOf('y') >= 0) {
			indentExpr = indentExpr.replace('y', nchar);
			btreeString += indentExpr;
			indentExpr = indentExpr.replace(nchar, ' ');
		}
		btreeString += "-- ";
		if (node != null) {
			btreeString += "Datenwert: " + node.data;
			niveau++;
			btreeString += toBTreeString(node.left, niveau, indentExpr
					+ "       x");
			btreeString += toBTreeString(node.right, niveau, indentExpr
					+ "       y");
		} else
			btreeString += "null";
		return btreeString;
	}

	/**
	 * Die Klasse "TreeNode" ist eine generische innere Klasse, von der sich
	 * Knotenobjekte für binäre Bäume generieren lassen. Bemerkung: Innere
	 * Klassen besitzen u.a. die Eigenschaft, dass sie nur innerhalb der Klasse,
	 * in der sie definiert sind (hier: BinaryTree), sichtbar sind.
	 */
	class TreeNode<T> {

		// Instanzvariablen

		T data; // Nutzdatenobjekt
		TreeNode<T> left = null; // der Baumknoten wird als
		TreeNode<T> right = null; // Blatt initialisiert

		// Konstruktor

		TreeNode(T data) {
			this.data = data;
		}

		// Instanzmethoden

		public String toString() {
			return data.toString();
		}

	}

}
