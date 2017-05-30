package com.ifam.calculadora.view;

import com.ifam.calculadora.CalcularLambda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CalculadoraController {
	
	private String ap ="",num1="",num2="",opAnt = "";
	private double c;
	private double d;
	private double res;
	
	@FXML
	private Label linha1;
	@FXML
	private Label linha2;
	
	@FXML
	private void initialize(){
		this.linha2.setText("");
		this.linha1.setText("0");
	}
	
	@FXML
	private void limpaTela(){
		ap = num1 = num2 = "";
		this.linha2.setText("");
		this.linha1.setText("0");
	}
	
	@FXML
	private void resultadoApresenta(){
		if (!opAnt.equals("")){
			onCodigo("=");
			num2 = "";
			opAnt = "";
		}else if (!linha2.getText().equals("")){
			this.linha1.setText(linha2.getText());
			num1 = ap = linha2.getText();
			this.linha2.setText("");
			num2 = "";
		}	
	}
	
	@FXML
	private void onClick(ActionEvent event){
		String temp = ((Button) event.getSource()).getText();		
		System.out.println(temp);
		onCodigo(temp);
	}
	
	@FXML
	public void onKeyPress(KeyEvent event){
		if(event.getCode().equals(KeyCode.ESCAPE)){
			limpaTela();
		}else if (event.getCode().equals(KeyCode.ENTER)){
			resultadoApresenta();
		}else{
			onCodigo(event.getText());
		}		
	}
	
	public void onCodigo(String temp) {
		switch (temp) {
			case "1":
				concatenaNumero(temp);
				break;
			case "2":
				concatenaNumero(temp);
				break;
			case "3":
				concatenaNumero(temp);
				break;
			case "4":
				concatenaNumero(temp);
				break;
			case "5":
				concatenaNumero(temp);
				break;
			case "6":
				concatenaNumero(temp);
				break;
			case "7":
				concatenaNumero(temp);
				break;
			case "8":
				concatenaNumero(temp);
				break;
			case "9":
				concatenaNumero(temp);
				break;
			case "0":
				concatenaNumero(temp);
				break;
			case ",":
				concatenaNumero(temp);
				break;
			default :
				operacao(temp);
				break;			
		}
		
	}

	private void operacao(String temp) {
		String valor = (opAnt.equals("") ? temp : opAnt);
		switch (valor) {
			case "+":{
				if (realizarCalculo(num1,temp)){
					res = CalcularLambda.calcular(c, d, (a,b)->a+b);
					this.linha2.setText(String.valueOf(res));
					num2 = String.valueOf(res);
				}						
				break;
			}
			case "-":{
				if (realizarCalculo(num1,temp)){
					res = CalcularLambda.calcular(c, d, (a,b)->a-b);
					this.linha2.setText(String.valueOf(res));
					num2 = String.valueOf(res);
				}						
				break;
			}
			case "/":{
				if (realizarCalculo(num1,temp)){
					res = CalcularLambda.calcular(c, d, (a,b)->a/b);
					this.linha2.setText(String.valueOf(res));
					num2 = String.valueOf(res);
				}						
				break;
			}
			case "+/-":{
				double num = Double.parseDouble(num1);
				num1 = String.valueOf(num * -1);
				ap = num1;
				linha1.setText(ap);
				break;
			}
			case "%":
				realizarCalculo(num1, temp);
				break;
			case "*":{
				if (realizarCalculo(num1,temp)){
					res = CalcularLambda.calcular(c, d, (a,b)->a*b);
					this.linha2.setText(String.valueOf(res));
					num2 = String.valueOf(res);
				}						
				break;
			}
			default:{
				
			}
		}
	}

	private void concatenaNumero(String temp) {
		ap += temp;
		linha1.setText(ap);
		if(temp.equals(",")){
			num1 += ".";
		}else{
			num1 += temp;
		}
	}
	
	public boolean realizarCalculo(String num, String op) {
		if(num2.equals("")){
			opAnt = op;
			ap+=op;
			linha1.setText(ap);
			num2 = num;
			num1 = "";
			return false;
		}else{
			opAnt = op;
			c = Double.parseDouble(num2);
			d = Double.parseDouble(num);
			ap+=op;
			linha1.setText(ap);
			num1 = "";
			return true;			
		}
	}
}