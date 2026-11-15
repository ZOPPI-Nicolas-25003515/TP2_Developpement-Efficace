public class SinglyListClass {

    private Node header;

    public Node getHeader() {
        return header;
    }

    public SinglyListClass() {
        header = null;
        //size = 0;
    }
    public SinglyListClass(Node header) {
        this.header = header;
        //size = 1;

    }

    public int size () {
        Node node = this.header;
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

    public boolean isEmpty() {
        if(header == null) {
            return true;
        }else {
            return false;
        }
    }


    public void addLast(Integer element) {
        Node newNode = new Node(element);

        if (header == null) {
            header = newNode;
            //size++;
            return;
        }

        Node  tmpHeader = header;
        while (tmpHeader.getNext() != null) {
            tmpHeader = tmpHeader.getNext();
        }
        tmpHeader.setNext(newNode);

    }

    public Node first() {
        if(isEmpty()) {
            return null;
        }else {
            return header;
        }
    }

    public Integer last() {
        if(isEmpty()) {
            return null;
        }

        Node current = header;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        return current.getElement();
    }

    public void addFirst(Integer element) {
        Node tmpHeader = new Node(element);
        tmpHeader.setNext(header);
        this.header = tmpHeader;
    }

    @Override
    public String toString() {
        if (header == null) return "";
        StringBuilder sb = new StringBuilder(header.toString());
        Node current = header;
        while (current.getNext() != null) {
            current = current.getNext();
            sb.append("," + current.toString());
        }

        return sb.toString();
    }

    public Node removeFirst() {
        if (isEmpty()) {
            return null;
        }
        else {
            header = header.getNext();
            return header;
        }
    }

    public Node findBeforeLast() {
        if (this.size() <= 2) return header;
        Node node = this.header;
        while (node.next.next != null) {
            node = node.next;
        }
        return node;
    }

    public void invertList() {
        //On crée 3 Nodes : previous, current et next, le premier vaut null au départ, le second pointe vers header
        Node previous = null;
        Node current = header;
        while(current != null) {
            //le dernier est initialisé à chaque passage de boucle et vaut le second noeud de current
            Node next = current.getNext();
            //on modifie le second noeud pour lui mettre previous (au depart on le rendra nul)
            current.setNext(previous);
            //On fait pointer previous vers current qui sera le noeud contenant la construction de la liste inversée
            previous = current;
            //On fait pointer current vers next
            current = next;
            // On aura donc current qui aura par exemple 2 3 4 5 dans le second passage à qui on enleve le seoond noeud
            //ce qui fera 2 1, qu'on fera ensuite pointer vers previous et ainsi de suite
        }
        //on fait enfin pointer header vers previous
        this.header = previous;
     }

     public void switchNodes(Node x, Node y) {

         Node predX = null;
         if (x != header) {
             predX = header;
             while (predX.getNext() != x) predX = predX.getNext();
         }
         Node predY = null;
         if (y != header) {
             predY = header;
             while (predY.getNext() != y) predY = predY.getNext();
         }

         Node succX = x.getNext();
         Node succY = y.getNext();

         if (succX == y) {
             if (predX == null) {
                 header = y;
                 y.setNext(x);
                 x.setNext(succY);
             }
             else {
                 predX.setNext(y);
                 y.setNext(x);
                 x.setNext(succY);
             }
         }

         else if (succY == x) {
             if (predY == null) {
                 header = x;
                 x.setNext(y);
                 y.setNext(succX);
             }
             else {
                 predY.setNext(x);
                 x.setNext(y);
                 y.setNext(succX);
             }
         }

        else if (predX == null) {
             header = y;
             y.setNext(succX);
            predY.setNext(x);
            x.setNext(succY);
        }

        else if (predY == null) {
             header = x;
             x.setNext(succY);
             predX.setNext(y);
             y.setNext(succX);
        }

        else {
            predX.setNext(y);
            y.setNext(succX);
            predY.setNext(x);
            x.setNext(succY);
        }
     }

    private static class Node {

        private Integer element;
        private Node next;


        public Node(Integer element) {
            this.element = element;
        }

        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }

        public String toString() {
            return element.toString();
       }

        public Integer getElement () {
            return element;
        }

        public Node getNext() {
            return next;
        }

        public void setElement(Integer newElem) {
            element = newElem;
        }

        public void setNext (Node newNext) {
            next = newNext;
        }

    }

    public static void main(String[] args) {
        SinglyListClass maListe = new SinglyListClass();
        SinglyListClass maListe2 = new SinglyListClass();
        maListe.addLast(5);
        maListe.addLast(6);
        maListe.addLast(7);
        System.out.println(maListe2.isEmpty());
        System.out.println("test2 (5):" + maListe.getHeader() + "\n");
        System.out.println("test2 (6):" + maListe.getHeader().getNext() + "\n");
        System.out.println("test2 (7):" + maListe.getHeader().getNext().getNext() + "\n");
        System.out.println("to String : " + maListe.toString() + "\n");
        maListe.addFirst(9);
        System.out.println("On ajoute un 9 au debut : " + maListe.getHeader() + ", Le premier chiffre est bien " + maListe.first() + "\n");
        System.out.println("to String : " + maListe.toString() + "\n");
        System.out.println(maListe2.isEmpty() + "\n");
        maListe2.addFirst(485);
        System.out.println(maListe2.toString() + "\n");
        maListe2.addFirst(584);
        System.out.println(maListe2 + "\n");
        System.out.println("Taille de la première liste : " + maListe.size() + "\nTaille de la seconde liste : " + maListe2.size() + "\n");
        System.out.println(maListe.findBeforeLast().getElement());

        System.out.println("Liste non-inversée : \n" + maListe);

        maListe.invertList();
        maListe.invertList();

        System.out.println("Liste inversée : \n" + maListe);

        SinglyListClass maListe3 = new SinglyListClass();
        maListe3.addLast(1);
        maListe3.addLast(2);
        maListe3.addLast(3);
        maListe3.addLast(4);
        maListe3.addLast(5);
        maListe3.addLast(6);

        SinglyListClass maListe4 = new SinglyListClass();
        maListe4.addLast(1);
        maListe4.addLast(2);
        maListe4.addLast(3);
        maListe4.addLast(4);
        maListe4.addLast(5);
        maListe4.addLast(6);

        System.out.println("Liste basique : \n" + maListe3);

        maListe3.switchNodes(maListe3.first(),maListe3.first().getNext().getNext().getNext());

        System.out.println("Liste avec 1 et 4 inversés : \n" + maListe3);

    }
    }
