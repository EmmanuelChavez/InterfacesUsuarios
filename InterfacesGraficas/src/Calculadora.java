import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Label;
import java.awt.Color;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JButton button = new JButton("<---");
	JButton btnC = new JButton("C");
	JButton btnNewButton = new JButton("+");
	JButton button_1 = new JButton("7");
	JButton button_2 = new JButton("8");
	JButton button_3 = new JButton("9");
	JButton button_4 = new JButton("-");
	JButton button_5 = new JButton("4");
	JButton button_6 = new JButton("1");
	JButton button_7 = new JButton("0");
	JButton button_8 = new JButton("5");
	JButton button_9 = new JButton("6");
	JButton btnX = new JButton("x");
	JButton button_11 = new JButton("2");
	JButton button_12 = new JButton("3");
	JButton button_13 = new JButton("\u00F7");
	JButton button_14 = new JButton(".");
	JButton button_15 = new JButton("=");
	JRadioButton rdbtnOn = new JRadioButton("ON");
	JRadioButton rdbtnOff = new JRadioButton("OFF");
	Label label = new Label("");
	
	public double numero,respuesta;
	public int calculo;
	private final JButton btnRaizCuadrada = new JButton("Raiz Cuadrada");
	private final JButton btnNewButton_1 = new JButton("^2");
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		setType(Type.UTILITY);
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Arial", Font.BOLD, 22));
		textField.setBounds(26, 28, 298, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//JRadioButton rdbtnOn = new JRadioButton("ON");
		rdbtnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitar();
			}
		});
		buttonGroup.add(rdbtnOn);
		rdbtnOn.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnOn.setBounds(30, 90, 49, 23);
		rdbtnOn.setEnabled(false);
		contentPane.add(rdbtnOn);
		
		//JRadioButton rdbtnOff = new JRadioButton("OFF");
		rdbtnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deshabilitar();
			}
		});
		buttonGroup.add(rdbtnOff);
		rdbtnOff.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnOff.setBounds(30, 116, 49, 23);
		contentPane.add(rdbtnOff);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int largo = textField.getText().length();
				int numero = textField.getText().length()-1;
				String almacenar;
				if(largo>0){
					StringBuilder back=new StringBuilder(textField.getText());
					back.deleteCharAt(numero);
					almacenar=back.toString();
					textField.setText(almacenar);
				}
			}
		});
		
		//JButton button = new JButton("<---");
		button.setFont(new Font("Arial", Font.PLAIN, 22));
		button.setBounds(103, 90, 67, 34);
		contentPane.add(button);
		
		//JButton btnC = new JButton("C");
		btnC.setFont(new Font("Arial", Font.BOLD, 22));
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnC.setBounds(180, 90, 67, 34);
		contentPane.add(btnC);
		
		//JButton btnNewButton = new JButton("+");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//textField.setText(textField.getText()+"+");
				numero=Double.parseDouble(textField.getText());
				calculo=1;
				textField.setText("");
				label.setText(numero+" +");
			}
		});
		btnNewButton.setBounds(257, 90, 67, 34);
		contentPane.add(btnNewButton);
		
		//JButton button_1 = new JButton("7");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"7");
			}
		});
		button_1.setFont(new Font("Arial", Font.BOLD, 22));
		button_1.setBounds(26, 157, 67, 34);
		contentPane.add(button_1);
		
		//JButton button_2 = new JButton("8");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"8");
			}
		});
		button_2.setFont(new Font("Arial", Font.BOLD, 22));
		button_2.setBounds(103, 157, 67, 34);
		contentPane.add(button_2);
		
		//JButton button_3 = new JButton("9");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"9");
			}
		});
		button_3.setFont(new Font("Arial", Font.BOLD, 22));
		button_3.setBounds(180, 157, 67, 34);
		contentPane.add(button_3);
		
		//JButton button_4 = new JButton("-");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField.setText(textField.getText()+"-");
				numero=Double.parseDouble(textField.getText());
				calculo=2;
				textField.setText("");
				label.setText(numero+" -");
			}
		});
		button_4.setFont(new Font("Arial", Font.BOLD, 22));
		button_4.setBounds(257, 157, 67, 34);
		contentPane.add(button_4);
		
		//JButton button_5 = new JButton("4");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"4");
			}
		});
		button_5.setFont(new Font("Arial", Font.BOLD, 22));
		button_5.setBounds(26, 212, 67, 34);
		contentPane.add(button_5);
		
		//JButton button_6 = new JButton("1");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"1");
			}
		});
		button_6.setFont(new Font("Arial", Font.BOLD, 22));
		button_6.setBounds(26, 268, 67, 34);
		contentPane.add(button_6);
		
		//JButton button_7 = new JButton("0");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"0");
			}
		});
		button_7.setFont(new Font("Arial", Font.BOLD, 22));
		button_7.setBounds(26, 324, 67, 34);
		contentPane.add(button_7);
		
		//JButton button_8 = new JButton("5");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"5");
			}
		});
		button_8.setFont(new Font("Arial", Font.BOLD, 22));
		button_8.setBounds(103, 212, 67, 34);
		contentPane.add(button_8);
		
		//JButton button_9 = new JButton("6");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"6");
			}
		});
		button_9.setFont(new Font("Arial", Font.BOLD, 22));
		button_9.setBounds(180, 212, 67, 34);
		contentPane.add(button_9);
		
		//JButton btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField.setText(textField.getText()+"x");
				numero=Double.parseDouble(textField.getText());
				calculo=3;
				textField.setText("");
				label.setText(numero+" x");
			}
		});
		btnX.setFont(new Font("Arial", Font.BOLD, 22));
		btnX.setBounds(257, 212, 67, 34);
		contentPane.add(btnX);
		
		//JButton button_11 = new JButton("2");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"2");
			}
		});
		button_11.setFont(new Font("Arial", Font.BOLD, 22));
		button_11.setBounds(103, 268, 67, 34);
		contentPane.add(button_11);
		
		//JButton button_12 = new JButton("3");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"3");
			}
		});
		button_12.setFont(new Font("Arial", Font.BOLD, 22));
		button_12.setBounds(180, 268, 67, 34);
		contentPane.add(button_12);
		
		//JButton button_13 = new JButton("\u00F7");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField.setText(textField.getText()+"÷");
				numero=Double.parseDouble(textField.getText());
				calculo=4;
				textField.setText("");
				label.setText(numero+" ÷");
			}
		});
		button_13.setFont(new Font("Arial", Font.BOLD, 22));
		button_13.setBounds(257, 268, 67, 34);
		contentPane.add(button_13);
		
		//JButton button_14 = new JButton(".");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+".");
			}
		});
		button_14.setFont(new Font("Arial", Font.BOLD, 22));
		button_14.setBounds(103, 324, 67, 34);
		contentPane.add(button_14);
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacion_aritmetica();
				label.setText("");
			}
		});
		
		//JButton button_15 = new JButton("=");
		button_15.setFont(new Font("Arial", Font.BOLD, 22));
		button_15.setBounds(180, 324, 144, 34);
		contentPane.add(button_15);
		btnRaizCuadrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero=Double.parseDouble(textField.getText());
				calculo=5;
				textField.setText("");
				label.setText(numero+" ^0.5");
			}
		});
		btnRaizCuadrada.setFont(new Font("Arial", Font.BOLD, 22));
		btnRaizCuadrada.setBounds(143, 379, 181, 34);
		
		contentPane.add(btnRaizCuadrada);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 22));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero=Double.parseDouble(textField.getText());
				calculo=6;
				textField.setText("");
				label.setText(numero+" ^2");
			}
		});
		btnNewButton_1.setBounds(26, 379, 67, 34);
		
		contentPane.add(btnNewButton_1);
		
		//Label label = new Label("");
		label.setAlignment(Label.RIGHT);
		label.setForeground(Color.RED);
		label.setBounds(257, 0, 62, 22);
		contentPane.add(label);
	}
	
	public void operacion_aritmetica(){
		switch(calculo){
		case 1:
			respuesta=numero+Double.parseDouble(textField.getText());
			textField.setText(Double.toString(respuesta));
			break;
		case 2:
			respuesta=numero-Double.parseDouble(textField.getText());
			textField.setText(Double.toString(respuesta));
			break;
		case 3:
			respuesta=numero*Double.parseDouble(textField.getText());
			textField.setText(Double.toString(respuesta));
			break;
		case 4:
			respuesta=numero/Double.parseDouble(textField.getText());
			textField.setText(Double.toString(respuesta));
			break;
		case 5:
			//respuesta=Math.sqrt(Double.parseDouble(textField.getText()));
			respuesta=Math.sqrt(numero);
			textField.setText(Double.toString(respuesta));
			break;
		case 6:
			//respuesta=Math.sqrt(Double.parseDouble(textField.getText()));
			respuesta=numero*numero;
			textField.setText(Double.toString(respuesta));
			break;
		}
	}
	
	public void habilitar(){
		textField.setEnabled(true);
		rdbtnOff.setEnabled(true);
		rdbtnOn.setEnabled(false);
		button_1.setEnabled(true);
		button_2.setEnabled(true);
		button_3.setEnabled(true);
		button_4.setEnabled(true);
		button_5.setEnabled(true);
		button_6.setEnabled(true);
		button_7.setEnabled(true);
		button_8.setEnabled(true);
		button_9.setEnabled(true);
		btnX.setEnabled(true);
		button_11.setEnabled(true);
		button_12.setEnabled(true);
		button_13.setEnabled(true);
		button_14.setEnabled(true);
		button_15.setEnabled(true);
		button.setEnabled(true);
		btnC.setEnabled(true);
		btnNewButton.setEnabled(true);
		btnRaizCuadrada.setEnabled(true);
		btnNewButton_1.setEnabled(true);
	}
	
	public void deshabilitar(){
		textField.setEnabled(false);
		rdbtnOff.setEnabled(false);
		rdbtnOn.setEnabled(true);
		button_1.setEnabled(false);
		button_2.setEnabled(false);
		button_3.setEnabled(false);
		button_4.setEnabled(false);
		button_5.setEnabled(false);
		button_6.setEnabled(false);
		button_7.setEnabled(false);
		button_8.setEnabled(false);
		button_9.setEnabled(false);
		btnX.setEnabled(false);
		button_11.setEnabled(false);
		button_12.setEnabled(false);
		button_13.setEnabled(false);
		button_14.setEnabled(false);
		button_15.setEnabled(false);
		button.setEnabled(false);
		btnC.setEnabled(false);
		btnNewButton.setEnabled(false);
		btnRaizCuadrada.setEnabled(false);
		btnNewButton_1.setEnabled(false);
	}
}
