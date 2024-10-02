import java.text.NumberFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class calculadoraSBController {

    @FXML
    private RadioButton btnDividir;

    @FXML
    private RadioButton btnMultiplicar;

    @FXML
    private Button btnOperar;

    @FXML
    private RadioButton btnRestar;

    @FXML
    private RadioButton btnSumar;

    @FXML
    private Label calculadora;

    @FXML
    private Label numero1;

    @FXML
    private Label numero2;

    @FXML
    private Label resultado;

    @FXML
    private TextField textoNumero1;

    @FXML
    private TextField textoNumero2;

    @FXML
    private TextField textoResultado;

    @FXML
    void operar(ActionEvent event) {
        //creamos un grupo
        ToggleGroup tg = new ToggleGroup();
        //añadimos los botones al grupo
        this.btnSumar.setToggleGroup(tg);
        this.btnRestar.setToggleGroup(tg);
        this.btnDividir.setToggleGroup(tg);;
        this.btnMultiplicar.setToggleGroup(tg);
    } 
    @FXML
    void sumar(ActionEvent event) {
        //hacemos que "numero1" y "numero2" obtengan sus valores de sus respectivos cuadros de texto.
        try {
            int numero1 = Integer.parseInt(this.textoNumero1.getText());
            int numero2 = Integer.parseInt(this.textoNumero2.getText());

            operaciones s = new operaciones(numero1, numero2);

            int resultado = s.suma();

            if (this.btnSumar.isSelected()) {
                this.textoResultado.setText(resultado + ""); 
            }
        //hacemos que, al sumar, el programa solo acepte números.
        } catch (NumberFormatException e) {
            //creamos la clase alert con el tipo ERROR
            Alert alert = new Alert (Alert.AlertType.ERROR);
            //creamos una cabecera sin contenido
            alert.setHeaderText(null);
            //le ponemos el titulo a la alerta
            alert.setTitle("Error");
            //añadimos el contenido de la alerta
            alert.setContentText("Formato incorrecto");
        }
    }
    @FXML
    void dividir(ActionEvent event) {
        try {
            int numero1 = Integer.parseInt(this.textoNumero1.getText());
            int numero2 = Integer.parseInt(this.textoNumero2.getText());

            operaciones d = new operaciones(numero1, numero2);
            double resultado = d.cociente();

            if (numero2 == 0) {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El divisor no puede ser 0");
            } else if (this.btnDividir.isSelected()) {
                this.textoResultado.setText(resultado + ""); 
            }  
        } catch (NumberFormatException e) {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
        }
    }

    @FXML
    void multiplicar(ActionEvent event) {
                try {
                    int numero1 = Integer.parseInt(this.textoNumero1.getText());
                    int numero2 = Integer.parseInt(this.textoNumero2.getText());
        
                    operaciones m = new operaciones(numero1, numero2);
        
                    int resultado = m.producto();
                    
                    if (this.btnMultiplicar.isSelected()) {
                        this.textoResultado.setText(resultado + ""); 
                    }


                } catch (NumberFormatException e) {
                    Alert alert = new Alert (Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Formato incorrecto");
                }
    }
    @FXML
    void restar(ActionEvent event) {
        try {
            int numero1 = Integer.parseInt(this.textoNumero1.getText());
            int numero2 = Integer.parseInt(this.textoNumero2.getText());

            operaciones r = new operaciones(numero1, numero2);

            int resultado = r.resta();

            if (this.btnRestar.isSelected()) {
                this.textoResultado.setText(resultado + ""); 
            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
        }
    }
}

