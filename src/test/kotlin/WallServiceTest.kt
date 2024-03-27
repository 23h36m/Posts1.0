import org.junit.Test

import org.junit.Assert.*
import ru.netology.Post
import ru.netology.WallService

class WallServiceTest {

    @Test
    fun addTest() {
        val serviceTest = WallService

        val post = serviceTest.add(Post())

        val result = post.id

        assertEquals( 2, result)
    }

    @Test
    fun updateExistingTrue() {

        val serviceTest = WallService

        serviceTest.add(Post())

        val update = Post(1)

        val result = serviceTest.update(update)

        assertTrue( result)
    }

    @Test
    fun updateExistingFalse() {

        val serviceTest = WallService

        serviceTest.add(Post())

        val update = Post(5)

        val result = serviceTest.update(update)

        assertFalse( result)
    }


}