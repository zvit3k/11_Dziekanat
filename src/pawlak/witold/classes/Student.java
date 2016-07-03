package pawlak.witold.classes;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private int id;
	private String imie;
	private String nazwisko;
	private int wiek;
	private int rokStudiow;
	private String zdjecie;
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
	public String getZdjecie() {
		return zdjecie;
	}
	public void setZdjecie(String zdjecie) {
		this.zdjecie = zdjecie;
	}
	public Student(int id, String imie, String nazwisko, int wiek, int rokStudiow, String zdjecie) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
		this.rokStudiow = rokStudiow;
		this.zdjecie = zdjecie;
	}
	
	public Student() {}
	@Override
	public String toString() {
		return "Student [id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", wiek=" + wiek + ", rokStudiow="
				+ rokStudiow + ", zdjecie=" + zdjecie + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + rokStudiow;
		result = prime * result + wiek;
		result = prime * result + ((zdjecie == null) ? 0 : zdjecie.hashCode());
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
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (rokStudiow != other.rokStudiow)
			return false;
		if (wiek != other.wiek)
			return false;
		if (zdjecie == null) {
			if (other.zdjecie != null)
				return false;
		} else if (!zdjecie.equals(other.zdjecie))
			return false;
		return true;
	}
	
	public static List<String> getIdListFromStudentList(List<Student> lista)
	{
		List<String> idList = new ArrayList<>();
		for(Student s : lista)
		{
			idList.add(s.getId() + "");
		}
		return idList;
	}

}
