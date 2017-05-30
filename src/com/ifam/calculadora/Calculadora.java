package com.ifam.calculadora;

import java.io.IOException;

import com.ifam.calculadora.view.CalculadoraController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Calculadora extends Application{
	
	private Stage principalScane;
	private AnchorPane panel;
	private CalculadoraController controller;
	
	
	@Override
	public void start(Stage primaryStage){
		this.principalScane = primaryStage;
		this.principalScane.initStyle(StageStyle.UNDECORATED);
		this.principalScane.getIcons().add(new Image("file:resources/images/calculadora.png"));
		
		showCalculadora();
	}

	private void showCalculadora() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/CalculadoraView.fxml"));
			panel = (AnchorPane) loader.load();
			
			controller = new CalculadoraController();
			//controlle.setCalculadora(this);
			
			Scene scene = new Scene(panel);
			this.principalScane.setScene(scene);
			this.principalScane.show();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
