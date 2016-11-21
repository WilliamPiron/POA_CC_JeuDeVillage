package base;

import java.util.Map;

/**
 * Created by wilpiron on 21/11/2016.
 */
public abstract class AbstractBatiment implements Batiment{
    private int niveau;

    public AbstractBatiment() {
        this.niveau = 0;
    }

    @Override
    public int getNiveau() {
        return this.niveau;
    }

    @Override
    public void niveauSuivant(Map<TypeRessource, Integer> ressources) throws ProblemeRessources {
        if (getPrerequis(this.niveau).equals(ressources)){
            this.niveau++;
        }
        else {
            throw new ProblemeRessources();
        }
    }

    //TODO FINIR ET COMPLETER (FAIRE MARCHER)


}
