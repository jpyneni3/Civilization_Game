package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {

    private static ResourcesMenu resMenu;
    private static AbstractMenu aMenu;
    private GridFX gM;
    private static VBox lBox;

  /**
   * Creates a new view into the game. this layout should include the
   * rescource bar, grid map, and action menus
   *
   */
    public GameScreen() {
        gM = GridFX.getInstance();
        resMenu = new ResourcesMenu();
        aMenu = new AbstractMenu();
        lBox = aMenu.getRootNode();


        setCenter(gM);
        setTop(resMenu.getRootNode());
        setLeft(lBox);
        // update();

    }

  /**
   * This method should update the gridfx and the resouce bar
   */
    public void update() {
        GridFX.update();
        GameController.updateResourcesBar();
        // resMenu.update();
    }

  /**
   * this method should return the resource menu
   *
   * @return reosuce menu
   */
    public static ResourcesMenu getResources() {
        return resMenu;
    }

  /**
   * This method switches menus based on passed in game state. Game.java calls
   * this to selectively control which menus are displayed
   *
   * @param state
   */
    public static void switchMenu(GameController.GameState state) {
        if (state == GameController.GameState.NEUTRAL) {
            lBox.getChildren().setAll((new StatusMenu()).getRootNode());
        } else if (state == GameController.GameState.MILITARY) {
            lBox.getChildren().setAll((new MilitaryMenu()).getRootNode());
        } else if (state == GameController.GameState.WORKER) {
            lBox.getChildren().setAll((new WorkerMenu()).getRootNode());
        } else if (state == GameController.GameState.BUILDING) {
            lBox.getChildren().setAll((new BuildingMenu()).getRootNode());
        } else {
            lBox.getChildren().setAll((new RecruitMenu()).getRootNode());
        }
    }
}
