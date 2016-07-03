package pawlak.witold.panels;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import pawlak.witold.classes.Student;
import pawlak.witold.classes.Uczelnia;
import pawlak.witold.database.Database;
import pawlak.witold.models.CustomComboBoxModel;

public class PanelFiltr extends JPanel implements ActionListener {

	private JButton btnLeft;
	private JButton btnRight;
	private JTextField tfIndex;

	private JLabel labNameTop;
	private JTextField tfNameTop;
	private JLabel labSurnameTop;
	private JTextField tfSurnameTop;
	private JLabel labAgeTop;
	private JTextField tfAgeTop;
	private JLabel labStudiesTop;
	private JTextField tfStudiesTop;

	private JLabel labNazwaTop;
	private JTextField tfNazwaTop;
	private JLabel labMiejscoscTop;
	private JTextField tfMiejscowoscTop;
	private JLabel labRokZalozeniaTop;
	private JTextField tfRokZalozeniaTop;
	private JLabel labNazwaRektoraTop;
	private JTextField tfNazwaRektoraTop;

	private JLabel labNameBottom;
	private DefaultListModel<String> modelName;
	private JList<String> jlNameBottom;
	private DefaultListModel<String> modelSurname;
	private JLabel labSurnameBottom;
	private JList<String> jlSurnameBottom;

	private JLabel labAgeFromBottom;
	private JComboBox<String> cbAgeFromBottom;
	private JLabel labAgeToBottom;
	private JComboBox<String> cbAgeToBottom;

	private JLabel labStudiesFromBottom;
	private JComboBox<String> cbStudiesFromBottom;
	private JLabel labStudiesToBottom;
	private JComboBox<String> cbStudiesToBottom;

	private JLabel labNazwaBottom;
	private JList<String> jlNazwaBottom;
	private DefaultListModel<String> modelNazwa;
	private JLabel labMiejscowoscBottom;
	private JList<String> jlMiejscowoscBottom;
	private DefaultListModel<String> modelMiejscowosc;
	private JLabel labRokZalozeniaFromBottom;
	private JComboBox<String> cbRokZalozeniaFromBottom;
	private JLabel labRokZalozeniaToBottom;
	private JComboBox<String> cbRokZalozeniaToBottom;
	private JLabel labNazwaRektoraBottom;
	private JList<String> jlNazwaRektoraBottom;
	private DefaultListModel<String> modelNazwaRektora;
	private JLabel label1;

	private JButton btnFiltr;

