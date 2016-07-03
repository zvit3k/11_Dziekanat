package pawlak.witold.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pawlak.witold.classes.Uczelnia;
import pawlak.witold.database.Database;

public class MainPanelUczelnia extends JPanel implements ActionListener{

	JButton btnLeft;
	JButton btnRight;
	JTextField tfIndeks;
	
	JLabel labNazwa;
	JTextField tfNazwa;
	JLabel labMiejscowosc;
	JTextField tfMiejscowosc;
	JLabel labRokZalozenia;
	JTextField tfRokZalozenia;
	JLabel labNazwaRektora;
	JTextField tfNazwaRektora;
	
	JButton btnInsert;
	JButton btnDelete;
	JButton btnUpdate;
	
	private List<Uczelnia> lista;
	private int idx;
	private boolean czyPusta;
	
	public MainPanelUczelnia(){
		super(new BorderLayout(10,10));
		JPanel panelTop = new JPanel(new GridLayout(1,3,5,5));
		JPanel panelCenter = new JPanel(new GridLayout(4,2,5,5));
		JPanel panelBottom = new JPanel(new GridLayout(1,3,5,5));
		btnLeft = new JButton("<<<");
		btnLeft.addActionListener(this);
		btnRight = new JButton(">>>");
		btnRight.addActionListener(this);
		tfIndeks = new JTextField(" ");
		
		labNazwa = new JLabel("Nazwa uczelni: ");
		tfNazwa = new JTextField();
		
		labMiejscowosc = new JLabel("Miejscowosc: ");
		tfMiejscowosc = new JTextField();
		
		labRokZalozenia = new JLabel("Rok za³o¿enia: ");
		tfRokZalozenia = new JTextField();
		
		labNazwaRektora = new JLabel("Rektor: ");
		tfNazwaRektora = new JTextField();
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(this);
		
		panelTop.add(btnLeft);
		panelTop.add(tfIndeks);
		panelTop.add(btnRight);
		
		panelCenter.add(labNazwa);
		panelCenter.add(tfNazwa);
		panelCenter.add(labMiejscowosc);
		panelCenter.add(tfMiejscowosc);
		panelCenter.add(labRokZalozenia);
		panelCenter.add(tfRokZalozenia);
		panelCenter.add(labNazwaRektora);
		panelCenter.add(tfNazwaRektora);
		
		panelBottom.add(btnInsert);
		panelBottom.add(btnDelete);
		panelBottom.add(btnUpdate);
		
		add(panelTop, BorderLayout.PAGE_START);
		add(panelCenter, BorderLayout.CENTER);
		add(panelBottom, BorderLayout.PAGE_END);
		
		setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		lista = Database.selectUczelnia();
		idx=0;
		fillPanelU();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLeft){
			lista = Database.selectUczelnia();
			idx--;
			if(idx<0){
				idx = lista.size()-1;
			}
			fillPanelU();
			
		} else if(e.getSource()==btnRight){
			lista = Database.selectUczelnia();
			idx++;
			if(idx>=lista.size()){
				idx = 0;
			}
			fillPanelU();
			
		} else if(e.getSource()==btnInsert){
			JFrame frameInsert = new JFrame("Insert");
			frameInsert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frameInsert.setVisible(true);
			InsertPanelU insertPanel = new InsertPanelU();
			frameInsert.setContentPane(insertPanel);
			frameInsert.pack();
			insertPanel.setVisible(true);
			frameInsert.setResizable(false);
			frameInsert.setLocation(250,200);
			
		} else if(e.getSource()==btnDelete){
			Database.deleteUczelnia(lista.get(idx).getId());
			idx=0;
			lista = Database.selectUczelnia();
			fillPanelU();
			if(czyPusta){
				btnDelete.setEnabled(false);
			}
			
		} else if(e.getSource()==btnUpdate){
			JFrame frameUpdate = new JFrame("Edycja");
			frameUpdate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frameUpdate.setVisible(true);
			UpdatePanelU updatePanel = new UpdatePanelU(lista.get(idx), this);
			frameUpdate.setContentPane(updatePanel);
			frameUpdate.pack();
			updatePanel.setVisible(true);
			frameUpdate.setResizable(false);
			frameUpdate.setLocation(800,200);
		}
		
	}
	
	public void fillPanelU(){
		lista = Database.selectUczelnia();
		if(lista.isEmpty() || lista==null){
			tfIndeks.setText("");
			tfNazwa.setText("");
			tfMiejscowosc.setText("");
			tfRokZalozenia.setText("");
			tfNazwaRektora.setText("");
			czyPusta = true;
			return;
		}
		tfIndeks.setText(lista.get(idx).getId()+"");
		tfNazwa.setText(lista.get(idx).getNazwa());
		tfMiejscowosc.setText(lista.get(idx).getMiejscowosc());
		tfRokZalozenia.setText(lista.get(idx).getRokZalozenia()+ "");
		tfNazwaRektora.setText(lista.get(idx).getNazwaRektora());
	}

}
