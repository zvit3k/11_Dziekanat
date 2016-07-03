package pawlak.witold.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pawlak.witold.database.Database;

public class InsertPanelU extends JPanel implements ActionListener {

	private JLabel labNazwa;
	private JTextField tfNazwa;
	private JLabel labMiejscowosc;
	private JTextField tfMiejscowosc;
	private JLabel labRokZalozenia;
	private JTextField tfRokZalozenia;
	private JLabel labNazwaRektora;
	private JTextField tfNazwaRektora;

	private JButton btnInsert;
	private JButton btnCancel;

	public InsertPanelU() {
		super(new BorderLayout());
		JPanel panelTop = new JPanel(new GridLayout(4, 2, 5, 5));
		JPanel panelBottom = new JPanel(new GridLayout(1, 2, 5, 5));

		labNazwa = new JLabel("Nazwa:");
		tfNazwa = new JTextField();

		labMiejscowosc = new JLabel("Miejscowosc: ");
		tfMiejscowosc = new JTextField();

		labRokZalozenia = new JLabel("Rok za�o�enia: ");
		tfRokZalozenia = new JTextField();

		labNazwaRektora = new JLabel("Rektor: ");
		tfNazwaRektora = new JTextField();

		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);

		panelTop.add(labNazwa);
		panelTop.add(tfNazwa);
		panelTop.add(labMiejscowosc);
		panelTop.add(tfMiejscowosc);
		panelTop.add(labRokZalozenia);
		panelTop.add(tfRokZalozenia);
		panelTop.add(labNazwaRektora);
		panelTop.add(tfNazwaRektora);

		panelBottom.add(btnInsert);
		panelBottom.add(btnCancel);

		add(panelTop, BorderLayout.PAGE_START);
		add(panelBottom, BorderLayout.PAGE_END);

		setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInsert) {
			String nazwa = tfNazwa.getText();
			String miejscowosc = tfMiejscowosc.getText();
			int rokZalozenia = Integer.parseInt(tfRokZalozenia.getText());
			String nazwaRektora = tfNazwaRektora.getText();
			Database.insertUczelnia(nazwa, miejscowosc, rokZalozenia, nazwaRektora);
			JOptionPane.showMessageDialog(null, "Uczelnia wprowadzona.");
		} else if (e.getSource() == btnCancel) {
			((JFrame) this.getRootPane().getParent()).dispose();
		}

	}

}
