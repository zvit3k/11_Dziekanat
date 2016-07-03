package pawlak.witold.classes;

import java.util.ArrayList;
import java.util.List;

public class Uczelnia {
	private int id;
	private String nazwa;
	private String miejscowosc;
	private int rokZalozenia;
	private String nazwaRektora;

	public Uczelnia(int id, String nazwa, String miejscowosc, int rokZalozenia, String nazwaRektora) {
		this.id=id;
		this.nazwa=nazwa;
		this.miejscowosc=miejscowosc;
		this.rokZalozenia=rokZalozenia;
		this.nazwaRektora=nazwaRektora;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	public int getRokZalozenia() {
		return rokZalozenia;
	}

	public void setRokZalozenia(int rokZalozenia) {
		this.rokZalozenia = rokZalozenia;
	}

	public String getNazwaRektora() {
		return nazwaRektora;
	}

	public void setNazwaRektora(String nazwaRektora) {
		this.nazwaRektora = nazwaRektora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((miejscowosc == null) ? 0 : miejscowosc.hashCode());
		result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
		result = prime * result + ((nazwaRektora == null) ? 0 : nazwaRektora.hashCode());
		result = prime * result + rokZalozenia;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uczelnia other = (Uczelnia) obj;
		if (id != other.id)
			return false;
		if (miejscowosc == null) {
			if (other.miejscowosc != null)
				return false;
		} else if (!miejscowosc.equals(other.miejscowosc))
			return false;
		if (nazwa == null) {
			if (other.nazwa != null)
				return false;
		} else if (!nazwa.equals(other.nazwa))
			return false;
		if (nazwaRektora == null) {
			if (other.nazwaRektora != null)
				return false;
		} else if (!nazwaRektora.equals(other.nazwaRektora))
			return false;
		if (rokZalozenia != other.rokZalozenia)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Uczelnia [id=" + id + ", nazwa=" + nazwa + ", miejscowosc=" + miejscowosc + ", rokZalozenia="
				+ rokZalozenia + ", nazwaRektora=" + nazwaRektora + "]";
	}
	
	public static List<String> getIdListFromUczelniaList(List<Uczelnia> lista)
	{
		List<String> idList = new ArrayList<>();
		for(Uczelnia s : lista)
		{
			idList.add(s.getId() + "");
		}
		return idList;
	}

	
}

// do logowania
// user - varchar
// password - varchar
// role - varchar
// do tego crud
