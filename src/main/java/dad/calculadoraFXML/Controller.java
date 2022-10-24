package dad.calculadoraFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable {

	Model model = new Model();
	Calculadora calc = new Calculadora();

	@FXML
	private GridPane view;

	@FXML
	private TextField resultText;

	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model.resultadoProperty().bindBidirectional(resultText.textProperty());
		;
	}

	@FXML
	private void onDigitAction(ActionEvent event) {
		Button boton = (Button) event.getSource();
		calc.insertar(boton.getText().charAt(0));
		model.setResultado(calc.getPantalla());
	}

	@FXML
	private void onOperatorAction(ActionEvent event) {
		Button boton = (Button) event.getSource();
		calc.operar(boton.getText().charAt(0));
		model.setResultado(calc.getPantalla());

	}

	@FXML
	private void onComa(ActionEvent event) {
		calc.insertarComa();
		model.setResultado(calc.getPantalla());

	}

	@FXML
	private void onDelete(ActionEvent event) {
		calc.borrar();
		model.setResultado(calc.getPantalla());
		model.setResultado(calc.getPantalla());

	}

	@FXML
	private void onDeleteAll(ActionEvent event) {
		calc.borrarTodo();
		model.setResultado(calc.getPantalla());
		model.setResultado(calc.getPantalla());

	}

	public GridPane getView() {
		return view;
	}

}