	public PanelFiltr() {
		super(new BorderLayout(10, 10));
		JPanel panelTop = new JPanel(new GridBagLayout());
		JPanel panelCenter = new JPanel(new GridBagLayout());
		JPanel panelBottom = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 0;
		gbc.weighty = 0;

		// PANEL TOP
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		btnLeft = new JButton("<<<");
		panelTop.add(btnLeft, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 40;
		tfIndex = new JTextField();
		panelTop.add(tfIndex, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.ipadx = 0;
		btnRight = new JButton(">>>");
		panelTop.add(btnRight, gbc);

		// PANEL CENTER
		gbc.gridx = 0;
		gbc.gridy = 1;
		labNameTop = new JLabel("Imie: ");
		panelCenter.add(labNameTop, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.ipadx = 100;
		tfNameTop = new JTextField();
		panelCenter.add(tfNameTop, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.ipadx = 0;
		labSurnameTop = new JLabel("Nazwisko: ");
		panelCenter.add(labSurnameTop, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.ipadx = 100;
		tfSurnameTop = new JTextField();
		panelCenter.add(tfSurnameTop, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.ipadx = 0;
		labAgeTop = new JLabel("Wiek: ");
		panelCenter.add(labAgeTop, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.ipadx = 100;
		tfAgeTop = new JTextField();
		panelCenter.add(tfAgeTop, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.ipadx = 0;
		labStudiesTop = new JLabel("Rok Studiów: ");
		panelCenter.add(labStudiesTop, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.ipadx = 100;
		tfStudiesTop = new JTextField();
		panelCenter.add(tfStudiesTop, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.ipadx = 0;
		labNazwaTop = new JLabel("Nazwa: ");
		panelCenter.add(labNazwaTop, gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.ipadx = 100;
		tfNazwaTop = new JTextField();
		panelCenter.add(tfNazwaTop, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.ipadx = 0;
		labMiejscoscTop = new JLabel("Miejscowoœæ: ");
		panelCenter.add(labMiejscoscTop, gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.ipadx = 100;
		tfMiejscowoscTop = new JTextField();
		panelCenter.add(tfMiejscowoscTop, gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.ipadx = 0;
		labRokZalozeniaTop = new JLabel("Rok zalo¿enia: ");
		panelCenter.add(labRokZalozeniaTop, gbc);

		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.ipadx = 100;
		tfRokZalozeniaTop = new JTextField();
		panelCenter.add(tfRokZalozeniaTop, gbc);

		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.ipadx = 0;
		labNazwaRektoraTop = new JLabel("Nazwa rektora: ");
		panelCenter.add(labNazwaRektoraTop, gbc);

		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.ipadx = 100;
		tfNazwaRektoraTop = new JTextField();
		panelCenter.add(tfNazwaRektoraTop, gbc);

		// PANEL BOTTOM --------------------------------------------------------

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 0;
		labNameBottom = new JLabel("Imie: ");
		panelBottom.add(labNameBottom, gbc);

		modelName = new DefaultListModel<>();
		List<String> nameList = Database.selectImieStudent();

		for (String s : nameList) {
			modelName.addElement(s);
		}

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 100;
		jlNameBottom = new JList<>(modelName);
		jlNameBottom.setLayoutOrientation(JList.VERTICAL);
		jlNameBottom.setVisibleRowCount(2);
		jlNameBottom.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		panelBottom.add(new JScrollPane(jlNameBottom), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipadx = 0;
		labSurnameBottom = new JLabel("Nazwisko: ");
		panelBottom.add(labSurnameBottom, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.ipadx = 100;
		modelSurname = new DefaultListModel<>();
		List<String> surnameList = Database.selectNazwiskoStudent();
		for (String s : surnameList) {
			modelSurname.addElement(s);
		}
		jlSurnameBottom = new JList<>(modelSurname);
		jlSurnameBottom.setLayoutOrientation(JList.VERTICAL);
		jlSurnameBottom.setVisibleRowCount(2);
		jlSurnameBottom.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		panelBottom.add(new JScrollPane(jlSurnameBottom), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.ipadx = 0;
		labAgeFromBottom = new JLabel("Wiek od: ");
		panelBottom.add(labAgeFromBottom, gbc);
		CustomComboBoxModel cbAgeFromModel = new CustomComboBoxModel(
				Student.getAgeListFromStudentList(Database.selectStudent()));
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.ipadx = 30;
		cbAgeFromBottom = new JComboBox<>(cbAgeFromModel);
		panelBottom.add(cbAgeFromBottom, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.ipadx = 0;
		labAgeToBottom = new JLabel("Wiek do: ");
		panelBottom.add(labAgeToBottom, gbc);
		CustomComboBoxModel cbAgeToModel = new CustomComboBoxModel(
				Student.getAgeListFromStudentList(Database.selectStudent()));
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.ipadx = 30;
		cbAgeToBottom = new JComboBox<>(cbAgeToModel);
		panelBottom.add(cbAgeToBottom, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.ipadx = 0;
		labStudiesFromBottom = new JLabel("Rok studiów od:");
		panelBottom.add(labStudiesFromBottom, gbc);
		CustomComboBoxModel cbStudiesFrom = new CustomComboBoxModel(
				Student.getStudiesListFromStudentList(Database.selectStudent()));
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.ipadx = 30;
		cbStudiesFromBottom = new JComboBox<>(cbStudiesFrom);
		panelBottom.add(cbStudiesFromBottom, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.ipadx = 0;
		labStudiesToBottom = new JLabel("Rok studiów do: ");
		panelBottom.add(labStudiesToBottom, gbc);
		CustomComboBoxModel cbStudiesTo = new CustomComboBoxModel(
				Student.getStudiesListFromStudentList(Database.selectStudent()));

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.ipadx = 30;
		cbStudiesToBottom = new JComboBox<>(cbStudiesTo);
		panelBottom.add(cbStudiesToBottom, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.ipadx = 0;
		labNazwaBottom = new JLabel("Nazwa: ");
		panelBottom.add(labNazwaBottom, gbc);
		modelNazwa = new DefaultListModel<>();
		List<String> nazwaList = Database.selectNazwaUczelnia();
		for (String s : nazwaList) {
			modelNazwa.addElement(s);
		}
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.ipadx = 100;
		jlNazwaBottom = new JList<>(modelNazwa);
		jlNazwaBottom.setLayoutOrientation(JList.VERTICAL);
		jlNazwaBottom.setVisibleRowCount(2);
		jlNazwaBottom.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		panelBottom.add(new JScrollPane(jlNazwaBottom), gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.ipadx = 0;
		labMiejscowoscBottom = new JLabel("Miejscowosc: ");
		panelBottom.add(labMiejscowoscBottom, gbc);
		modelMiejscowosc = new DefaultListModel<>();
		List<String> miejscowoscList = Database.selectMiejscowoscUczelnia();
		for (String s : miejscowoscList) {
			modelMiejscowosc.addElement(s);
		}
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.ipadx = 100;
		jlMiejscowoscBottom = new JList<>(modelMiejscowosc);
		jlMiejscowoscBottom.setLayoutOrientation(JList.VERTICAL);
		jlMiejscowoscBottom.setVisibleRowCount(2);
		jlMiejscowoscBottom.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		panelBottom.add(new JScrollPane(jlMiejscowoscBottom), gbc);

		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.ipadx = 0;
		labRokZalozeniaFromBottom = new JLabel("Rok za³o¿enia od: ");
		panelBottom.add(labRokZalozeniaFromBottom, gbc);

		CustomComboBoxModel cbRokZalozeniaFrom = new CustomComboBoxModel(
				Uczelnia.getRokZalozeniaListFromUczelniaList(Database.selectUczelnia()));
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.ipadx = 30;
		cbRokZalozeniaFromBottom = new JComboBox<>(cbRokZalozeniaFrom);
		panelBottom.add(cbRokZalozeniaFromBottom, gbc);
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.ipadx = 0;
		labRokZalozeniaToBottom = new JLabel("Rok za³o¿enia do: ");
		panelBottom.add(labRokZalozeniaToBottom, gbc);
		CustomComboBoxModel cbRokZalozeniaTo = new CustomComboBoxModel(
				Uczelnia.getRokZalozeniaListFromUczelniaList(Database.selectUczelnia()));

		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.ipadx = 30;
		cbRokZalozeniaToBottom = new JComboBox<>(cbRokZalozeniaTo);
		panelBottom.add(cbRokZalozeniaToBottom, gbc);

		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.ipadx = 0;
		labNazwaRektoraBottom = new JLabel("Nazwa rektora: ");
		panelBottom.add(labNazwaRektoraBottom, gbc);

		gbc.gridx = 1;
		gbc.gridy = 10;
		gbc.ipadx = 100;
		modelNazwaRektora = new DefaultListModel<>();
		List<String> nazwaRektoraList = Database.selectNazwaRektoraUczelnia();
		for (String s : nazwaRektoraList) {
			modelNazwaRektora.addElement(s);
		}
		jlNazwaRektoraBottom = new JList<>(modelNazwaRektora);
		jlNazwaRektoraBottom.setLayoutOrientation(JList.VERTICAL);
		jlNazwaRektoraBottom.setVisibleRowCount(2);
		jlNazwaRektoraBottom.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		panelBottom.add(new JScrollPane(jlNazwaRektoraBottom), gbc);

		gbc.gridx = 1;
		gbc.gridy = 11;
		gbc.ipadx = 30;
		btnFiltr = new JButton("FILTRUJ");
		btnFiltr.addActionListener(this);
		panelBottom.add(btnFiltr, gbc);

		panelBottom.setBorder(BorderFactory.createTitledBorder("Filtrowanie"));

		add(panelTop, BorderLayout.PAGE_START);
		add(panelCenter, BorderLayout.CENTER);
		add(panelBottom, BorderLayout.PAGE_END);

		setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLeft) {

		} else if (e.getSource() == btnRight) {

		} else if (e.getSource() == btnFiltr) {

			// String imie
			List<String> nameValues = jlNameBottom.getSelectedValuesList();

			for (String s : nameValues) {
				System.out.println(s);
			}

			// String nazwisko = tfSurnameTop.getText();
			// int wiekOd =
			// Integer.parseInt((String)cbAgeFromBottom.getSelectedItem());
			// int wiekDo =
			// Integer.parseInt((String)cbAgeToBottom.getSelectedItem());
			// int rokStudiowOd =
			// Integer.parseInt((String)cbStudiesFromBottom.getSelectedItem());
			// int rokStudiowDo =
			// Integer.parseInt((String)cbStudiesToBottom.getSelectedItem());
			// String nazwa = tfNazwaTop.getText();
			// String miejscowosc = tfMiejscowoscTop.getText();
			// int rokZalozeniaOd =
			// Integer.parseInt((String)cbRokZalozeniaFromBottom.getSelectedItem());
			// int rokZalozeniaDo =
			// Integer.parseInt((String)cbRokZalozeniaToBottom.getSelectedItem());
			// String nazwaRektora = tfNazwaRektoraTop.getText();

		} else if (e.getSource() == jlNameBottom) {

		} else if (e.getSource() == jlSurnameBottom) {

		} else if (e.getSource() == jlNazwaBottom) {

		} else if (e.getSource() == jlMiejscowoscBottom) {

		} else if (e.getSource() == jlNazwaRektoraBottom) {

		} else if (e.getSource() == cbAgeFromBottom) {

		} else if (e.getSource() == cbAgeToBottom) {

		} else if (e.getSource() == cbRokZalozeniaFromBottom) {

		} else if (e.getSource() == cbRokZalozeniaToBottom) {

		} else if (e.getSource() == cbStudiesFromBottom) {

		} else if (e.getSource() == cbStudiesToBottom) {

		}

	}

}
