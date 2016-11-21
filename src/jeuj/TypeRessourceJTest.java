package jeuj;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by wilpiron on 21/11/2016.
 */
public class TypeRessourceJTest {

    @DataProvider(name="TP_Provider")
    public Object[][] TypeRessourceProvider(){
        return new Object[][]{
                {TypeRessourceJ.ARGILE, TypeRessourceJ.ARGILE},
                {TypeRessourceJ.ARGILE, TypeRessourceJ.BOIS},
                {TypeRessourceJ.ARGILE, TypeRessourceJ.PIERRE}
        };
    }
    @Test(dataProvider = "TP_Provider")
    public void TestArgile(Object o1, Object o2){

        Assert.assertEquals(o1.equals(o2), true);
    }
}

//TODO FINIR ET COMPLETER (FAIRE MARCHER)
