package ru.job4j.list;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 20.06.2018
 * @version 1
 */
public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}

/**
 * Класс определяющий что список содержит замыкания.
 */
class Cycles {

    /**
     * Метод определяет замыкания списка.
     * @param head первый список.
     * @return true если содержит замыкания, false если нет.
     */
    boolean hasCycle(Node head) {
        Node first = head;
        Node second = head;
        while (second != null) {
            first = first.next;
            second = second.next;
            if (second != null) {
                second = second.next;
            }
            if (second != null && first == second) {
                return true;
            }
        }
        return false;
    }
}
