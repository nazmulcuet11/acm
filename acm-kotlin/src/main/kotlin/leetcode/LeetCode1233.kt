package leetcode

class LeetCode1233 {
    private data class TrieNode(
        var isEnding: Boolean,
        var children: MutableMap<String, TrieNode>
    )

    private val root = TrieNode(false, mutableMapOf())

    private fun insert(path: String) {
        val components = path.split('/').filterNot { it.isBlank() }
        var current = root
        for (component in components) {
            current = current.children.getOrPut(component) {
                TrieNode(false, mutableMapOf())
            }
        }
        current.isEnding = true
    }

    private fun getAllPaths(node: TrieNode, path: String, paths: MutableList<String>) {
        if (node.isEnding) {
            paths.add(path)
            return
        }

        for ((key, value) in node.children) {
            getAllPaths(value, "$path/$key", paths)
        }
    }

    fun removeSubfolders(folder: Array<String>): List<String> {
        for (path in folder) {
            insert(path)
        }
        val paths = mutableListOf<String>()
        getAllPaths(root, "", paths)
        return paths
    }
}