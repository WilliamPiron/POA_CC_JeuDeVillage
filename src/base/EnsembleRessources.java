package base;

import java.util.HashMap;
import java.util.function.Predicate;
import java.util.Set;
import java.util.Map;

//TODO FINIR ET COMPLETER (FAIRE MARCHER)


/**
 * Created by wilpiron on 21/11/2016.
 */
public class EnsembleRessources {

    //PARTIE 1
    private Map<TypeRessource , Integer> ressources;

    public EnsembleRessources () {
        ressources = new HashMap<>();
    }

    public Set<TypeRessource> getTypesRessources ( ) {
        return ressources.keySet();
    }

    public int quantite ( TypeRessource ressource) {
        if (ressources.containsKey(ressource))
            return ressources.get(ressource);
        return 0;
    }

    public boolean disponible (TypeRessource ressource, int quantite ){
        return ((ressources.containsKey(ressource)) && (ressources.get(ressource)>=quantite));
    }

    public boolean permetTour(TypeRessource ressource, int quantiteProduite){
        if(quantiteProduite<0)// si le tour consomme une ressource, vérifier quantité disponible
            return disponible(ressource,-quantiteProduite);
        else
            return true;
    }

    public void ajouter(TypeRessource ressource, int quantite){
        if(!ressources.containsKey(ressource))
            ressources.put(ressource,0);
        ressources.put(ressource,ressources.get(ressource)+quantite);
    }

    public void supprimer(TypeRessource ressource,int quantite) throws ProblemeRessources {
        if(!disponible(ressource,quantite))
            throw new ProblemeRessources();
        ressources.put(ressource,ressources.get(ressource)-quantite);
    }



    // PARTIE 2
    public Predicate<TypeRessource> P_disponible(EnsembleRessources ressourcesRequises){
        return ressource -> disponible(ressource, ressourcesRequises.quantite(ressource));
    }

    public Predicate<TypeRessource> P_permetTour(EnsembleRessources ressourcesProduites){
        return ressource -> permetTour(ressource, ressourcesProduites.quantite(ressource));
    }

    public boolean disponible(EnsembleRessources ressourcesRequises){
        return ressourcesRequises.getTypesRessources().stream().allMatch(P_disponible(ressourcesRequises));
    }

    public boolean permetTour(EnsembleRessources ressourcesProduites){
        return ressourcesProduites.getTypesRessources().stream().allMatch(P_permetTour(ressourcesProduites));
    }

    public void ajouter(EnsembleRessources ressourcesAdditionnelles){
        ressourcesAdditionnelles.getTypesRessources().stream().forEach(ra -> ajouter(ra, ressourcesAdditionnelles.quantite(ra)));
    }

    //AJOUT TRY CATCH SINON ERREUR
    public void supprimer(EnsembleRessources ressourcesASupprimer) throws ProblemeRessources{
        ressourcesASupprimer.getTypesRessources().stream().forEach(ras -> {
            try {
                supprimer(ras, ressourcesASupprimer.quantite(ras));
            } catch (ProblemeRessources problemeRessources) {
                problemeRessources.printStackTrace();
            }
        });
    }
}
