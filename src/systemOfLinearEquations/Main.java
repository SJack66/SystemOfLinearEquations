package systemOfLinearEquations;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent layout = FXMLLoader.load(getClass().getResource("guiApp.fxml"));
        primaryStage.setTitle("System of Linear Equations");
        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }
}
