public class Main {

    private static final TreeNode _sampleTree1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    private static final TreeNode _sampleTree2 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
    private static final TreeNode _sampleTree3 = null;
    private static final TreeNode _sampleTree4 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    private static final TreeNode _sampleTree5 = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));
    private static final TreeNode _sampleTree6 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    private static final TreeNode _sampleTree7 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
    private static final TreeNode _sampleTree8 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), null), new TreeNode(2, null, new TreeNode(3)));



    public static void main(String[] args) {
        RunMaxDepthCases();
        System.out.println();
        RunMinDepthCases();
        System.out.println();
        RunIsBalancedTreeCases();
    }

    public static int MaxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = MaxDepth(root.left);
        int right = MaxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static int MinDepth(TreeNode root) {
        if (root == null) return 0;
        int left = MinDepth(root.left);
        int right = MinDepth(root.right);

        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return 1 + right;
        if (root.right == null) return 1 + left;

        return Math.min(left, right) + 1;
    }

    public static boolean IsBalancedTree(TreeNode root) {
        /** Definition height balance tree:
         *   A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
         */
        if (root == null) return true;
        int left = MaxDepth(root.left);
        int right = MaxDepth(root.right);

        if(Math.abs(left - right) > 1 ) return false;
        return IsBalancedTree(root.left) && IsBalancedTree(root.right);

    }

    public static void RunMaxDepthCases() {
        System.out.println("**** MAX DEPTH ****");
        Validator<Integer, Integer>[] MaxDepthCases = new Validator[]{
                new Validator<Integer, Integer>("TestCase1", 3, MaxDepth(_sampleTree1)),
                new Validator<Integer, Integer>("TestCase2", 4, MaxDepth(_sampleTree2)),
                new Validator<Integer, Integer>("TestCase3", 0, MaxDepth(_sampleTree3))
        };
        for (Validator<Integer, Integer> maxDepthCase : MaxDepthCases) {
            maxDepthCase.PrintValidation();
        }
    }

    public static void RunMinDepthCases() {
        System.out.println("**** MIN DEPTH ****");
        Validator<Integer, Integer>[] MinDepthCases = new Validator[]{
                new Validator<Integer, Integer>("TestCase1", 2, MinDepth(_sampleTree4)),
                new Validator<Integer, Integer>("TestCase2", 5, MinDepth(_sampleTree5)),
                new Validator<Integer, Integer>("TestCase3", 0, MinDepth(_sampleTree3))
        };

        for (Validator<Integer, Integer> minDepthCase : MinDepthCases) {
            minDepthCase.PrintValidation();
        }
    }

    public static void RunIsBalancedTreeCases() {
        System.out.println("**** BALANCED TREE ****");
        Validator<Boolean, Boolean>[] IsBalancedTreeCases = new Validator[]{
                new Validator<Boolean, Boolean>("TestCase1", true, IsBalancedTree(_sampleTree6)),
                new Validator<Boolean, Boolean>("TestCase2", false, IsBalancedTree(_sampleTree7)),
                new Validator<Boolean, Boolean>("TestCase3", false, IsBalancedTree(_sampleTree8)),
        };

        for (Validator<Boolean, Boolean> isBalancedTreeCase : IsBalancedTreeCases) {
            isBalancedTreeCase.PrintValidation();
        }
    }
}