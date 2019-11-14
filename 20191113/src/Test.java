import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        myQueue.offer(5);
        myQueue.display();
        System.out.println(myQueue.size());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());
    }


    public static void main3(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("uu");
    }

    public static void main2(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.size());
        System.out.println(myStack.pop());
    }


    public static void main1(String[] args) {
        List<Character> list = searchNotRepeatChar("hello","l");
        System.out.println(list);

    }
    public static List<Character> searchNotRepeatChar(String str1,String str2) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if (str2.indexOf(str1.charAt(i)) == -1) {
                characters.add(str1.charAt(i));
            }
        }
        return characters;
    }

    public static List<List<Integer>> fun(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) {
            return lists;
        }
        lists.add(new ArrayList<>());
        lists.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> prev = lists.get(i - 1);
            for (int j = 1; j < i; j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }
            row.add(1);
            lists.add(row);
        }
        return lists;
    }
}
