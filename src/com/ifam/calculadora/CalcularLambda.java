package com.ifam.calculadora;

public class CalcularLambda {

	public static double calcular(double a, double b, CalculadoraLambda operador){
		return operador.aplicar(a, b);
	}
	
}
