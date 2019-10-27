
import java.util.Vector;

public class Main {

    public static void main(String args[]) {
        int in[] = new int[10];

        for (int i = 0; i < 10; i++) {
            in[i] = i;
        }

        int n = in.length;
        BinaryTree tree = new BinaryTree();
        Vector<Main.Node> trees = tree.getTrees(in, 0, n - 1);
        System.out.println("Count: " + trees.size());
        System.out.println("Preorder traversal of different "
                + "binary trees are:");
        for (int i = 0; i < trees.size(); i++) {
            tree.preOrder(trees.get(i));
            System.out.println("");
        }
    }

    static class Node {

        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }

}
