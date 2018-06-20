class LinkedList<T> {
    private var head: ListNode<T>? = null
    private var tail: ListNode<T>? = null
    var size = 0

    val isEmpty: Boolean get() = size == 0

    fun insert(item: T) {
        if (head == null) {
            head = ListNode(item)
            tail = head;
        } else {
            tail!!.next = ListNode(item)
            tail = tail!!.next
        }
        size++
    }

    fun find(item: T): Boolean {
        var iterator = head
        while (iterator != null) {
            if (iterator.item == item) {
                return true
            } else {
                iterator = iterator.next
            }
        }
        return false
    }

    fun remove(item: T) {
        if (!isEmpty) {
            if (head!!.item == item) {
                head = head!!.next
            } else {
                var prev = head
                var curr = head!!.next
                while (curr != null) {
                    // Current node will be null when prev is at the tail.
                    if (curr.item == item) {
                        prev!!.next = curr.next
                        size--
                        return
                    } else {
                        prev = curr
                        curr = curr.next
                    }
                }
            }
        }
    }

    override fun toString(): String {
        var returnValue = ""

        if (size > 0) {
            var iterator = head
            while (iterator!!.next != null) {
                returnValue += "${iterator.item}, "
                iterator = iterator.next
            }
            returnValue += iterator.item.toString()
        }

        return returnValue
    }
}