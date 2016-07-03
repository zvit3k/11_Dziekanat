package pawlak.witold.panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pawlak.witold.classes.Student;
import pawlak.witold.classes.Uczelnia;
import pawlak.witold.classes.Wpis;
import pawlak.witold.database.Database;
import pawlak.witold.models.CustomComboBoxModel;

public class PanelAll extends JPanel implements ActionListener {

	private JButton btnLeft;
	private JButton btnRight;
	private JTextField tfIndex;

	private JLabel labIdStudentTop;
	private JTextField tfIdStudentTop;
	private JLabel labImieTop;
	private JTextField tfImieTop;
	private JLabel labNazwiskoTop;
	private JTextField tfNazwiskoTop;
	private JLabel labWiekTop;
	private JTextField tfWiekTop;
	private JLabel labRokStudiowTop;
	private JTextField tfRokStudiowTop;

	private JLabel labIdUczelniaTop;
	private JTextField tfIdUczelniaTop;
	private JLabel labNazwaTop;
	private JTextField tfNazwaTop;
	private JLabel labMiejscowoscTop;
	private JTextField tfMiejscowoscTop;
	private JLabel labRokZalozeniaTop;
	private JTextField tfRokZalozeniaTop;
	private JLabel labNazwaRektoraTop;
	private JTextField tfNazwaRektoraTop;

	private JButton btnDeleteTop;

	private JLabel labIdStudentBottom;
	private CustomComboBoxModel cbModelStudentBottom;
	private JComboBox<String> cbIdStudentBottom;
	private JLabel labImieBottom;
	private JTextField tfImieBottom;
	private JLabel labNazwiskoBottom;
	private JTextField tfNazwiskoBottom;
	private JLabel labWiekBottom;
	private JTextField tfWiekBottom;
	private JLabel labRokStudiowBottom;
	private JTextField tfRokStudiowBottom;

	private JLabel labIdUczelniaBottom;
	private CustomComboBoxModel cbModelUczelniaBottom;
	private JComboBox<String> cbIdUczelniaBottom;
	private JLabel labNazwaBottom;
	private JTextField tfNazwaBottom;
	private JLabel labMiejscowoscBottom;
	private JTextField tfMiejscowoscBottom;
	private JLabel labRokZalozeniaBottom;
	private JTextField tfRokZalozeniaBottom;
	private JLabel labNazwaRektoraBottom;
	private JTextField tfNazwaRektoraBottom;

	private JButton btnInsertBottom;

	private List<Wpis> listaW;
	private List<Student> listaS;
	private List<Uczelnia> listaU;
	private int idx;

	public CustomComboBoxModel getCbModelStudentBottom() {
		return cbModelStudentBottom;
	}

	public void setCbModelStudentBottom(CustomComboBoxModel cbModelStudentBottom) {
		this.cbModelStudentBottom = cbModelStudentBottom;
	}

	public CustomComboBoxModel getCbModelUczelniaBottom() {
		return cbModelUczelniaBottom;
	}

	public void setCbModelUczelniaBottom(CustomComboBoxModel cbModelUczelniaBottom) {
		this.cbModelUczelniaBottom = cbModelUczelniaBottom;
	}

