package steps;

import com.auctionedge.BowlingGame;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.core.Is.is;

public class BowlingSteps implements En {
    private BowlingGame game;

    public BowlingSteps() {
	    Given("^a bowling game$", () -> {
		    game = new BowlingGame();
	    });

	    When("^bowler rolls:", (DataTable rolls) -> {
	    	List<Integer> theRolls = rolls.asList(Integer.class);
	    	game.rolls(theRolls);
	    });

	    Then("^the score is (\\d+)$", (Integer arg1) -> {
	    	Assert.assertThat(game.score(), is(arg1));
	    });
    }
}
