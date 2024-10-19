/**
 * Interfaccia Iterator che verrà utilizzata per estendere le interfacce delle strutture dati che andranno utilizzate.
 * Definisce un iteratore
 */
public interface Iterator<E> {
    /** Controlla se c'è un prossimo elemento su cui iterare
     * @return true se c'è un prossimo elemento, altrimenti false
    */
    boolean hasNext();
    /** Ritorna il prossimo iteratore
     * @return l'iteratore che segue il corrente
    */
    E next();
}