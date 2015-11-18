package test.java.lsv.core;

import static org.junit.Assert.*;	
import org.junit.Test;
import main.java.lsv.core.Builder;
import main.java.lsv.model.State;
import main.java.lsv.model.Transition;
import main.java.lsv.model.Model;


public class ModelTest {

    @Test
    public void parseModel() {

	Model model = Builder.buildModel("src/test/resources/model.json");

	assertEquals(3, model.getStates().length);


	

    }


}
