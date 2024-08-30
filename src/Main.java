public class Main {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        //testando adição
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Lista após adição de elementos:");
        list.printList();

        //testando adição em posição específica
        list.add(1, 15);
        System.out.println("Lista após adição na posição 1:");
        list.printList();

        //testando remoção por posição
        list.remove(2);
        System.out.println("Lista após remoção da posição 2:");
        list.printList();

        //testando remoção por nó
        DoublyLinkedList<Integer>.Node nodeToRemove = list.getNode(1); // Acessando o nó diretamente
        list.remove(nodeToRemove);
        System.out.println("Lista após remoção do nó na posição 1:");
        list.printList();

        //testando obtenção de elemento
        System.out.println("Elemento na posição 0: " + list.get(0));

        // Testando atualização de elemento
        list.set(0, 25);
        System.out.println("Lista após atualização da posição 0:");
        list.printList();

        //testando se a lista está cheia
        System.out.println("A lista está cheia? " + list.isFull());

        //testando limpar a lista
        list.clear();
        System.out.println("Lista após limpar:");
        list.printList();
        System.out.println("Lista está vazia? " + list.isEmpty());
    }
}
