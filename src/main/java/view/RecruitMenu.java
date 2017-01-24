package view;

import java.util.Optional;

import controller.GameController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import model.TerrainTile;
import model.Unit;


/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {
    private ObservableList<String> oALString;
    private Button selectedBtn;

  /**
   * recuit menu should have a list of worker/units to choose from. There
   * should also be a select button and the function of the button should be
   * implemented here
   */
    public RecruitMenu() {
        oALString = FXCollections.observableArrayList("Melee Unit",
            "Range Unit", "Hybrid Unit", "Siege Unit", "Settlers",
            "Farmers", "Coal Miners", "Anglers", "Master Builder");
        ListView<String> lString = new ListView<>(oALString);
        lString.setMaxHeight(200);
        addMenuItem(lString);
        Alert err = new Alert(AlertType.ERROR);

        selectedBtn = new Button("Select");
        addMenuItem(selectedBtn);
        selectedBtn.setOnAction(e-> {
                String selectItem =
                    lString.getSelectionModel().getSelectedItem();
                TerrainTile curTile = GameController.getLastClicked().getTile();
                Unit unit;
                switch (selectItem) {
                case "Melee Unit": unit =
                  GameController.getCivilization().getMeleeUnit();
                break;
                case "Ranged Unit": unit =
                  GameController.getCivilization().getRangedUnit();
                break;
                case "Hybrid Unit": unit =
                  GameController.getCivilization().getHybridUnit();
                break;
                case "Siege Unit": unit =
                  GameController.getCivilization().getSiegeUnit();
                break;
                case "Settlers":
                    TextInputDialog inpDial =
                        new TextInputDialog("New Settlement");
                    inpDial.setTitle("New Settlement Name");
                    inpDial.setHeaderText("Pick a name for the new Settlement");
                    Optional<String> inpRes = inpDial.showAndWait();
                    String setName = inpRes.get();
                    unit =
                      GameController.getCivilization().getSettlerUnit(setName);
                    break;
                case "Farmers": unit =
                    GameController.getCivilization().getFarmerUnit();
                break;
                case "Coal Miners": unit =
                    GameController.getCivilization().getCoalMinerUnit();
            break;
                case "Anglers": unit =
                    GameController.getCivilization().getAnglerUnit();
            break;
                case "Master Buildings": unit =
                    GameController.getCivilization().getMasterBuilderUnit();
            break;
                default: unit = null;
            break;
                }
                if (unit.isAffordable()) {
                    unit.applyInitialCosts();
                    curTile.setOccupant(unit);
                } else {
                    err.setTitle("Not Affordable");
                    err.setContentText("You cannot afford "
                        + " to carry out this action");
                    err.showAndWait();
                }
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            });





    }
}
