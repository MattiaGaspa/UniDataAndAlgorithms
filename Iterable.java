/**
 * Interfaccia Iterable che verrà utilizzata per estendere le interfacce delle strutture dati che andranno utilizzate.
 * Definisce una struttura dati che è iterabile
 */
public interface Iterable<E> {
    /** Ritorna un iteratore della struttura dati
     * @return Un iteratore
     */
    Iterator<E> iterator();
}