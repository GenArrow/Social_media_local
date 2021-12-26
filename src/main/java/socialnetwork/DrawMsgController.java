package socialnetwork;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import socialnetwork.domain.Utilizator;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class DrawMsgController implements Initializable {
    public static Utilizator current_user;
    @FXML
    public TextArea TextAreaMsg;
    public Button ComposeNewButton;

    static Stage stage;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextAreaMsg.appendText("Here are your last messages preview\n\n\n");
        for(Utilizator u : loginController.utilizatorService.getAll()){
            if(!Objects.equals(u.getId(), current_user.getId())){
            List<String> lst = loginController.mesajService.Conversation_History(current_user.getId(), u.getId());
            if(!lst.isEmpty()){
                String last = lst.get(lst.size()-1);
                TextAreaMsg.appendText(last + "\n\n");}}}}

    public void OnComposeNewButtonClicked(MouseEvent mouseEvent) throws IOException {
        stage.close();
        ComposeMessageController.current_user=current_user;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ComposeMessage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();

    }
}
