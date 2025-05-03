package br.dev.gustavo_pereira.appTemperatura.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sun.jdi.DoubleValue;

import br.dev.gustavo_pereira.appTemperatura.model.Temperatura;

public class TelaConversor {
	
	private JTextField textCelsius;
	private JLabel labelCelsius;
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
	
	public void criarTelaConversor() {
		JFrame tela = new JFrame();
		tela.setTitle("Conversor de Temperatura");
		tela.setSize(450, 450);
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
		
		
		tela.getContentPane().add(textCelsius);
		tela.getContentPane().add(labelCelsius);
		tela.getContentPane().add(buttonFahreinheit);
		tela.getContentPane().add(buttonKelvin);
		tela.getContentPane().add(labelResultado);
		
		
		buttonFahreinheit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Temperatura temp = new Temperatura();
				String celsius = textCelsius.getText();
				double celsiusdouble = Double.valueOf(celsius);
				temp.setCelsius(celsiusdouble);
				labelResultado.setText(temp.converterParaFahreinheit() +" FAHREINHEIT");
			}
		});
		
		buttonKelvin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Temperatura temp = new Temperatura();
				String celsius = textCelsius.getText();
				double celsiusdouble = Double.valueOf(celsius);
				temp.setCelsius(celsiusdouble);
				labelResultado.setText(temp.converterParaKelvin() +" KELVIN");
				
				
			}
		});
				
		
		
		
		tela.setVisible(true);
	}
}
