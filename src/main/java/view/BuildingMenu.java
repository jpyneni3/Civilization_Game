package view;

import controller.GameController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import model.Building;
import model.MapObject;
import model.Settlement;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    private Button demButton, invButton;

    public BuildingMenu() {
        demButton = new Button("Demolish");
        invButton = new Button("Invest");

        addMenuItem(demButton);
        addMenuItem(invButton);
        MapObject mapObj =
            GameController.getLastClicked().getTile().getOccupant();
        Alert err = new Alert(AlertType.ERROR);

        demButton.setOnAction(e -> {

                if (!(mapObj.isBuilding())) {
                    err.setContentText("You need to select "
                        + "a Building to Demolish");
                    err.setTitle("Not a Building!");
                    err.show();
                } else if (
                    GameController.getCivilization().getNumSettlements()
                    <= 1) {
                    err.setContentText("You must have atleast "
                        + " 2 Settlements");
                    err.setTitle("Not enough Settlements!");
                    err.show();
                } else if (!(mapObj instanceof Settlement)) {
                    err.setContentText("You need to select a "
                        + "Settlement to destroy");
                    err.setTitle("Not a Settlement!");
                    err.showAndWait();
                } else {
                    ((Building) mapObj).demolish();
                    GameController.getLastClicked().getTile().setOccupant(null);
                    //mapObj = null;

                }

            });

        invButton.setOnAction(e -> {
                int availG =
                    GameController.getCivilization().getTreasury().getCoins();

                if (availG < 25) {
                    err.setContentText("You need 25 Gold to Invest!");
                    err.setTitle("Not enough Gold!");
                    err.show();
                } else {
                    GameController.getCivilization().getTreasury().spend(25);
                    ((Settlement) mapObj).invest();
                }
                GameScreen.getResources().update();
            });

    }
}
