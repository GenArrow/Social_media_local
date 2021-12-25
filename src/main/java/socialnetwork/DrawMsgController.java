package socialnetwork;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import socialnetwork.domain.Utilizator;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class DrawMsgController implements Initializable {
    public static Utilizator current_user;
    @FXML
    public TextArea TextAreaMsg;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextAreaMsg.appendText("Here are your last messages preview\n\n\n");
        for(Utilizator u : loginController.utilizatorService.getAll()){
            if(!Objects.equals(u.getId(), current_user.getId())){
            List<String> lst = loginController.mesajService.Conversation_History(current_user.getId(), u.getId());
            if(!lst.isEmpty()){
                String last = lst.get(lst.size()-1);
                TextAreaMsg.appendText(last + "\n\n");}}}}

}
