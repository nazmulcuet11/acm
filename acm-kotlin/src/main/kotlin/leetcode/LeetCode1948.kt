package leetcode

import java.util.TreeMap

class LeetCode1948 {
    fun deleteDuplicateFolder(paths: List<List<String>>): List<List<String>> {
        data class Folder(
            val name: String,
            var deleted: Boolean = false,
            val subfolders: TreeMap<String, Folder> = TreeMap(), // make sure that the keys are in order
        )

        val root = Folder("/")

        fun insert(path: List<String>) {
            var curr = root
            for (folderName in path) {
                curr = curr.subfolders.getOrPut(folderName) { Folder(folderName) }
            }
        }

        for (path in paths) {
            insert(path)
        }

        val visited = mutableMapOf<String, Folder>()

        fun serializeAndMark(folder: Folder): String {
            if (folder.subfolders.isEmpty()) {
                return "{${folder.name}}"
            }

            val subfolders = mutableListOf<String>()
            for (subfolder in folder.subfolders.values) {
                subfolders.add(serializeAndMark(subfolder))
            }

            val serializedSubfolders = "[" + subfolders.joinToString(",") + "]"
            visited[serializedSubfolders]?.let {
                it.deleted = true
                folder.deleted = true
            } ?: run {
                visited[serializedSubfolders] = folder
            }
            return "{${folder.name},$serializedSubfolders}"
        }

        serializeAndMark(root)

        val ans = mutableListOf<List<String>>()
        fun collectNonDeletedPaths(folder: Folder, curr: List<String>) {
            if (folder.deleted) {
                return
            }

            ans.add(curr + listOf(folder.name))
            for (subfolder in folder.subfolders.values) {
                collectNonDeletedPaths(subfolder, curr + listOf(folder.name))
            }
        }

        for (subfolder in root.subfolders.values) {
            collectNonDeletedPaths(subfolder, listOf())
        }

        return ans
    }
}