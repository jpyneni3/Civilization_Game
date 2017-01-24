package view;

import controller.GameController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import model.TerrainTile;

/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    private Button aBtn;
    private Button mBtn;

  /**
   * Implement the buttons and actions associated with the buttons for the
   * military menu
   */
  /**
   *
   */
    public MilitaryMenu() {
        aBtn = new Button("Attack");
        mBtn = new Button("Move");
        addMenuItem(aBtn);
        addMenuItem(mBtn);
        Alert err = new Alert(AlertType.ERROR);

        TerrainTile lTile = GameController.getLastClicked().getTile();

        aBtn.setOnAction(e -> {
                GameController.attacking();
                GameScreen.getResources().update();


            });

        mBtn.setOnAction(e -> {
                // if (!lTile.isEmpty()) {
                //     err.setContentText("Not an empty tile!");
                //     err.setTitle("Tile not empty!");
                //     err.showAndWait();
                // } else {
                GameController.moving();

                //}

            });

    }
}
