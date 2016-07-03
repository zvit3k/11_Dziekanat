package pawlak.witold.panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pawlak.witold.classes.Settings;
import pawlak.witold.classes.Uczelnia;
import pawlak.witold.database.Database;

public class UpdatePanelU extends JPanel implements ActionListener {

	private JLabel labNazwa;
	private JTextField tfNazwa;
	private JLabel labMiejscowosc;
	private JTextField tfMiejscowosc;
	private JLabel labRokZalozenia;
	private JTextField tfRokZalozenia;
	private JLabel labNazwaRektora;
	private JTextField tfNazwaRektora;

	private JButton btnUpdate;
	private JButton btnCancel;

	private Uczelnia u;
	private JPanel panelU;

	public UpdatePanelU(Uczelnia u, JPanel panelU) {

		super(new BorderLayout());
		this.u = u;
		this.panelU = panelU;

		JPanel panelTop = new JPanel(new GridLayout(4, 2, 5, 5));
		JPanel panelBottom = new JPanel(new GridLayout(1, 2, 5, 5));

		labNazwa = new JLabel("Nazwa:");
		tfNazwa = new JTextField(u.getNazwa());

		labMiejscowosc = new JLabel("Miejscowosc: ");
		tfMiejscowosc = new JTextField(u.getMiejscowosc());

		labRokZalozenia = new JLabel("Rok za³o¿enia: ");
		tfRokZalozenia = new JTextField(u.getRokZalozenia() + "");

		labNazwaRektora = new JLabel("Rektor: ");
		tfNazwaRektora = new JTextField(u.getNazwaRektora());

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(this);
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

		panelBottom.add(btnUpdate);
		panelBottom.add(btnCancel);

		add(panelTop, BorderLayout.PAGE_START);
		add(panelBottom, BorderLayout.PAGE_END);

		setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		updateFont(Settings.fontSize);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate) {
			String nazwa = tfNazwa.getText();
			String miejscowosc = tfMiejscowosc.getText();
			int rokZalozenia = Integer.parseInt(tfRokZalozenia.getText());
			String nazwaRektora = tfNazwaRektora.getText();
			Database.updateUczelnia(u.getId(), nazwa, miejscowosc, rokZalozenia, nazwaRektora);
			((PanelUczelnia)panelU).fillPanelU();
			
		} else if (e.getSource() == btnCancel) {
			((JFrame) this.getRootPane().getParent()).dispose();
			
			
		}
		
	
	}
	public void updateFont(int newFontSize){
		labNazwa.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		tfNazwa.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		labMiejscowosc.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		tfMiejscowosc.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		labRokZalozenia.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		tfRokZalozenia.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		labNazwaRektora.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		tfNazwaRektora.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
	}
}
