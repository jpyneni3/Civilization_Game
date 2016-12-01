package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;

public class ResourcesMenu {
    private HBox rBar;
    private Civilization civ;
    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        rBar = new HBox(10);
        civ = GameController.getCivilization();
        rBar.getChildren().add(new Text("Strategy Level: "
              + civ.getStrategy().getStrategyLevel()));
        rBar.getChildren().add(new Text("Resources: "
              + civ.getResources()));
        rBar.getChildren().add(new Text("Settlements: "
              + civ.getNumSettlements()));
        rBar.getChildren().add(new Text("Gold: "
              + civ.getTreasury().getCoins()));
        rBar.getChildren().add(new Text("Food: "
              + civ.getFood()));
        rBar.getChildren().add(new Text("Happiness: "
              + civ.getHappiness()));
        //update();
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        rBar.getChildren().clear();
        rBar.getChildren().add(new Text("Strategy Level: "
              + civ.getStrategy().getStrategyLevel()));
        rBar.getChildren().add(new Text("Resources: "
              + civ.getResources()));
        rBar.getChildren().add(new Text("Settlements: "
              + civ.getNumSettlements()));
        rBar.getChildren().add(new Text("Gold: "
              + civ.getTreasury().getCoins()));
        rBar.getChildren().add(new Text("Food: "
              + civ.getFood()));
        rBar.getChildren().add(new Text("Happiness: "
              + civ.getHappiness()));

    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        update();
        return rBar;
    }
}