	public PanelAll() {
		super(new GridLayout(2, 1, 5, 5));
		JPanel panelTop = new JPanel(new BorderLayout());
		JPanel panelBottom = new JPanel(new BorderLayout());

		JPanel panelTop_Top = new JPanel(new GridLayout(1, 3, 5, 5));
		JPanel panelTop_Center = new JPanel(new GridLayout(5, 4, 5, 5));
		JPanel panelTop_Bottom = new JPanel(); // domyslnie FlowLayout

		JPanel panelBottom_Top = new JPanel(new GridLayout(5, 4, 5, 5));
		JPanel panelBottom_Bottom = new JPanel(); // domyslnie FlowLayout

		btnLeft = new JButton("<<<");
		btnLeft.addActionListener(this);
		btnRight = new JButton(">>>");
		btnRight.addActionListener(this);
		tfIndex = new JTextField(5);

		labIdStudentTop = new JLabel("ID STUDENT");
		tfIdStudentTop = new JTextField(10);
		labImieTop = new JLabel("IMIE");
		tfImieTop = new JTextField(10);
		labNazwiskoTop = new JLabel("NAZWISKO");
		tfNazwiskoTop = new JTextField(10);
		labWiekTop = new JLabel("WIEK");
		tfWiekTop = new JTextField(10);
		labRokStudiowTop = new JLabel("ROK STUDIOW");
		tfRokStudiowTop = new JTextField(10);

		labIdUczelniaTop = new JLabel("ID UCZELNIA");
		tfIdUczelniaTop = new JTextField(10);
		labNazwaTop = new JLabel("NAZWA");
		tfNazwaTop = new JTextField(10);
		labMiejscowoscTop = new JLabel("MIEJSCOWOSC");
		tfMiejscowoscTop = new JTextField(10);
		labRokZalozeniaTop = new JLabel("ROK ZALOZENIA");
		tfRokZalozeniaTop = new JTextField(10);
		labNazwaRektoraTop = new JLabel("NAZWA REKTORA");
		tfNazwaRektoraTop = new JTextField(10);

		btnDeleteTop = new JButton("DELETE");
		btnDeleteTop.addActionListener(this);

		labIdStudentBottom = new JLabel("ID STUDENT");
		cbModelStudentBottom = new CustomComboBoxModel(Student.getIdListFromStudentList(Database.selectStudent()));
		cbIdStudentBottom = new JComboBox<>(cbModelStudentBottom);
		cbIdStudentBottom.addActionListener(this);
		labImieBottom = new JLabel("IMIE");
		tfImieBottom = new JTextField(10);
		labNazwiskoBottom = new JLabel("NAZWISKO");
		tfNazwiskoBottom = new JTextField(10);
		labWiekBottom = new JLabel("WIEK");
		tfWiekBottom = new JTextField(10);
		labRokStudiowBottom = new JLabel("ROK STUDIOW");
		tfRokStudiowBottom = new JTextField(10);

		labIdUczelniaBottom = new JLabel("ID UCZELNIA");
		cbModelUczelniaBottom = new CustomComboBoxModel(Uczelnia.getIdListFromUczelniaList(Database.selectUczelnia()));
		cbIdUczelniaBottom = new JComboBox<>(cbModelUczelniaBottom);
		cbIdUczelniaBottom.addActionListener(this);
		labNazwaBottom = new JLabel("NAZWA");
		tfNazwaBottom = new JTextField(10);
		labMiejscowoscBottom = new JLabel("MIEJSCOWOSC");
		tfMiejscowoscBottom = new JTextField(10);
		labRokZalozeniaBottom = new JLabel("ROK ZALOZENIA");
		tfRokZalozeniaBottom = new JTextField(10);
		labNazwaRektoraBottom = new JLabel("NAZWA REKTORA");
		tfNazwaRektoraBottom = new JTextField(10);

		btnInsertBottom = new JButton("INSERT");
		btnInsertBottom.addActionListener(this);

		panelTop_Top.add(btnLeft);
		panelTop_Top.add(tfIndex);
		panelTop_Top.add(btnRight);

		panelTop_Center.add(labIdStudentTop);
		panelTop_Center.add(tfIdStudentTop);
		panelTop_Center.add(labIdUczelniaTop);
		panelTop_Center.add(tfIdUczelniaTop);
		panelTop_Center.add(labImieTop);
		panelTop_Center.add(tfImieTop);
		panelTop_Center.add(labNazwaTop);
		panelTop_Center.add(tfNazwaTop);
		panelTop_Center.add(labNazwiskoTop);
		panelTop_Center.add(tfNazwiskoTop);
		panelTop_Center.add(labMiejscowoscTop);
		panelTop_Center.add(tfMiejscowoscTop);
		panelTop_Center.add(labWiekTop);
		panelTop_Center.add(tfWiekTop);
		panelTop_Center.add(labRokZalozeniaTop);
		panelTop_Center.add(tfRokZalozeniaTop);
		panelTop_Center.add(labRokStudiowTop);
		panelTop_Center.add(tfRokStudiowTop);
		panelTop_Center.add(labNazwaRektoraTop);
		panelTop_Center.add(tfNazwaRektoraTop);

		panelTop_Bottom.add(btnDeleteTop);

		panelTop.add(panelTop_Top, BorderLayout.PAGE_START);
		panelTop.add(panelTop_Center, BorderLayout.CENTER);
		panelTop.add(panelTop_Bottom, BorderLayout.PAGE_END);

		add(panelTop);

		panelBottom_Top.add(labIdStudentBottom);
		panelBottom_Top.add(cbIdStudentBottom);
		panelBottom_Top.add(labIdUczelniaBottom);
		panelBottom_Top.add(cbIdUczelniaBottom);
		panelBottom_Top.add(labImieBottom);
		panelBottom_Top.add(tfImieBottom);
		panelBottom_Top.add(labNazwaBottom);
		panelBottom_Top.add(tfNazwaBottom);
		panelBottom_Top.add(labNazwiskoBottom);
		panelBottom_Top.add(tfNazwiskoBottom);
		panelBottom_Top.add(labMiejscowoscBottom);
		panelBottom_Top.add(tfMiejscowoscBottom);
		panelBottom_Top.add(labWiekBottom);
		panelBottom_Top.add(tfWiekBottom);
		panelBottom_Top.add(labRokZalozeniaBottom);
		panelBottom_Top.add(tfRokZalozeniaBottom);
		panelBottom_Top.add(labRokStudiowBottom);
		panelBottom_Top.add(tfRokStudiowBottom);
		panelBottom_Top.add(labNazwaRektoraBottom);
		panelBottom_Top.add(tfNazwaRektoraBottom);

		panelBottom_Bottom.add(btnInsertBottom);

		panelBottom.add(panelBottom_Top, BorderLayout.CENTER);
		panelBottom.add(panelBottom_Bottom, BorderLayout.PAGE_END);

		add(panelBottom);

		setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		idx = 0;

		fillPanelWpisTop();

	}

