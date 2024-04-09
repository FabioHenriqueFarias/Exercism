class DoublyLinkedList<T> {
    private Element<T> head;

    void push(T value) {
        if(this.head == null){
            this.head = new Element<T>(value, null, null);
            return;
        }

        Element<T> element = new Element<>(value, null, null);
        Element<T> current = head;

        while(current.getNext() != null){
            current = current.getNext();
        }

        element.setPrev(current);
        current.setNext(element);
    }

    T pop() {

        Element<T> current = head;

        while (current.getNext() != null){
            current = current.getNext();
        }

        Element<T> prev = current.getPrev();

        if (prev == null){
            head = null;
            return current.getValue();
        }

        prev.setNext(null);
        return current.getValue();
    }

    void unshift(T value) {
        head = new Element<>(value, null, head);
    }


    T shift() {
        if (head == null) {
            return null;
        }

        Element<T> current = head;
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        }

        return current.getValue();
    }


    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Element<T> getPrev() {
            return prev;
        }

        public void setPrev(Element<T> prev) {
            this.prev = prev;
        }

        public Element<T> getNext() {
            return next;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }
    }
}
