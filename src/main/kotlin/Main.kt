package ru.netology

data class Likes(val likesCount: Int = 0, val doesTheUserLikeIt: Boolean = false) {
}

data class Reposts(val repostsCount: Int = 0, val didTheUserRepostIt: Boolean = false) {
}

data class Post(
    val id: Int = 0,
    val fromId: Int = 0,
    val views: Int = 0,
    val text: String = "-",
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts()
) {
}

object WallService {
    private var posts = emptyArray<Post>()
    private var lastId = 0

    fun add(post: Post): Post {
        posts += post.copy(id = ++lastId, likes = post.likes.copy())
        return posts.last()
    }

    fun printAll() {
        for (post in posts) {
            println(post)
            println(" ")
        }
        println()
    }

    fun update(post: Post): Boolean {
        for ((index, primalPost) in posts.withIndex()) {
            if (primalPost.id == post.id) {
                posts[index] = post.copy(likes = post.likes.copy())
                return true
            }
        }
        return false
    }
}

fun main() {
    WallService.add(Post(1, 2, 60))
    WallService.add(Post(5))
    WallService.printAll()

    println(WallService.update(Post(5, likes = Likes(100, false))))
    WallService.printAll()
}