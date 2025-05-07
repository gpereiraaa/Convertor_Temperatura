package br.dev.gustavo_pereira.appTemperatura.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import br.dev.gustavo_pereira.appTemperatura.model.Temperatura;

public class TelaConversor {
	
	private JTextField textCelsius;
	private JLabel labelCelsius;
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
	
	
	//Responsável por criar a tela, definir tamanho, definir titulo
	public void criarTelaConversor() {
		JFrame tela = new JFrame();
		tela.setTitle("Conversor de Temperatura");
		tela.setSize(450, 350);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setResizable(false);
		

		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus celsius: ");
		labelCelsius.setBounds(20, 30, 200, 60);
	
		textCelsius = new JTextField();
		textCelsius.setText(null);
		textCelsius.setBounds(20, 70, 400, 40);
		
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("FAHREINHEIT");
		buttonFahreinheit.setBounds(20, 120, 200, 40);
		
		buttonKelvin = new JButton();
		buttonKelvin.setText("KELVIN");
		buttonKelvin.setBounds(220, 120, 200, 40);
		
		labelResultado = new JLabel();
		labelResultado.setBounds(150, 170, 400, 60);
		labelResultado.setVisible(false);
		
		labelMensagemErro = new JLabel();
		labelMensagemErro.setBounds(30, 170, 400, 60);
		labelMensagemErro.setForeground(Color.RED);
		Font fonteMensagemErro = new Font( "Serif", Font.PLAIN, 16);
		labelMensagemErro.setFont(fonteMensagemErro);
		labelMensagemErro.setVisible(false);
		
		
		//Serve para adicionar todos os metodos definidos anteriormente na tela
		tela.getContentPane().add(textCelsius);
		tela.getContentPane().add(labelCelsius);
		tela.getContentPane().add(buttonFahreinheit);
		tela.getContentPane().add(buttonKelvin);
		tela.getContentPane().add(labelResultado);
		tela.getContentPane().add(labelMensagemErro);
		
		
		
		
		
		
		//Responsável por pegar o valor digitado pelo usuário, converter para um valor double e assim chamar a classe responsável por converter a temperatura para FAHREINHEIT e após isso exibir na tela o valor convertido
		buttonFahreinheit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//A condição try serve para se a operação for executada com sucesso ela deverá exibir a conversão do valor em Celsius para Fahreinheit
				try {
					labelMensagemErro.setText(null);
					labelResultado.setVisible(true);
					Temperatura temp = new Temperatura();
					String celsius = textCelsius.getText();
					double celsiusdouble = Double.valueOf(celsius);
					temp.setCelsius(celsiusdouble);
					double fahreinheit = temp.converterParaFahreinheit();
					//Faz com que o valor convertido apareça como um valor decimal
					DecimalFormat decimal = new DecimalFormat("0.00");
					String valorFormatado = decimal.format(fahreinheit);
					labelResultado.setText(valorFormatado +" FAHREINHEIT");
					
					
				}
				//A condição catch serve para que se a condição try não obtiver sucesso ela automaticamente exiba a mensagem de que o valor digitado não é válido
				catch(Exception ex) {
					labelResultado.setText(null);
					labelMensagemErro.setVisible(true);
					labelMensagemErro.setText("Você forneceu um valor não válido, forneça apenas números");
				}
				
				
			}
		});
		
		
		//Responsável por pegar o valor digitado pelo usuário, converter para um valor double e assim chamar a classe responsável por converter a temperatura para CELSIUS e após isso exibir na tela o valor convertido
		buttonKelvin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//A condição try serve para se a operação for executada com sucesso ela deverá exibir a conversão do valor em Celsius para Kelvin
				try {
					labelMensagemErro.setText(null);
					labelResultado.setVisible(true);
					Temperatura temp = new Temperatura();
					String celsius = textCelsius.getText();
					double celsiusdouble = Double.valueOf(celsius);
					temp.setCelsius(celsiusdouble);
					double kelvin = temp.converterParaKelvin();
					//Faz com que o valor convertido apareça como um valor decimal
					DecimalFormat decimal = new DecimalFormat("0.00");
					String valorFormatado = decimal.format(kelvin);
					labelResultado.setText(valorFormatado +" KELVIN");
				}
				
				//A condição catch serve para que se a condição try não obtiver sucesso ela automaticamente exiba a mensagem de que o valor digitado não é válido
				catch (Exception ex) {
					labelResultado.setText(null);
					labelMensagemErro.setVisible(true);
					labelMensagemErro.setText("Você forneceu um valor não válido, forneça apenas números");
				}
				
				
				
			}
		});
				
		
		
		//Serve para que a tela seja visualizada
		tela.setVisible(true);
	}
}
