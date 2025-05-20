package view.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.util.Objects;

public class PainelBotoes extends HBox {
    Image imgBtnCad = new Image(getClass().getResourceAsStream("/view/resources/img/plus48px.png"));
    Image imgBtnUp = new Image(getClass().getResourceAsStream("/view/resources/img/update48px.png"));
    Image imgBtnDel = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/view/resources/img/delete48px.png")));

    public Button btnCadastrar = new Button("Cadastrar");
    public Button btnAtualizar = new Button("Atualizar");
    public Button btnExcluir = new Button("Excluir");

    public PainelBotoes() {
        btnCadastrar.setMaxWidth(125);
        btnCadastrar.setAlignment(Pos.CENTER);
        btnCadastrar.setStyle("-fx-border-color: #00ffd0");

        btnAtualizar.setMaxWidth(125);
        btnAtualizar.setStyle("-fx-border-color: #0010ff");

        btnExcluir.setMaxWidth(125);
        btnExcluir.setStyle("-fx-border-color: #ff0101");

        setSpacing(15);
        setPadding(new Insets(0,0,0,20));



        //Parâmetros para definir como a imagem será visualizada
        ImageView viewImgBtnCad = new ImageView(imgBtnCad);
        viewImgBtnCad.setFitWidth(20); //Definição de largura
        viewImgBtnCad.setFitHeight(20); //Definição de altura
        //viewImgBtnCad.setOpacity(0.5); //Definição de opacidade: 0.0 (invisível) - 1.0 (opaco)

        ImageView viewImgBtnUp = new ImageView(imgBtnUp);
        viewImgBtnUp.setFitWidth(20);
        viewImgBtnUp.setFitHeight(20);
        viewImgBtnUp.setOpacity(0.5);

        ImageView viewImgBtnDel = new ImageView(imgBtnDel);
        viewImgBtnDel.setFitWidth(20);
        viewImgBtnDel.setFitHeight(20);
        viewImgBtnDel.setOpacity(0.5);

        getChildren().addAll(btnCadastrar, btnAtualizar, btnExcluir);
    }

}
