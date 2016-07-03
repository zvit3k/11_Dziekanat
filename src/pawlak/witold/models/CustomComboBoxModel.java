package pawlak.witold.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import pawlak.witold.database.Database;

public class CustomComboBoxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

	private List<String> list;
	private String selectedItem; // zmienna przechowujaca aktualnie zaznaczony
									// element w comboboxie

	public CustomComboBoxModel(List<String> list) {
		// this.list = list; //dwie referencje - jedna lista, szybko bez
		// kopiowania, mozliwosc niemyslnej modyfikacji
		this.list = new ArrayList<>(list); // dwie listy dwie referencje,
											// kopiowanie
	}

	@Override
	public String getElementAt(int idx) {
		return list.get(idx);
	}

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public Object getSelectedItem() {
		return selectedItem;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selectedItem = (String) anItem;

	}
	
	

	public void updateList(List<String> list) {
		// this.list = list; //dwie referencje - jedna lista, szybko bez
		// kopiowania, mozliwosc niemyslnej modyfikacji
		this.list = new ArrayList<>(list); // dwie listy dwie referencje,
											// kopiowanie
	}

}
