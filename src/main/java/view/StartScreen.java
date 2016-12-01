package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Created by Tian-Yo Yang on 11/11/2016. This class represents the Start Screen
 * for the Civ applicatios. This is the layout that should be displayed upon
 * running the Civ application.
 *
 * This class should have and display 1. a background 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {

    private Button btn;
    private ListView<CivEnum> listView;

  /**
   * constuctor of the start screen. Should set the background image and
   * display a list of civilizations and a start button
   */
    public StartScreen() {

        Image bgPic = new Image("view/civ_background.png");

        ImageView bPic = new ImageView(bgPic);
        this.getChildren().add(bPic);

        btn = new Button("START!");
        Text message = new Text("Select A Civilization to Begin");
        message.setFont(Font.font(20));
        message.setFill(Color.RED);
        listView = null;
        listView = getCivList();
        VBox vertBox = new VBox(message, listView, btn);
        vertBox.setAlignment(Pos.BOTTOM_CENTER);
        this.getChildren().add(vertBox);
    }

  /**
   * gets the start button
   *
   * @return the start button
   */
    public Button getStartButton() {
        return this.btn;
    }

  /**
   * return a ListView of CivEnums representing the list of available
   * civilizations to choose from
   *
   * @return listview of CivEnum
   */
    public ListView<CivEnum> getCivList() {
        if (listView != null) {
            return listView;
        }
        CivEnum[] enumArray = CivEnum.values();
        ObservableList<CivEnum> oList =
            FXCollections.observableArrayList(enumArray);
        listView = new ListView<>(oList);
        listView.setMaxWidth(200);
        listView.setMaxHeight(85);
        return listView;

    }
}
