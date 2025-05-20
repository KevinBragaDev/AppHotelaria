package view.components;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class sidebarLog extends VBox {
    Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
            "Play-Bold.ttf"), 15);

    public Button btnLogar = new Button("Logar");



    public sidebarLog() {
        String styleButton = "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;" +
                "-fx-graphic-text-gap: 10px;" +
                "-fx-cursor:hand;"; //Setar o cursor de mãozinha para o mouse
        btnLogar.setStyle(styleButton);

        btnLogar.setOnMouseEntered(evento->
                btnLogar.setStyle(styleButton.replace("transparent","#D6C388FF")));
        btnLogar.setOnMouseExited(evento-> btnLogar.setStyle(styleButton));








        Label lblMenu = new Label("");
        lblMenu.setStyle("-fx-text-fill: #365afa;"); //mudar a cor da fonte
        lblMenu.setFont(Font.font(fonteNegrito.getFamily(),25));

        //Espaçamento externo (margem) do componente label até o botão
        setMargin(lblMenu, new Insets(0,    0,      20,     0));
        //margem:       superior,    direita,   inferior,  esquerda


        getChildren().addAll(lblMenu);
    }
}
