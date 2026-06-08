/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder tree;
    String[] nodes;
    int i,n;
    private void dfsBuildString(TreeNode node){
        if(node == null){
            tree.append("n,");
            return;
        }
        tree.append(node.val+",");
        dfsBuildString(node.left);
        dfsBuildString(node.right);
    }
    private TreeNode buildTree(){
        if(i == n || nodes[i].equals("n")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
        i++;
        node.left = buildTree();
        i++;
        node.right = buildTree();
        return node;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        this.tree = new StringBuilder();
        dfsBuildString(root);
        return tree.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.nodes = data.split(",");
        this.n = nodes.length;
        this.i = 0;
        return buildTree();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));