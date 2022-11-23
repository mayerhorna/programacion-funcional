package com.curso.java_avanzado_pruebas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Stream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class PruebaClaseInternaAnonimaEnJavaSwing {
	public static void main(String[] args) {
		JFrame mensajeFrame = new JFrame();
		mensajeFrame.setLayout(new BoxLayout(mensajeFrame.getContentPane(), BoxLayout.Y_AXIS));
		mensajeFrame.setLocationRelativeTo(null);
		JLabel indicacionLbl = new JLabel("Presione el boton para mostrar mensaje");
		JLabel textoDeSalida = new JLabel("[TEXTO SALIDA]");
		JButton mostrarBtn = new JButton("Mostrar Mensaje");
		indicacionLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		textoDeSalida.setAlignmentX(Component.CENTER_ALIGNMENT);
		mostrarBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		mensajeFrame.add(indicacionLbl);
		mensajeFrame.add(mostrarBtn);
		mensajeFrame.add(textoDeSalida);
		mensajeFrame.setSize(300, 200);
		mensajeFrame.setVisible(true);
		
		/*
		class AccionBotonMostrar implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				textoDeSalida.setText("Hola Mundo");
			}
		}
		AccionBotonMostrar accionBotonMostrar = new AccionBotonMostrar();
		mostrarBtn.addActionListener(accionBotonMostrar);
		*/
		
		//Stream.of("a").map(cadena -> new Boolean("")).map(boleano -> new Integer("3")); 
		ActionListener actionListner = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textoDeSalida.setText("Hola Mundo");
			}
		};
		mostrarBtn.addActionListener(actionListner);
		 
		mostrarBtn.addActionListener (
				e ->  textoDeSalida.setText("Hola Mundo")
		);
	}
}
