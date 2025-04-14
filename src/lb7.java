import java.util.*;

public class lb7 {


    static class TreeNode {
        double value;
        TreeNode left, right;

        TreeNode(double value) {
            this.value = value;
        }
    }

    static class BinarySearchTree {
        TreeNode root;


        void insert(double value) {
            root = insertRec(root, value);
        }

        private TreeNode insertRec(TreeNode node, double value) {
            if (node == null) return new TreeNode(value);
            if (value < node.value) node.left = insertRec(node.left, value);
            else node.right = insertRec(node.right, value);
            return node;
        }


        boolean search(double value) {
            return searchRec(root, value);
        }

        private boolean searchRec(TreeNode node, double value) {
            if (node == null) return false;
            if (node.value == value) return true;
            return value < node.value
                    ? searchRec(node.left, value)
                    : searchRec(node.right, value);
        }


        void delete(double value) {
            root = deleteRec(root, value);
        }

        private TreeNode deleteRec(TreeNode node, double value) {
            if (node == null) return null;
            if (value < node.value) {
                node.left = deleteRec(node.left, value);
            } else if (value > node.value) {
                node.right = deleteRec(node.right, value);
            } else {
                if (node.left == null) return node.right;
                else if (node.right == null) return node.left;


                node.value = minValue(node.right);
                node.right = deleteRec(node.right, node.value);
            }
            return node;
        }

        private double minValue(TreeNode node) {
            double min = node.value;
            while (node.left != null) {
                min = node.left.value;
                node = node.left;
            }
            return min;
        }

        void inOrderTraversal(TreeNode node) {
            if (node != null) {
                inOrderTraversal(node.left);
                System.out.print(node.value + " ");
                inOrderTraversal(node.right);
            }
        }

        void printTree() {
            inOrderTraversal(root);
            System.out.println();
        }

        double average() {
            double[] result = sumAndCount(root);
            return result[1] == 0 ? 0 : result[0] / result[1];
        }

        private double[] sumAndCount(TreeNode node) {
            if (node == null) return new double[]{0, 0};
            double[] left = sumAndCount(node.left);
            double[] right = sumAndCount(node.right);
            return new double[]{
                    node.value + left[0] + right[0],
                    1 + left[1] + right[1]
            };
        }

        void addAverageNode() {
            double avg = average();
            System.out.println("Середнє арифметичне: " + avg);
            insert(avg);
        }
    }

    static class IntTreeNode {
        int value;
        IntTreeNode left, right;

        IntTreeNode(int value) {
            this.value = value;
        }
    }

    static class IntBinarySearchTree {
        IntTreeNode root;

        void insert(int value) {
            root = insertRec(root, value);
        }

        private IntTreeNode insertRec(IntTreeNode node, int value) {
            if (node == null) return new IntTreeNode(value);
            if (value < node.value) node.left = insertRec(node.left, value);
            else node.right = insertRec(node.right, value);
            return node;
        }

        void inOrder(IntTreeNode node, List<Integer> sorted) {
            if (node != null) {
                inOrder(node.left, sorted);
                sorted.add(node.value);
                inOrder(node.right, sorted);
            }
        }

        List<Integer> getSortedList() {
            List<Integer> sorted = new ArrayList<>();
            inOrder(root, sorted);
            return sorted;
        }
    }

    public static void main(String[] args) {
        System.out.println("===== task 1 =====");
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(7.5);
        tree.insert(4.2);
        tree.insert(9.8);
        tree.insert(2.1);
        tree.insert(6.4);

        System.out.print("Початкове дерево");
        tree.printTree();


        double searchValue = 6.4;
        System.out.println("Пошук " + searchValue + ": " + (tree.search(searchValue) ? "Знайдено" : "Не знайдено"));


        tree.delete(4.2);
        System.out.print("after del 4.2: ");
        tree.printTree();


        tree.addAverageNode();
        System.out.print("after add avg: ");
        tree.printTree();


        System.out.println("\n===== task 2 =====");
        int[] numbers = {456, 124, 786, 435, 788, 444, 565, 127, 458, 322, 411, 531, 400, 546, 410};

        IntBinarySearchTree numTree = new IntBinarySearchTree();
        for (int num : numbers) {
            if (Integer.toString(num).startsWith("4")) {
                numTree.insert(num);
            }
        }

        List<Integer> sortedNumbers = numTree.getSortedList();
        System.out.println("start with 4:");
        System.out.println(sortedNumbers);
    }
}
