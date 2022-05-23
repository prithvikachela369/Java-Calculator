import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.TextField;
import java.awt.TextArea;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Canvas;

public class Calculator {

	private JFrame frmStandardCalculator;
	private JTextField textField;
	private JTextField textField_1;
	double firstnum;
	double secondnum;
	double result;
	String operations;
	String answer;
	
	
	
	
    double US_Dollar = 0.013;
    double Japanese_Yen = 0.70;
    double Pound_Sterling = 0.010205;
    double Indonesian_Rupiah = 194.877863;
    double Swedish_krona = 0.1164;
    double Croatian_kuna = 0.0844;
    double Russian_rouble =0.983568 ;
    double Australian_Dollar  = 0.018;
    double Brazilian_real = 0.070922;
    double Canadian_Dollar = 0.017;
    double Israeli_shekel = 0.045544;
    double Mexican_peso = 0.301;
    private JTextField textField_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmStandardCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStandardCalculator = new JFrame();
		frmStandardCalculator.setTitle("Standard Calculator");
		frmStandardCalculator.setBounds(100, 100, 882, 425);
		frmStandardCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar Type = new JMenuBar();
		frmStandardCalculator.setJMenuBar(Type);
		
		JMenu mnNewMenu = new JMenu("Type");
		Type.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Standard");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStandardCalculator.setTitle("Standard Calculator");
				frmStandardCalculator.setBounds(100, 100, 315, 425);
				textField.setBounds(10, 11, 275, 37);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Scientific");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStandardCalculator.setTitle("Scientific Calculator");
				frmStandardCalculator.setBounds(100, 100, 597, 425);
				textField.setBounds(10, 11, 494, 37);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Unit Conversion");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStandardCalculator.setTitle("Unit Conversion");
				frmStandardCalculator.setBounds(100, 100, 885, 400);
				textField.setBounds(10, 11, 243, 37);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		frmStandardCalculator.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 285, 35);
		frmStandardCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backspace = null;
				
				if(textField.getText().length() > 0) {
					StringBuilder strb = new StringBuilder(textField.getText());
					strb.deleteCharAt(textField.getText().length()-1);
					backspace = strb.toString();
					textField.setText(backspace);
				}
			}
		});
		btnNewButton.setBounds(10, 57, 49, 45);
		frmStandardCalculator.getContentPane().add(btnNewButton);
		
		JButton button_1 = new JButton("CE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		button_1.setBounds(69, 57, 49, 45);
		frmStandardCalculator.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		button_2.setBounds(128, 57, 49, 45);
		frmStandardCalculator.getContentPane().add(button_2);
		
		JButton button = new JButton("\u00B1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = ops * (-1);
				textField.setText(String.valueOf(ops));
			}
		});
		button.setBounds(187, 57, 49, 45);
		frmStandardCalculator.getContentPane().add(button);
		
		JButton button_3 = new JButton("\u221A");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = Math.sqrt(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		button_3.setBounds(235, 57, 60, 45);
		frmStandardCalculator.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("%");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "%";
			}
		});
		button_4.setBounds(235, 113, 60, 45);
		frmStandardCalculator.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("/");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "/";
			}
		});
		button_5.setBounds(187, 113, 49, 45);
		frmStandardCalculator.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("9");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + button_6.getText();
				textField.setText(num);
			}
		});
		button_6.setBounds(128, 113, 49, 45);
		frmStandardCalculator.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + button_7.getText();
				textField.setText(num);
			}
		});
		button_7.setBounds(69, 113, 49, 45);
		frmStandardCalculator.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("7");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + button_8.getText();
				textField.setText(num);
			}
		});
		button_8.setBounds(10, 113, 49, 45);
		frmStandardCalculator.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("4");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + button_9.getText();
				textField.setText(num);
			}
		});
		button_9.setBounds(10, 169, 49, 45);
		frmStandardCalculator.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("5");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + button_10.getText();
				textField.setText(num);
			}
		});
		button_10.setBounds(69, 169, 49, 45);
		frmStandardCalculator.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("6");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + button_11.getText();
				textField.setText(num);
			}
		});
		button_11.setBounds(128, 169, 49, 45);
		frmStandardCalculator.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("*");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "*";
			}
		});
		button_12.setBounds(187, 169, 49, 45);
		frmStandardCalculator.getContentPane().add(button_12);
		
		JButton button_14 = new JButton("1");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + button_14.getText();
				textField.setText(num);
			}
		});
		button_14.setBounds(10, 225, 49, 45);
		frmStandardCalculator.getContentPane().add(button_14);
		
		JButton button_15 = new JButton("2");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + button_15.getText();
				textField.setText(num);
			}
		});
		button_15.setBounds(69, 225, 49, 45);
		frmStandardCalculator.getContentPane().add(button_15);
		
		JButton button_16 = new JButton("3");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + button_16.getText();
				textField.setText(num);
			}
		});
		button_16.setBounds(128, 225, 49, 45);
		frmStandardCalculator.getContentPane().add(button_16);
		
		JButton button_17 = new JButton("-");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "-";
			}
		});
		button_17.setBounds(187, 225, 49, 45);
		frmStandardCalculator.getContentPane().add(button_17);
		
		JButton button_18 = new JButton(".");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + button_18.getText();
				textField.setText(num);
			}
		});
		button_18.setBounds(128, 281, 49, 45);
		frmStandardCalculator.getContentPane().add(button_18);
		
		JButton button_19 = new JButton("+");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "+";
			}
		});
		button_19.setBounds(187, 281, 49, 45);
		frmStandardCalculator.getContentPane().add(button_19);
		
		JButton button_20 = new JButton("=");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondnum = Double.parseDouble(textField.getText());
				if(operations == "+") {
					result = firstnum + secondnum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operations == "-") {
					result = firstnum - secondnum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operations == "*") {
					result = firstnum * secondnum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operations == "/") {
					result = firstnum / secondnum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}else if(operations == "%") {
					result = firstnum % secondnum;
					answer = String.format("%.2f ", result);
					textField.setText(answer);
				}

			}
		});
		button_20.setBounds(246, 169, 49, 157);
		frmStandardCalculator.getContentPane().add(button_20);
		
		JButton button_21 = new JButton("0");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + button_21.getText();
				textField.setText(num);
			}
		});
		button_21.setBounds(10, 281, 108, 45);
		frmStandardCalculator.getContentPane().add(button_21);
		
		JButton btnLog = new JButton("Log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = Math.log(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnLog.setBounds(316, 57, 60, 45);
		frmStandardCalculator.getContentPane().add(btnLog);
		
		JButton btnSin = new JButton("sin");
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = Math.sin(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnSin.setBounds(375, 57, 60, 45);
		frmStandardCalculator.getContentPane().add(btnSin);
		
		JButton btnZ = new JButton("Pi");
		btnZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops ;
				ops = Math.PI;
				textField.setText(String.valueOf(ops));
			}
		});
		btnZ.setBounds(315, 113, 61, 45);
		frmStandardCalculator.getContentPane().add(btnZ);
		
		JButton btnCos = new JButton("cos");
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = Math.cos(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnCos.setBounds(375, 113, 60, 45);
		frmStandardCalculator.getContentPane().add(btnCos);
		
		JButton btnXy = new JButton("x^y");
		btnXy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = Math.pow(ops, ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnXy.setBounds(316, 169, 60, 45);
		frmStandardCalculator.getContentPane().add(btnXy);
		
		JButton btnTan = new JButton("tan");
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = Math.tan(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnTan.setBounds(375, 169, 60, 45);
		frmStandardCalculator.getContentPane().add(btnTan);
		
		JButton btnX = new JButton("x^2");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = (ops * ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnX.setBounds(316, 225, 60, 45);
		frmStandardCalculator.getContentPane().add(btnX);
		
		JButton btnCbr = new JButton("cbr");
		btnCbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = Math.cbrt(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnCbr.setBounds(375, 225, 60, 45);
		frmStandardCalculator.getContentPane().add(btnCbr);
		
		JButton btnX_1 = new JButton("x^3");
		btnX_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = (ops * ops * ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnX_1.setBounds(316, 281, 60, 45);
		frmStandardCalculator.getContentPane().add(btnX_1);
		
		JButton btnBin = new JButton("bin");
		btnBin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(textField.getText());
				textField.setText(Integer.toString(a,2));
			}
			
			
		});
		btnBin.setBounds(375, 281, 60, 45);
		frmStandardCalculator.getContentPane().add(btnBin);
		
		JButton btnSinh = new JButton("Sinh");
		btnSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = Math.sinh(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnSinh.setBounds(436, 57, 69, 45);
		frmStandardCalculator.getContentPane().add(btnSinh);
		
		JButton btnCosh = new JButton("Cosh");
		btnCosh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = Math.cosh(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnCosh.setBounds(436, 113, 69, 45);
		frmStandardCalculator.getContentPane().add(btnCosh);
		
		JButton btnTanh = new JButton("Tanh");
		btnTanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = Math.tanh(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnTanh.setBounds(436, 169, 69, 45);
		frmStandardCalculator.getContentPane().add(btnTanh);
		
		JButton btnRund = new JButton("Rund");
		btnRund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = Math.round(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnRund.setBounds(436, 225, 69, 45);
		frmStandardCalculator.getContentPane().add(btnRund);
		
		JButton btnHex = new JButton("Hex");
		btnHex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(textField.getText());
				textField.setText(Integer.toString(a,16));
			}
		});
		btnHex.setBounds(436, 281, 69, 45);
		frmStandardCalculator.getContentPane().add(btnHex);
		
		JButton btnLnx = new JButton("lnx");
		btnLnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = Math.log10(ops);
				textField.setText(String.valueOf(ops));
				
			}
		});
		btnLnx.setBounds(515, 57, 60, 101);
		frmStandardCalculator.getContentPane().add(btnLnx);
		
		JButton btnpi = new JButton("2*Pi");
		btnpi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops;
				ops = Math.PI * 2;
				textField.setText(String.valueOf(ops));
			}
			
		});
		btnpi.setBounds(515, 169, 60, 101);
		frmStandardCalculator.getContentPane().add(btnpi);
		
		JButton btnOctal = new JButton("Octal");
		btnOctal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(textField.getText());
				textField.setText(Integer.toString(a,8));
			}
		});
		btnOctal.setBounds(506, 281, 69, 45);
		frmStandardCalculator.getContentPane().add(btnOctal);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choose One-:", "USA", "Japan", "UK", "Sweden", "Croatia", "Russia", "Australia", "Brazil", "Canada", "Israel", "Indonesia", "Mexico"}));
		comboBox.setBounds(628, 88, 196, 45);
		frmStandardCalculator.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Currency Converter");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(618, 32, 251, 45);
		frmStandardCalculator.getContentPane().add(lblNewLabel);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		menuItem.setBounds(643, 90, 137, 26);
		frmStandardCalculator.getContentPane().add(menuItem);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(628, 156, 196, 35);
		frmStandardCalculator.getContentPane().add(textField_1);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				double Indian_Rupee = Double.parseDouble(textField_1.getText());
				if(comboBox.getSelectedItem().equals("USA")) {
					String a = String.format("$ %.2f", Indian_Rupee * US_Dollar);
					textField_2.setText(a);
				}
				if(comboBox.getSelectedItem().equals("Japan")) {
					String b = String.format("JP %.2f", Indian_Rupee * Japanese_Yen);
					textField_2.setText(b);
				}
				if(comboBox.getSelectedItem().equals("UK")) {
					String c = String.format("UK %.2f", Indian_Rupee * Pound_Sterling);
					textField_2.setText(c);
				}
				if(comboBox.getSelectedItem().equals("Sweden")) {
					String d = String.format("SW %.2f", Indian_Rupee * Swedish_krona);
					textField_2.setText(d);
				}
				if(comboBox.getSelectedItem().equals("Croatia")) {
					String d2 = String.format("CR %.2f", Indian_Rupee * Croatian_kuna);
					textField_2.setText(d2);
				}
				if(comboBox.getSelectedItem().equals("Russia")) {
					String d3 = String.format("RS %.2f", Indian_Rupee * Russian_rouble);
					textField_2.setText(d3);
				}
				if(comboBox.getSelectedItem().equals("Australia")) {
					String d4 = String.format("AUS$ %.2f", Indian_Rupee * Australian_Dollar);
					textField_2.setText(d4);
				}
				if(comboBox.getSelectedItem().equals("Brazil")) {
					String d5 = String.format("BZ %.2f", Indian_Rupee * Brazilian_real);
					textField_2.setText(d5);
				}
				if(comboBox.getSelectedItem().equals("Canada")) {
					String d6 = String.format("CN$ %.2f", Indian_Rupee * Canadian_Dollar);
					textField_2.setText(d6);
				}
				if(comboBox.getSelectedItem().equals("Israel")) {
					String d7 = String.format("ISR %.2f", Indian_Rupee * Israeli_shekel);
					textField_2.setText(d7);
				}
				if(comboBox.getSelectedItem().equals("Indonesia")) {
					String d8 = String.format("INS %.2f", Indian_Rupee * Indonesian_Rupiah);
					textField_2.setText(d8);
				}
				if(comboBox.getSelectedItem().equals("Mexico")) {
					String d9 = String.format("MX %.2f", Indian_Rupee * Mexican_peso);
					textField_2.setText(d9);
				}
			
			}
		});
		btnConvert.setBounds(628, 281, 90, 45);
		frmStandardCalculator.getContentPane().add(btnConvert);
		
		JButton btnClear = 
				new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(null);
				textField_2.setText(null);
				comboBox.setSelectedItem("Choose One-:");
			}
		});
		btnClear.setBounds(734, 281, 90, 45);
		frmStandardCalculator.getContentPane().add(btnClear);
		
		textField_2 = new JTextField();
		textField_2.setBounds(628, 209, 196, 35);
		frmStandardCalculator.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
