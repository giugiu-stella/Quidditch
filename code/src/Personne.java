import Exceptions.JoueurBlesseException;
import Exceptions.MagieInterditeException;

/**
 * contient une methode ensorcele car le public peut aussi agir
 * sur le match. comme professeur rogue, par exemple!
 */
public abstract class Personne {
    /**
     * 
     * @param j Pour simplifier notre programme, ensorceler un joueur signifie que
     *          ce joueur perd d'un coup une certaine quantite degats d'energie.
     * @throws MagieInterditeException
     * @throws JoueurBlesseException
     */
    public void ensorceleJoueur(Joueur j, int degats) throws MagieInterditeException, JoueurBlesseException {
        j.energie -= degats;
        j.perteEnergie(degats);
    }
}