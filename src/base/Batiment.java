package base;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by wilpiron on 21/11/2016.
 */
public interface Batiment {
    int getNiveau();
    Map<TypeRessource, Integer> getPrerequis(int niveau);
    Map<TypeRessource, Integer> jouerTour();
    void niveauSuivant (Map<TypeRessource, Integer> ressources) throws ProblemeRessources;
}

//TODO FINIR ET COMPLETER (FAIRE MARCHER)

