import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*

internal class LinkedListTest {

    lateinit var testList: LinkedList<Int>

    @BeforeEach
    fun setUp() {
        // create a new, empty list for each test
        testList = LinkedList()
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun consideredEmptyWhenSizeIsZero() {
        assertEquals(testList.size, 0)
        assertTrue(testList.isEmpty)

        testList.insert(1)

        assertEquals(testList.size, 1)
        assertFalse(testList.isEmpty)
    }

    @Test
    fun shouldBeEmptyWhenInitialized() {
        assertTrue(testList.isEmpty)
    }

    @Test
    fun shouldReturnEmptyStringWhenEmpty() {
        assertEquals("", testList.toString())
    }

    @Test
    fun returnSingleCharacterWithOneElement() {
        testList.insert(1)
        assertEquals("1", testList.toString())
    }

    @Test
    fun returnCommaSeparatedListAsString() {
        testList.insert(1)
        testList.insert(2)
        testList.insert(3)
        assertEquals("1, 2, 3", testList.toString())
    }

    fun createListOfFive() {
        testList.insert(1)
        testList.insert(2)
        testList.insert(3)
        testList.insert(4)
        testList.insert(5)
    }

    @Test
    fun canFindItemAtBeginningOfList() {
        createListOfFive()
        assertEquals(true, testList.find(1))
    }

    @Test
    fun canFindItemInMiddileOfList() {
        createListOfFive()
        assertEquals(true, testList.find(3))
    }

    @Test
    fun canFindItemAtEndOfList() {
        createListOfFive()
        assertEquals(true, testList.find(5))
    }
}