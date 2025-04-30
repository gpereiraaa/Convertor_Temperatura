package br.dev.gustavo_pereira.appTemperatura.model;

public class Temperatura {
	private double celsius;
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	public double getCelsius() {
		return celsius;
	}
	
	public double converterParaKelvin() {
		double kelvin = celsius + 273;
		return kelvin;
	}
	
	public double converterParaFahreinheit() {
		double fahreinheit = celsius * 1.8 + 32;
		return fahreinheit;
	}
	
	
	
	
	
}
