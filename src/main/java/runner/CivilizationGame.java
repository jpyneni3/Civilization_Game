package runner;

import java.util.Optional;

import controller.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import model.Bandit;
import model.Egypt;
import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import view.CivEnum;
import view.GameScreen;
import view.GridFX;
import view.StartScreen;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {
    private Stage primaryS;
    private Bandit bandit;
    private StartScreen content;

  /**
   * this method is called upon running/launching the application this method
   * should display a scene on the stage
   */
    public void start(Stage primaryStage) {
        primaryS = primaryStage;
        content = new StartScreen();
        content.getStartButton().setOnAction(e -> {
                primaryS.setScene(startGame());

            });
        Scene scene = new Scene(content);
    // add1902,1080
        primaryS.setScene(scene);
        primaryS.show();
    }

  /**
   * This is the main method that launches the javafx application
   */
    public static void main(String[] args) {
        launch(args);
    }

  /**
   * This method is responsible for setting the scene to the corresponding
   * layout. and returning the scene.
   *
   * @return Scene
   */

    public Scene startGame() {
        CivEnum selCiv =
            content.getCivList().getSelectionModel().getSelectedItem();
        if (selCiv == CivEnum.ANCIENT_EGYPT) {
            GameController.setCivilization(new Egypt());
        } else if (selCiv == CivEnum.QIN_DYNASTY) {
            GameController.setCivilization(new QinDynasty());
        } else if (selCiv == CivEnum.ROMAN_EMPIRE) {
            GameController.setCivilization(new RomanEmpire());
        } else {
            GameController.setCivilization(new Egypt());
        }

        GameScreen gS = new GameScreen();
        TextInputDialog inpDial = new TextInputDialog("New Settlement");
        inpDial.setTitle("New Settlement Name");
        inpDial.setHeaderText("Pick a name for the new Settlement");
        Optional<String> inpRes = inpDial.showAndWait();
        String setName = inpRes.get();


        if (inpRes.isPresent()) {
      // GameController.getCivilization().getSettlement(setName);
            GridFX.getMap()
                .putSettlement(setName, GameController.getCivilization(), 4, 4);
            bandit = new Bandit();
            Map.addEnemies(bandit, 1);
            GameController.setBandits(bandit);

        }
        gS.update();
        Scene scene2 = new Scene(gS);
        primaryS.setScene(scene2);
        primaryS.show();
        return scene2;

    }

}
