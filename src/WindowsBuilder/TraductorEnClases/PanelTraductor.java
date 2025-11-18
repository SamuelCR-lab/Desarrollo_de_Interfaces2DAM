package TraductorEnClases;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTraductor extends JPanel{
	private JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2;
	private JTextField textField;
	public PanelTraductor() {
		setSize(new Dimension(800, 600));
		setLayout(null);
		
		 lblNewLabel = new JLabel("Palabra en Ingles a traducir");
		lblNewLabel.setBounds(35, 154, 199, 35);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Palabra Traducida");
		lblNewLabel_1.setBounds(35, 347, 199, 25);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(259, 158, 147, 27);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Traducir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(148, 252, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(259, 345, 170, 29);
		add(lblNewLabel_2);
		
	}
}