	// TESTY
	public void fillPanelWpisTop() {
		listaW = Database.selectWpis();
		listaS = Database.selectStudent();
		listaU = Database.selectUczelnia();

		tfIndex.setText(listaW.get(idx).getId() + "");
		tfIdStudentTop.setText(listaW.get(idx).getIdStudent() + "");
		tfIdUczelniaTop.setText(listaW.get(idx).getIdUczelnia() + "");

		int helpIdStud = listaW.get(idx).getIdStudent();
		int idStud = 0;
		for (int i = 0; i < listaS.size(); i++) {
			if (helpIdStud == listaS.get(i).getId()) {
				idStud = i;
				break;
			}
		}

		int helpIdUczel = listaW.get(idx).getIdUczelnia();
		int idUczel = 0;
		for (int i = 0; i < listaU.size(); i++) {
			if (helpIdUczel == listaU.get(i).getId()) {
				idUczel = i;
				break;
			}
		}

		tfImieTop.setText(listaS.get(idStud).getImie());
		tfNazwiskoTop.setText(listaS.get(idStud).getNazwisko());
		tfWiekTop.setText(listaS.get(idStud).getWiek() + "");
		tfRokStudiowTop.setText(listaS.get(idStud).getRokStudiow() + "");

		tfNazwaTop.setText(listaU.get(idUczel).getNazwa());
		tfMiejscowoscTop.setText(listaU.get(idUczel).getMiejscowosc());
		tfRokZalozeniaTop.setText(listaU.get(idUczel).getRokZalozenia() + "");
		tfNazwaRektoraTop.setText(listaU.get(idUczel).getNazwaRektora());

	}

	// DZIA£A
	public void fillPanelS(int idStudent) {
		listaS = Database.selectStudent();
		tfImieBottom.setText(listaS.get(idStudent).getImie());
		tfNazwiskoBottom.setText(listaS.get(idStudent).getNazwisko());
		tfWiekBottom.setText(listaS.get(idStudent).getWiek() + "");
		tfRokStudiowBottom.setText(listaS.get(idStudent).getRokStudiow() + "");

	}

