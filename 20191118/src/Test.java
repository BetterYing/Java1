public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.preOrderTraversal(root);
        binaryTree.inOrderTraversal(root);
        binaryTree.postOrderTraversal(root);

//        System.out.println(binaryTree.getSize1(root));
//        System.out.println(binaryTree.getSize2(root));
//
//
//        System.out.println(binaryTree.getLeafSize1(root));
//        System.out.println(binaryTree.getLeafSize2(root));


    }
}
