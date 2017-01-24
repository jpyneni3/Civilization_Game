package view;

import controller.GameController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import model.Convertable;
import model.TerrainTile;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    private Button mBtn;
    private Button cBtn;

  /**
   * There should be a convert and move button as well as the functions
   * associated with those buttons
   */
    public WorkerMenu() {
        mBtn = new Button("Move");
        cBtn = new Button("Convert");

        addMenuItem(mBtn);
        addMenuItem(cBtn);
        Alert err = new Alert(AlertType.ERROR);
        TerrainTile lTile = GameController.getLastClicked().getTile();

        mBtn.setOnAction(e -> {
        //         if (!lTile.isEmpty()) {
        //             err.setContentText("Not an empty tile!");
        //             err.setTitle("Tile not empty!");
        //             err.showAndWait();
        //
        // // err.showAndWait();
        //         } else {
                GameController.moving();
                //}
            });

        cBtn.setOnAction(e -> {
                Convertable c = (Convertable) (lTile.getOccupant());
                if (lTile.getOccupant().isWorker()
                    && c.canConvert(lTile.getType())) {
                    lTile.setOccupant(c.convert());
                    GridFX.update();
                    GameScreen.getResources().update();
                } else {
                    err.setContentText("Tile is not convertable");

                    err.setTitle("Unconvertable Tile");
                    err.showAndWait();
                }
            });


    }
}
