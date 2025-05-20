package view;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.components.PainelBotoes;
import view.components.Sidebar;

public class CadUsuario extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();
        Sidebar sidebar = new Sidebar();

        PainelBotoes painelBotoes = new PainelBotoes();

        mainPane.setLeft(sidebar);

        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/granIcon.PNG"));

        Image imgUserBlack = new Image(getClass().getResourceAsStream("/view/resources/img/userIcon.png"));
        ImageView viewImgUserBlack = new ImageView(imgUserBlack);
        viewImgUserBlack.setFitWidth(20);
        viewImgUserBlack.setFitHeight(20);


        Label lblTitulo = new Label("Cadastro de Usuario");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        HBox tituloBox = new HBox(viewImgUserBlack, lblTitulo);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(10);

        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        txtNome.setMaxWidth(200);

        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        txtEmail.setMaxWidth(200);

        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione");

        Label lblSenha = new Label("Senha: ");
        TextField txtSenha = new TextField();
        txtSenha.setMaxWidth(200);
        Label lblSetor = new Label("Setor: ");
        ComboBox<String> boxSetor = new ComboBox<>();
        boxSetor.getItems().addAll("TI", "Segurança", "Limpeza");
        boxSetor.setPromptText("Selecione");

        GridPane formGrid = new GridPane();
        formGrid.add(painelBotoes,1, 4);
        formGrid.setAlignment(Pos.CENTER);

        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);

        formGrid.add(lblEmail, 0, 1);
        formGrid.add(txtEmail, 1, 1);
        formGrid.add(boxEmail, 2, 1);

        formGrid.add(lblSenha, 0, 2);
        formGrid.add(txtSenha, 1, 2);

        formGrid.add(lblSetor, 0, 3);
        formGrid.add(boxSetor, 1, 3);

        formGrid.setHgap(10);
        formGrid.setVgap(10);


        VBox layout = new VBox(10,tituloBox,formGrid);
        mainPane.setCenter(layout);
        stage.getIcons().add(imgIcon);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainPane, 650, 500);
        stage.setTitle("Cadastro de Usuario");
        stage.setScene(scene);
        stage.show();
    }

    //metodo para criar um campo de texto com mascara
    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) -> {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;
            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    } else {
                        break;
                    }
                } else {
                    formatacaoCampo.append(caracter);
                }
            }
            txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }

    public static void main(String[] args) {
        launch(args);
    }
}