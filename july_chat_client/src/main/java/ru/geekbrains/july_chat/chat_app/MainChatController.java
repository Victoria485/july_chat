package ru.geekbrains.july_chat.chat_app;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class MainChatController implements Initializable {
    public VBox mainChatPanel;
    public TextArea mainChatArea;
    public ListView<String> contactList;
    public TextField inputField;
    public Button btnSendMessage;

    public void mockAction(ActionEvent actionEvent) {

    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void sendMessage(ActionEvent actionEvent) {
        String text = inputField.getText();
        if (text.isEmpty()) return;
        text = contactList.getSelectionModel().getSelectedItem() + ": " + text;
        mainChatArea.appendText(text + "\n");
        inputField.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        List<String> contacts = Arrays.asList("Vasya", "Petya", "Masha", "Kolya", "Sergey");
        ObservableList<String> list = FXCollections.observableArrayList("Vasya", "Petya", "Masha", "Kolya", "Sergey");
        contactList.setItems(list);
    }
}