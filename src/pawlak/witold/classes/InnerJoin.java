package pawlak.witold.classes;

import java.util.ArrayList;
import java.util.List;

public class InnerJoin {
	
	private int id;
	private String imie;
	private String nazwisko ;
	private int wiek; 
	private int rokStudiow; 
	
	private String nazwa; 
	private String miejscowosc; 
	private int rokZalozenia; 
	private String nazwaRektora; 
	
	public InnerJoin(int id, String imie, String nazwisko, int wiek, int rokStudiow, 
			String nazwa, String miejscowosc, int rokZalozenia, String nazwaRektora){
		this.id=id;
		
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.wiek=wiek;
		this.rokStudiow=rokStudiow;
		
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

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public int getRokStudiow() {
		return rokStudiow;
	}

	public void setRokStudiow(int rokStudiow) {
		this.rokStudiow = rokStudiow;
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
	public String toString() {
		return "InnerJoin [id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", wiek=" + wiek + ", rokStudiow="
				+ rokStudiow + ", nazwa=" + nazwa + ", miejscowosc=" + miejscowosc + ", rokZalozenia=" + rokZalozenia
				+ ", nazwaRektora=" + nazwaRektora + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((miejscowosc == null) ? 0 : miejscowosc.hashCode());
		result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
		result = prime * result + ((nazwaRektora == null) ? 0 : nazwaRektora.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + rokStudiow;
		result = prime * result + rokZalozenia;
		result = prime * result + wiek;
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
		InnerJoin other = (InnerJoin) obj;
		if (id != other.id)
			return false;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
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
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (rokStudiow != other.rokStudiow)
			return false;
		if (rokZalozenia != other.rokZalozenia)
			return false;
		if (wiek != other.wiek)
			return false;
		return true;
	}
	
	
}
