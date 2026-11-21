import java.util.Objects;

public class LinkedListClass<T> {
    private DNode<T> header;

    private LinkedListClass() {
        header = null;
    }

    public LinkedListClass(DNode<T> header) {
        this.header = header;
        header.setPred(null);
    }

    public DNode<T> getHeader () {
        return this.header;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LinkedListClass that)) return false;
        return Objects.equals(header, that.header);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(header);
    }

    public int size () {
        DNode<T> node = this.header;
        if (node == null) {
            return 0;
        }
        int count = 1;
        while (true) {
            if (node.getNext() != null) {
                ++count;
                node = node.getNext();
            }
            else break;
        }
        return count;
    }

    public int size2 () {
        DNode<T> node = this.header;
        if (node == null) {
            return 0;
        }
        int count = 1;
        while (true) {
            if (node.getNext() != this.header) {
                ++count;
                node = node.getNext();
            }
            else break;
        }
        return count;
    }

    public boolean isEmpty() {
        return header == null;
    }


    public void addLast(T element) {
        DNode<T> newDNode = new DNode(element);

        if (header == null) {
            header = newDNode;
            return;
        }

        DNode<T> tmpHeader = header;
        while (tmpHeader.getNext() != null) {
            tmpHeader = tmpHeader.getNext();
        }
        tmpHeader.setNext(newDNode);

    }

    public DNode<T> first() {
        if(isEmpty()) {
            return null;
        }else {
            return header;
        }
    }

    public T last() {
        if(isEmpty()) {
            return null;
        }

        DNode<T> current = header;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        return current.getElement();
    }

    public void addFirst(T element) {
        DNode<T> tmpHeader = new DNode(element);
        tmpHeader.setNext(header);
        this.header = tmpHeader;
    }

    @Override
    public String toString() {
        if (header == null) return "";
        StringBuilder sb = new StringBuilder(header.toString());
        DNode<T> current = header;
        while (current.getNext() != null) {
            current = current.getNext();
            sb.append("," + current.toString());
        }

        return sb.toString();
    }

    public DNode removeFirst() {
        if (isEmpty()) {
            return null;
        }
        else {
            header = header.getNext();
            return header;
        }
    }

    public DNode findBeforeLast() {
        if (this.size() <= 2) return header;
        DNode<T> node = this.header;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node.getPred();
    }

    public void clear() {
        header = null;
    }

    private static class DNode<T> {

        private T element;
        private DNode<T> pred;
        private DNode<T> next;

        public DNode(T element) {
            this.element = element;
        }

        public DNode (T e, DNode<T> p, DNode<T> n) {
            element = e;
            pred = p;
            next = n;
        }

        public String toString() {
            return element.toString();
        }

        public T getElement () {
            return element;
        }

        public DNode<T> getNext() {
            return next;
        }

        public void setNext (DNode<T> newNext) {
            newNext.pred = this;
            next = newNext;
        }

        public DNode<T> getPred() {
            return pred;
        }

        public void setPred(DNode<T> newPred) {
            newPred.next = this;
            pred = newPred;
        }

        public void setElement(T newElem) {
            element = newElem;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof DNode that)) return false;
            return element.equals(that.element)
                    && Objects.equals(next, that.next);
        }
    }

    public static void main(String[] args) {
        LinkedListClass<Integer> maListe = new LinkedListClass();
        maListe.addLast(5);
        maListe.addLast(6);
        maListe.addLast(7);


        LinkedListClass<Integer> maListe2 = new LinkedListClass();
        maListe2.addLast(5);
        maListe2.addLast(6);
        maListe2.addLast(7);
        System.out.println("vide : " + maListe2.isEmpty() + "\n");
        System.out.println("test2 (5):" + maListe.getHeader() + "\n");
        System.out.println("test2 (6):" + maListe.getHeader().getNext() + "\n");
        System.out.println("test2 (7):" + maListe.getHeader().getNext().getNext() + "\n");
        System.out.println("to String : " + maListe + "\n");
        maListe.addFirst(9);
        System.out.println("On ajoute un 9 au debut : " + maListe.getHeader() + ", Le premier chiffre est bien " + maListe.first() + "\n");
        System.out.println("to String : " + maListe.toString() + "\n");
        System.out.println(maListe2.isEmpty() + "\n");
        maListe2.addFirst(485);
        System.out.println(maListe2.toString() + "\n");
        maListe2.addFirst(584);
        System.out.println(maListe2 + "\n");
        System.out.println("Taille de la première liste : " + maListe.size() + "\nTaille de la seconde liste : " + maListe2.size() + "\n");
        System.out.println(maListe.findBeforeLast());

        LinkedListClass<String> listeCirculaire = new LinkedListClass<>();
        listeCirculaire.addLast("geg");
        listeCirculaire.addLast("aaaaaaaa");
        listeCirculaire.addLast("grergv");
        listeCirculaire.addLast("gvhbdgbv");
        listeCirculaire.addLast("vizjvizujviz");

        LinkedListClass<String> liste28 = new LinkedListClass<>();
        liste28.addLast("geg");
        liste28.addLast("aaaaaaaa");
        liste28.addLast("grergv");
        liste28.addLast("gvhbdgbv");
        liste28.addLast("vizjvizujviz");

        listeCirculaire.findBeforeLast().getNext().setNext(listeCirculaire.getHeader());

        System.out.println(listeCirculaire.size2());

        LinkedListClass<Integer> maListe3 = new LinkedListClass();
        maListe3.addLast(1);
        maListe3.addLast(2);
        maListe3.addLast(3);
        maListe3.addLast(4);
        maListe3.addLast(5);
        maListe3.addLast(6);

        LinkedListClass<Integer> maListe4 = new LinkedListClass();
        maListe4.addLast(1);
        maListe4.addLast(2);
        maListe4.addLast(3);
        maListe4.addLast(4);
        maListe4.addLast(5);
        maListe4.addLast(6);

        System.out.println("Liste 3 : \n" + maListe3 + "\nListe 4 : \n" + maListe3);

        System.out.println(maListe3.equals(maListe4) + "\n");

        System.out.println("Liste de String :\n" + liste28);

        liste28.clear();
        System.out.println("Liste vidée : " + liste28 + "\n");



        /*
        System.out.println("Liste non-inversée : \n" + maListe);

        maListe.invertList();
        maListe.invertList();

        System.out.println("Liste inversée : \n" + maListe);

        LinkedListClass maListe3 = new LinkedListClass();
        maListe3.addLast(1);
        maListe3.addLast(2);
        maListe3.addLast(3);
        maListe3.addLast(4);
        maListe3.addLast(5);
        maListe3.addLast(6);

        LinkedListClass maListe4 = new LinkedListClass();
        maListe4.addLast(1);
        maListe4.addLast(2);
        maListe4.addLast(3);
        maListe4.addLast(4);
        maListe4.addLast(5);
        maListe4.addLast(6);

        System.out.println("Liste basique : \n" + maListe3);

        maListe3.switchDNodes(maListe3.first(),maListe3.first().getNext().getNext().getNext());

        System.out.println("Liste avec 1 et 4 inversés : \n" + maListe3);
         */

    }
}
