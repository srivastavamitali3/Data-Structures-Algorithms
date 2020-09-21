package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodesDistanceKInBT {
    public static void main(String[] args) {

    }

    Map<TreeNode, TreeNode> map = null;
    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        buildParentMap(root, target, new HashMap<>());
        dfs(target, null, 0, K);
        return result;
    }

    private void dfs(TreeNode target, TreeNode parent, int source, int k) {
        if (target == null)
            return;
        if (source == k) {
            result.add(target.val);
            return;
        }
        if (target.left != parent)
            dfs(target.left, target, source + 1, k);
        if (target.right != parent)
            dfs(target.right, target, source + 1, k);
        dfs(map.getOrDefault(target, null), target, source + 1, k);
    }

    private boolean buildParentMap(TreeNode root, TreeNode target, HashMap<TreeNode, TreeNode> tempMap) {
        if (root == null)
            return false;

        if (root == target) {
            map = new HashMap<>(tempMap);
            return true;
        }

        boolean flag = false;
        if (root.left != null) {
            tempMap.put(root.left, root);
            flag = buildParentMap(root.left, target, tempMap);
            tempMap.remove(root.left);
        }
        if (!flag && root.right != null) {
            tempMap.put(root.right, root);
            flag = buildParentMap(root.right, target, tempMap);
            tempMap.remove(root.right);
        }
        return flag;
    }
}
