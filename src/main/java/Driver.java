import java.util.List;

//  Definition for a binary tree node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {

    public int maxDepthUtil(Node root) {
        if (root == null) {
            return 0;
        }

        int height = 0;

        for (Node node : root.children) {
            int childHeight = maxDepthUtil(node);
            if (height < childHeight) {
                height = childHeight;
            }
        }

        return 1 + height;
    }

}

public class Driver {
    public static void main(String [] args) {

    }
}
