public class Test {
    public static void main(String[] args){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] arr = {7,3,4,9,12,45,2,5};
        for (int i = 0; i < arr.length; i++) {
            binarySearchTree.insert(arr[i]);
        }
        binarySearchTree.inorder(binarySearchTree.root);
        System.out.println();
        try {
            BinarySearchTree.Node ret = binarySearchTree.search(4);
            System.out.println(ret.val);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ret不存在");
        }
        binarySearchTree.remove(2);
        binarySearchTree.inorder(binarySearchTree.root);
    }
}
