package view;

import javafx.scene.control.Spinner;
import javafx.stage.Stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
import view.components.PainelBotoes;
import view.components.Sidebar;

public class CadQuarto extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();
        Sidebar sidebar = new Sidebar();

        PainelBotoes painelBotoes = new PainelBotoes();

        mainPane.setLeft(sidebar);


        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/granIcon.PNG"));
        Image imgUserBlack = new Image(getClass().getResourceAsStream("/view/resources/img/quartoIcon.png"));


        ImageView viewImgUserBlack = new ImageView(imgUserBlack);
        viewImgUserBlack.setFitWidth(20);
        viewImgUserBlack.setFitHeight(20);

        Label lblTitulo = new Label("Cadastro de Quartos");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        HBox tituloBox = new HBox(viewImgUserBlack, lblTitulo);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(10);



        Label lblNome = new Label("Nome:");
        TextField campoNome = new TextField();
        campoNome.setMaxWidth(200);

        Label lblpreco = new Label("Preço:");
        TextField campoPreco = criarMascaraCampo("R$"+ "###.###.##");
        campoPreco.setPromptText("Ex: R$ 000,00");
        campoPreco.setMaxWidth(200);

        Label lblNumero = new Label("Numero:");
        TextField campoNumero = criarMascaraCampo("###");
        campoNumero.setPromptText("Ex: 001");
        campoNumero.setMaxWidth(200);

        Label lblqtdCamaCasal = new Label("Cama de Casal:");
        Spinner<Integer> camaCasal = new Spinner<>(1,2,1);

        Label lblqtdCamaSolteiro = new Label("Cama de Solteiro:");
        Spinner<Integer> camaSolteiro = new Spinner<>(1,2,1);

        Label lblDisponivel = new Label("Disponivel:");
        ComboBox<String> boxDisponivel = new ComboBox<>();
        boxDisponivel.getItems().addAll("Sim", "Nao");
        boxDisponivel.setPromptText("Selecione");

        GridPane formGrid = new GridPane();
        formGrid.add(painelBotoes,1, 6);
        formGrid.setAlignment(Pos.CENTER);

        formGrid.add(lblNome, 0, 0);
        formGrid.add(campoNome, 1, 0);

        formGrid.add(lblpreco, 0, 1);
        formGrid.add(campoPreco, 1, 1);

        formGrid.add(lblNumero, 0, 2);
        formGrid.add(campoNumero, 1, 2);

        formGrid.add(lblqtdCamaCasal, 0, 3);
        formGrid.add(camaCasal, 1, 3);

        formGrid.add(lblqtdCamaSolteiro, 0, 4);
        formGrid.add(camaSolteiro, 1, 4);

        formGrid.add(lblDisponivel, 0, 5);
        formGrid.add(boxDisponivel, 1, 5);

        formGrid.setHgap(10);
        formGrid.setVgap(10);

        VBox layout = new VBox(10, tituloBox,formGrid);
        mainPane.setCenter(layout);
        stage.getIcons().add(imgIcon);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainPane,650, 500);
        stage.setTitle("Cadastro de Quartos");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
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