import org.junit.Test

import org.junit.Assert.*
import ru.netology.Post
import ru.netology.WallService

class WallServiceTest {

    @Test
    fun addTest() {
        val serviceTest = WallService

        val post = serviceTest.add(Post(image = null, video = null))

        val result = post.id

        assertEquals( 2, result)
    }

    @Test
    fun updateExistingTrue() {

        val serviceTest = WallService

        serviceTest.add(Post(image = null, video = null))

        val update = Post(1, image = null, video = null)

        val result = serviceTest.update(update)

        assertTrue( result)
    }

    @Test
    fun updateExistingFalse() {

        val serviceTest = WallService

        serviceTest.add(Post(image = null, video = null))

        val update = Post(5, image = null, video = null)

        val result = serviceTest.update(update)

        assertFalse( result)
    }


}