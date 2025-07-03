package view;

import controller.UsuariosController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Login extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();


        Image imgFundo = new Image(getClass().getResourceAsStream("/view/resources/img/imagem_fundo.jpg"));
        ImageView imgFundoView = new ImageView(imgFundo);
        imgFundoView.setPreserveRatio(true);
        imgFundoView.setFitWidth(500);
        StackPane.setAlignment(imgFundoView, Pos.TOP_LEFT);

        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
                "Play-Bold.ttf"), 15);

        VBox Imagem = new VBox(imgFundoView);
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/granIcon.PNG"));



        Label lblTitulo = new Label("FAÇA SEU LOGIN");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        lblTitulo.setFont(Font.font(fonteNegrito.getFamily(),25));



        Label lblEmail = new Label("E-mail:");
        TextField  campoEmail = new TextField();
        campoEmail.setMaxWidth(200);
        campoEmail.setPromptText("seuemail@mail.com");
        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione");

        Label lblSenha = new Label("Senha:");
        PasswordField campoSenha = new PasswordField();
        TextField campoSenhaVisivel = new TextField();
        campoSenha.setPromptText("**********");
        campoSenhaVisivel.setPromptText("**********");


        campoSenha.setStyle("-fx-padding: 5, 25, 5, 5;");
        campoSenhaVisivel.setStyle("-fx-padding: 5, 25, 5, 5;");

        campoSenha.setMaxWidth(200);
        campoSenhaVisivel.setMaxWidth(200);

        Button btnLogar = new Button("Logar");
        btnLogar.setPrefWidth(150); // Largura
        btnLogar.setPrefHeight(20); // Altura

        String styleButton = "-fx-background-color: transparent;" +
                "-fx-border-color: #006eff;" +
                "-fx-graphic-text-gap: 10px;" +
                "-fx-cursor:hand;"; //Setar o cursor de mãozinha para o mouse
        btnLogar.setStyle(styleButton + "-fx-border-color: #006eff; -fx-font-size: 14px; -fx-padding: 10 20 10 20;");
        btnLogar.setStyle(styleButton);

        btnLogar.setOnMouseEntered(evento->
                btnLogar.setStyle(styleButton.replace("transparent","#365afa")));
        btnLogar.setOnMouseExited(evento-> btnLogar.setStyle(styleButton));

        /* Usuario clica no botão Login para se autenticar com os valores dos campos
        campoEmail e txtSenha (senha visivel) || campoSenha (senha oculta) */
        btnLogar.setOnAction(evento-> {
            String email = campoEmail.getText();
            String senha = campoSenha.isVisible() ? campoSenha.getText() : campoSenhaVisivel.getText();
            UsuariosController usuariosController = new UsuariosController();
            boolean loginSucesso = usuariosController.autenticarCredenciais(email,senha);
            if (loginSucesso) {
                System.out.println("Login efetuado com sucesso!");
            } else {
                System.out.println("Login invalido!");
            }
        });

// Sincronização entre os dois campos
        campoSenhaVisivel.managedProperty().bind(campoSenha.visibleProperty().not());
        campoSenhaVisivel.visibleProperty().bind(campoSenha.visibleProperty().not());
        campoSenhaVisivel.textProperty().bindBidirectional(campoSenha.textProperty());

// Ícone de olho
        Image olhoFechado = new Image(getClass().getResourceAsStream("/view/resources/img/senha.png"));
        Image olhoAberto = new Image(getClass().getResourceAsStream("/view/resources/img/olhoFechado.png"));

        ImageView viewOlhoSenha = new ImageView(olhoFechado);
        viewOlhoSenha.setFitWidth(20);
        viewOlhoSenha.setFitHeight(20);
        viewOlhoSenha.setStyle("-fx-padding: 0 0 20 0;");
        viewOlhoSenha.setCursor(javafx.scene.Cursor.HAND);

// Posiciona o campo e o ícone juntos
        StackPane stackSenha = new StackPane();
        stackSenha.setMaxWidth(200);
        stackSenha.setAlignment(Pos.CENTER_RIGHT);
        stackSenha.getChildren().addAll(campoSenha, campoSenhaVisivel, viewOlhoSenha);

// Evento de clique no olho (toggle)
        viewOlhoSenha.setOnMouseClicked(event -> {
            boolean senhaVisivel = !campoSenha.isVisible();
            campoSenha.setVisible(senhaVisivel);
            viewOlhoSenha.setImage(senhaVisivel ? olhoFechado : olhoAberto);
        });



        //GridPane formGrid = new GridPane();
        //formGrid.setHgap(10);  // Espaçamento horizontal entre as colunas
        //formGrid.setVgap(5);   // Espaçamento vertical entre as linhas
        //formGrid.setAlignment(Pos.CENTER_LEFT);

        HBox tituloHBox = new HBox(lblTitulo);
        tituloHBox.setAlignment(Pos.CENTER);
        tituloHBox.setPrefWidth(Double.MAX_VALUE); // Faz com que ocupe toda a largura disponível


        //formGrid.add(tituloHBox, 0, 0, 2, 1); // span de 2 colunas para centralizar melhor

        //formGrid.add(lblTitulo, 0, 0);

        //formGrid.add(lblEmail,0,2);
        //formGrid.add(campoEmail, 1, 2);

        //formGrid.add(lblSenha, 0, 3);
        //formGrid.add(stackSenha, 1, 3);
        //formGrid.add(boxEmail, 2, 1);

        HBox emailBox = new HBox(10, lblEmail, campoEmail);  // Coloca a label e o campo juntos em um HBox
        emailBox.setAlignment(Pos.CENTER);

        HBox senhaBox = new HBox(10, lblSenha, stackSenha);  // Coloca a label e o campo de senha juntos em um HBox
        senhaBox.setAlignment(Pos.CENTER);

        HBox botaoBox = new HBox(btnLogar);
        botaoBox.setAlignment(Pos.CENTER);

        GridPane.setHalignment(btnLogar, Pos.CENTER.getHpos());

        GridPane.setMargin(lblEmail, new Insets(0, 10, 0, 0));  // Ajuste da margem à direita da label
        GridPane.setMargin(campoEmail, new Insets(0, 0, 0, 10));  // Sem margem no campo de email

        GridPane.setMargin(lblSenha, new Insets(0, 10, 0, 0));  // Ajuste da margem à direita da label
        GridPane.setMargin(stackSenha, new Insets(0, 0, 0, 10));  // Sem margem no campo de senha

        VBox formBox = new VBox(15, tituloHBox, emailBox, senhaBox, botaoBox);
        formBox.setAlignment(Pos.CENTER);
        formBox.setPrefWidth(400);


        VBox layout = new VBox(formBox);
        layout.setAlignment(Pos.CENTER);
        layout.setPrefWidth(400);

        HBox tituloBox = new HBox(Imagem,layout);
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(10);



        mainPane.setCenter(tituloBox);
        stage.getIcons().add(imgIcon);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainPane, 830, 650);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

