/**
 * A minimal implementation of a binary search tree. See the python version for
 * additional documentation.
 * You can also see <a href="https://www.teach.cs.toronto.edu/~csc148h/notes/binary-search-trees/bst_implementation.html">
 *     CSC148 Course Notes Section 8.5 BST Implementation and Search</a>
 * if you want a refresher on BSTs, but it is not required to complete this assignment.
 */
public class BST {
    // we use Integer here so that we can set the root to null. This is the same idea as
    // how the Python code uses None in the BST implementation.
    private Integer root;

    private BST left;
    private BST right;

    public BST(int root) {
        this.root = root;
        this.left = new BST();
        this.right = new BST();
    }

    /**
     * Alternate constructor, so we don't have to explicitly pass in null.
     */
    public BST() {
        root = null;
        // left and right default to being null
    }


    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(int item) {
        // provided as an example
        if (this.isEmpty()) {
            return false;
        } else if (item == this.root) {
            return true;
        } else if (item < this.root) {
            return this.left.contains(item);
        }
        return this.right.contains(item);

    }


    public void insert(int item) {
        if (this.isEmpty()) {
            this.root = item;
            this.left = new BST();
            this.right = new BST();
        } else if (item <= this.root) {
            this.left.insert(item);
        } else {
            this.right.insert(item);
        }
    }


    public void delete(int item) {
        if (isEmpty()) return;
        if (item == this.root) {
            deleteRoot();
        } else if (item < this.root) {
            if (this.left != null) this.left.delete(item);
        } else {
            if (this.right != null) this.right.delete(item);
        }
    }

    private void deleteRoot() {
        boolean lEmpty = (left  == null) || left.isEmpty();
        boolean rEmpty = (right == null) || right.isEmpty();


        if (lEmpty && rEmpty) { root = null; left = right = null; return; }

        if (lEmpty)  { transplantFrom(right); return; }
        if (rEmpty)  { transplantFrom(left);  return; }

        root = left.extractMax();
    }


    private int extractMax() {
        if (right == null || right.isEmpty()) {
            int max = root;
            if (left == null || left.isEmpty()) {
                root = null; left = right = null;
            } else {
                transplantFrom(left);
            }
            return max;
        }
        return right.extractMax();
    }

    public int height() {
        return isEmpty() ? 0 : 1 + Math.max(left.height(), right.height());
    }

    public int count(int item) {
        if (isEmpty()) return 0;
        if (root > item)  return left.count(item);
        if (root == item) return 1 + left.count(item) + right.count(item);
        return right.count(item);
    }

    public int getSize() {
        if (isEmpty()) return 0;
        return 1 + left.getSize() + right.getSize();

    }

    private void transplantFrom(BST other) {
        this.root  = other.root;
        this.left  = other.left;
        this.right = other.right;
    }

    public static void main(String[] args) {
        // You can also add code here to do some basic testing if you want,
        // but make sure it doesn't contain syntax errors
        // or else we won't be able to run your code on MarkUs since the file won't
        // compile. Always make sure to run the self tests on MarkUs after you update your code.
        BST bst = new BST();
        int a = 1;
        bst.insert(a);
        System.out.println(bst.contains(a));
    }

}
