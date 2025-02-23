package leetcode

class LeetCode889 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private fun solve(
        preorder: IntArray,
        postorder: IntArray,
        preStart: Int,
        preEnd: Int,
        postStart: Int,
        postEnd: Int
    ): TreeNode? {
        if (preStart > preEnd || postStart > postEnd) {
            return null
        }

        val value = preorder[preStart]
        val node = TreeNode(value)
        if (preStart == preEnd) {
            return node
        }

        val leftRoot = preorder[preStart + 1]
        var numberOfNodesOnLeft = 1
        var x = postStart
        while (postorder[x] != leftRoot) {
            x++
            numberOfNodesOnLeft++
        }

        node.left = solve(
            preorder,
            postorder,
            preStart + 1,
            preStart + numberOfNodesOnLeft,
            postStart,
            postStart + numberOfNodesOnLeft - 1
        )

        node.right = solve(
            preorder,
            postorder,
            preStart + numberOfNodesOnLeft + 1,
            preEnd,
            postStart + numberOfNodesOnLeft,
            postEnd - 1
        )
        return node
    }

    fun constructFromPrePost(
        preorder: IntArray,
        postorder: IntArray
    ): TreeNode? {
        return solve(
            preorder,
            postorder,
            0,
            preorder.size - 1,
            0,
            postorder.size - 1
        )
    }
}