/** Interfaccia che implementa un albero
 */
public interface Tree<E> {
    /** Ritorna la dimensione dell'albero
     * @return La dimensione dell'albero
     */
    int size();
    /** Controlla se l'albero è vuoto
     * @return true se l'albero è vuoto, altrimenti false
     */
    boolean isEmpty();
    /** Ritorna la posizione della radice
     * @return La posizione del nodo radice
     */
    Position<E> root();
    /** Ritorna il padre del nodo p
     * @param p Il nodo di cui si vuole sapere il padre
     * @return Il padre del nodo. Ritorna null se p è la radice
     */
    Position<E> parent(Position<E> p);
    /** Ritorna i figli del nodo p
     * @param p Il nodo di cui si vogliono sapere i figli
     * @return Un oggetto Iterable sui figli del nodo p
     */
    Iterable<Position<E>> children(Position<E> p);
    /** Ritorna il numero di figli del nodo p
     * @param p Il nodo di cui si vuole sapere il numero dei figli
     * @return Il numero dei figli
     */
    int numChildren(Position<E> p);
    /**
     * 
     */
    boolean isInternal(Position<E> p);
    /**
     * 
     */
    boolean isExternal(Position<E> p);
    /**
     * 
     */
    boolean isRoot(Position<E> p);
    /**
     * 
     */
    Iterator<E> iterator();
    /**
     * 
     */
    Iterator<Position<E>> positions();
}