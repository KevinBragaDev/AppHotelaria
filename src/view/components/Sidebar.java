package view.components;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Sidebar extends VBox {
    Image iconCliente = new Image(getClass().getResourceAsStream("/view/resources/img/icon-cliente.png"));
    Image iconFuncionario = new Image(getClass().getResourceAsStream("/view/resources/img/icon-funcionario.png"));
    Image iconQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/icon-quarto.png"));
    Image iconRelatorio = new Image(getClass().getResourceAsStream("/view/resources/img/icon-relatorio.png"));
    Image iconReserva = new Image(getClass().getResourceAsStream("/view/resources/img/icon-reserva.png"));

    //carregamento de fonte

    Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
            "Play-Regular.ttf"), 14);

    Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
            "Play-Bold.ttf"), 15);


    public Button btnCliente = new Button("Cliente");
    public Button btnFuncionario = new Button("Funcionario");
    public Button btnQuarto = new Button("Quarto");
    public Button btnReserva = new Button("Reserva");
    public Button btnRelatorio = new Button("Relatorio");

    public Sidebar() {
        //Estilização dos botões (fundo e borda transparentes)

        String styleButton = "-fx-background-color: transparent;" +
                             "-fx-border-color: transparent;" +
                             "-fx-graphic-text-gap: 10px;" +
                             "-fx-cursor:hand;"; //Setar o cursor de mãozinha para o mouse
        btnCliente.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);

        //Objetivo: ao passar o mouse, trocar o fundo do botão para uma cor que desejar

        btnCliente.setOnMouseEntered(evento->
                btnCliente.setStyle(styleButton.replace("transparent","#D6C388FF")));
        btnCliente.setOnMouseExited(evento-> btnCliente.setStyle(styleButton));


        btnFuncionario.setOnMouseEntered(evento->
                btnFuncionario.setStyle(styleButton.replace("transparent","#D6C388FF")));
        btnFuncionario.setOnMouseExited(evento-> btnFuncionario.setStyle(styleButton));


        btnQuarto.setOnMouseEntered(evento->
                btnQuarto.setStyle(styleButton.replace("transparent","#D6C388FF")));
        btnQuarto.setOnMouseExited(evento-> btnQuarto.setStyle(styleButton));


        btnReserva.setOnMouseEntered(evento->
                btnReserva.setStyle(styleButton.replace("transparent","#D6C388FF")));
        btnReserva.setOnMouseExited(evento-> btnReserva.setStyle(styleButton));


        btnRelatorio.setOnMouseEntered(evento->
                btnRelatorio.setStyle(styleButton.replace("transparent","#D6C388FF")));
        btnRelatorio.setOnMouseExited(evento-> btnRelatorio.setStyle(styleButton));

        ImageView viewIconCliente = new ImageView(iconCliente);
        viewIconCliente.setFitHeight(30);//altura
        viewIconCliente.setFitWidth(30);//largura

        ImageView viewIconFuncionaria = new ImageView(iconFuncionario);
        viewIconFuncionaria.setFitHeight(30);
        viewIconFuncionaria.setFitWidth(30);

        ImageView viewIconQuarto = new ImageView(iconQuarto);
        viewIconQuarto.setFitHeight(30);
        viewIconQuarto.setFitWidth(30);

        ImageView viewIconReserva = new ImageView(iconReserva);
        viewIconReserva.setFitHeight(30);
        viewIconReserva.setFitWidth(30);

        ImageView viewRelatorio = new ImageView(iconRelatorio);
        viewRelatorio.setFitHeight(30);
        viewRelatorio.setFitWidth(30);

        btnCliente.setGraphic(viewIconCliente);
        btnFuncionario.setGraphic(viewIconFuncionaria);
        btnQuarto.setGraphic(viewIconQuarto);
        btnReserva.setGraphic(viewIconReserva);
        btnRelatorio.setGraphic(viewRelatorio);

        setSpacing(15);
        setPadding(new Insets(20));

        Label lblMenu = new Label("Grand Hotel");
        lblMenu.setStyle("-fx-text-fill: #9e9244;"); //mudar a cor da fonte
        lblMenu.setFont(Font.font(fonteNegrito.getFamily(),25));

        //Espaçamento externo (margem) do componente label até o botão
        setMargin(lblMenu, new Insets(0,    0,      20,     0));
                    //margem:       superior,    direita,   inferior,  esquerda



        setStyle("-fx-background-color: #9e9244; -fx-padding: 40px;");
        getChildren().addAll(lblMenu, btnCliente, btnFuncionario, btnQuarto, btnReserva, btnRelatorio);
    }
}