	// DZIA£A
	public void fillPanelU(int idUczelnia) {
		listaU = Database.selectUczelnia();
		tfNazwaBottom.setText(listaU.get(idUczelnia).getNazwa());
		tfMiejscowoscBottom.setText(listaU.get(idUczelnia).getMiejscowosc());
		tfRokZalozeniaBottom.setText(listaU.get(idUczelnia).getRokZalozenia() + "");
		tfNazwaRektoraBottom.setText(listaU.get(idUczelnia).getNazwaRektora());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLeft) {
			listaW = Database.selectWpis();
			idx--;
			if (idx < 0) {
				idx = listaW.size() - 1;
			}
			fillPanelWpisTop();

		} else if (e.getSource() == btnRight) {
			listaW = Database.selectWpis();
			idx++;
			if (idx >= listaW.size()) {
				idx = 0;
			}
			fillPanelWpisTop();

		} else if (e.getSource() == btnDeleteTop) {
			Database.deleteWpis(listaW.get(idx).getId());
			idx = 0;
			listaW = Database.selectWpis();

		} else if (e.getSource() == btnInsertBottom) {
			int idStudent = Integer.parseInt((String) cbIdStudentBottom.getSelectedItem());
			int idUczelnia = Integer.parseInt((String) cbIdUczelniaBottom.getSelectedItem());
			Database.insertWpis(idStudent, idUczelnia);
			JOptionPane.showMessageDialog(null, "Wpis zosta³ zachowany!");
		} else if (e.getSource() == cbIdStudentBottom) {

			int idS = Integer.parseInt((String) cbIdStudentBottom.getSelectedItem());
			listaS = Database.selectStudent();

			for (int i = 0; i < listaS.size(); i++) {
				if (idS == listaS.get(i).getId()) {
					fillPanelS(i);
				}
			}

		} else if (e.getSource() == cbIdUczelniaBottom) {

			int idU = Integer.parseInt((String) cbIdUczelniaBottom.getSelectedItem());
			listaU = Database.selectUczelnia();

			for (int i = 0; i < listaU.size(); i++) {
				if (idU == listaU.get(i).getId()) {
					fillPanelU(i);
				}
			}

		}

	}

	public void updateFont(int newFontSize) {
		Font newFont = new Font("Times New Roman", Font.PLAIN, newFontSize);
		btnLeft.setFont(newFont);
		btnLeft.setFont(newFont);
		btnRight.setFont(newFont);
		btnRight.setFont(newFont);
		tfIndex.setFont(newFont);

		labIdStudentTop.setFont(newFont);
		tfIdStudentTop.setFont(newFont);
		labImieTop.setFont(newFont);
		tfImieTop.setFont(newFont);
		labNazwiskoTop.setFont(newFont);
		tfNazwiskoTop.setFont(newFont);
		labWiekTop.setFont(newFont);
		tfWiekTop.setFont(newFont);
		labRokStudiowTop.setFont(newFont);
		tfRokStudiowTop.setFont(newFont);

		labIdUczelniaTop.setFont(newFont);
		tfIdUczelniaTop.setFont(newFont);
		labNazwaTop.setFont(newFont);
		tfNazwaTop.setFont(newFont);
		labMiejscowoscTop.setFont(newFont);
		tfMiejscowoscTop.setFont(newFont);
		labRokZalozeniaTop.setFont(newFont);
		tfRokZalozeniaTop.setFont(newFont);
		labNazwaRektoraTop.setFont(newFont);
		tfNazwaRektoraTop.setFont(newFont);

		btnDeleteTop.setFont(newFont);
		btnDeleteTop.setFont(newFont);

		labIdStudentBottom.setFont(newFont);

		cbIdStudentBottom.setFont(newFont);
		cbIdStudentBottom.setFont(newFont);
		labImieBottom.setFont(newFont);
		tfImieBottom.setFont(newFont);
		labNazwiskoBottom.setFont(newFont);
		tfNazwiskoBottom.setFont(newFont);
		labWiekBottom.setFont(newFont);
		tfWiekBottom.setFont(newFont);
		labRokStudiowBottom.setFont(newFont);
		tfRokStudiowBottom.setFont(newFont);

		labIdUczelniaBottom.setFont(newFont);

		cbIdUczelniaBottom.setFont(newFont);
		cbIdUczelniaBottom.setFont(newFont);
		labNazwaBottom.setFont(newFont);
		tfNazwaBottom.setFont(newFont);
		labMiejscowoscBottom.setFont(newFont);
		tfMiejscowoscBottom.setFont(newFont);
		labRokZalozeniaBottom.setFont(newFont);
		tfRokZalozeniaBottom.setFont(newFont);
		labNazwaRektoraBottom.setFont(newFont);
		tfNazwaRektoraBottom.setFont(newFont);

		btnInsertBottom.setFont(newFont);
		btnInsertBottom.setFont(newFont);

	}

}