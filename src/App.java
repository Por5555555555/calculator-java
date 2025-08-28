import components.ButtonUi;
import logger.LogApp;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class App {

  public static void main(String[] args) {
    LogApp log = new LogApp();
    log.Info("Create gui");

    JFrame frame = new GuiInit(500, 550).init();
    ArrayList<JButton> myBt = new ArrayList<>();

    ButtonUi LayerBt = new ButtonUi(10, 10, 50, 50).setCenter(500, 4);

    // button layer 1
    myBt.add(LayerBt
        .moveXStart()
        .CreateButton(" "));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("/"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("*"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("-"));

    // button layer 2
    myBt.add(LayerBt
        .moveXStart()
        .moveYDown()
        .CreateButton("7"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("8"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("9"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("+", 50, 50 * 2 + 10));

    // button layer 3
    myBt.add(LayerBt
        .moveXStart()
        .moveYDown()
        .CreateButton("4"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("5"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("6"));

    // button layer 4
    myBt.add(LayerBt
        .moveXStart()
        .moveYDown()
        .CreateButton("1"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("2"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("3"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("⏎", 50, 50 * 2 + 10));

    // button layer 5
    myBt.add(LayerBt
        .moveXStart()
        .moveYDown()
        .CreateButton("0", 50 * 2 + 10, 50));
    myBt.add(LayerBt
        .moveXRight()
        .moveXRight()
        .CreateButton("."));

    JPanel box = LayerBt.AddMitlPanel(myBt);
    frame.add(box);
    frame.setVisible(true);
  }
}
