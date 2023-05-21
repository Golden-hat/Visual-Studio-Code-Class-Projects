import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/mainScreen.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("StringList-yjpellam@alumno.upv.es");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        String css = this.getClass().getResource("/style/style.css") .toExternalForm();
        scene.getStylesheets().add(css);
    }
}
