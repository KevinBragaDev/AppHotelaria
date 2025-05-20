package view; //Package view (classes que, quando executadas, interagem com o usuário)

import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; //Classe VBox: é um dos tipos de layouts
import javafx.stage.Stage; //Classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.components.PainelBotoes;
import view.components.Sidebar;

import java.util.Objects;

public class CadCliente extends Application {
    @Override
    public void start(Stage janela) throws Exception {

        BorderPane mainPane = new BorderPane();
        Sidebar sidebar = new Sidebar();
        PainelBotoes botoes = new PainelBotoes();

        mainPane.setLeft(sidebar);

        //Carregar imagens
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/IbisLogo.png"));

        Image imgUserBlack = new Image(getClass().getResourceAsStream("/view/resources/img/userIcon.png"));



        ImageView viewImgUserBlack = new ImageView(imgUserBlack);
        viewImgUserBlack.setFitWidth(20);
        viewImgUserBlack.setFitHeight(20);


        Label lblTitulo = new Label("Cadastro de Cliente");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        HBox tituloBox = new HBox(viewImgUserBlack, lblTitulo);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(10);


        //tituloBox.setStyle("-fx-background-color: #ff0000;-fx-border-color:#fffff");


        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        txtNome.setMaxWidth(200);
        txtNome.setStyle("-fx-border-color: #006eff");

        Label lblCPF = new Label("CPF: ");
        TextField txtCPF = criarMascaraCampo("###.###.###-##");
        txtCPF.setMaxWidth(200);
        txtCPF.setStyle("-fx-border-color: #006eff");
        txtCPF.setPromptText("___.___.___-__");

        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        txtEmail.setMaxWidth(200);
        txtEmail.setStyle("-fx-border-color: #006eff");

        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione");


        Label lblTel = new Label("Telefone: ");
        TextField txtTel = criarMascaraCampo("(##) #####-####");
        txtTel.setMaxWidth(200);
        txtTel.setStyle("-fx-border-color: #006eff");
        txtTel.setPromptText("(__) _____-____");


        GridPane formGrid = new GridPane();
        formGrid.add(botoes,1, 4);
        formGrid.setAlignment(Pos.CENTER);
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblCPF, 0, 1);
        formGrid.add(txtCPF, 1, 1);
        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(boxEmail, 2, 2);
        formGrid.add(lblTel, 0, 3);
        formGrid.add(txtTel, 1, 3);

        formGrid.setHgap(10);
        formGrid.setVgap(10);

        //formGrid.setMargin(lblNome, new Insets(5, 00, 00, 00));
        //formGrid.setMargin(txtNome, new Insets(5, 00, 00, 00));
        //formGrid.setMargin(lblCPF, new Insets(5, 00, 00, 00));
        //formGrid.setMargin(txtCPF, new Insets(5, 00, 00, 00));
        //formGrid.setMargin(lblEmail, new Insets(5, 00, 00, 00));
        //formGrid.setMargin(txtEmail, new Insets(5, 00, 00, 00));
        //formGrid.setMargin(lblTel, new Insets(5, 00, 00, 00));
        //formGrid.setMargin(txtTel, new Insets(5, 00, 00, 00));




        VBox layout = new VBox(10, tituloBox, formGrid);
        mainPane.setCenter(layout);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainPane, 650, 500);
        janela.setTitle("Cadastro de Cliente");

        //Colocar um icone na janela (stage) -> icone da empresa/marca
        janela.getIcons().add(imgIcon);
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
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
        launch(args); //Inicializa o JAVAFX (aplicação)
    }
}
