package jeuj;

import base.TypeRessource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wilpiron on 21/11/2016.
 */
public abstract class AbstractBatiment extends base.AbstractBatiment {
    private int niveau;
    private Map<Map<TypeRessource, Integer>, Integer> construction;
    private Map<TypeRessource, Integer> production;

    public AbstractBatiment() {
        super();
        this.production = new HashMap<>();
        this.construction = new HashMap<>();
    }

    /*
    @Override
    public Map<TypeRessource, Integer> getPrerequis(int niveau) {
        //TODO FINIR ET COMPLETER (FAIRE MARCHER)
    }
    */

    @Override
    public Map<TypeRessource, Integer> jouerTour() {
        return null;
    }
}

//TODO FINIR ET COMPLETER (FAIRE MARCHER)

