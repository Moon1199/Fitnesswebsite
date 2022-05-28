

import java.io.Serializable;

public class uebungen implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private int uebungsId;
	private String uebungsName;
	private String beschreibung;
	private int dauer;
	private int saetze;
	private int wiederholungen;
	
	
	public String getUebungsName() {
		return uebungsName;
	}
	public void setUebungsName(String uebungsName) {
		this.uebungsName = uebungsName;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public int getDauer() {
		return dauer;
	}
	public void setDauer(int dauer) {
		this.dauer = dauer;
	}
	public int getSaetze() {
		return saetze;
	}
	public void setSaetze(int saetze) {
		this.saetze = saetze;
	}
	public int getWiederholungen() {
		return wiederholungen;
	}
	public void setWiederholungen(int wiederholungen) {
		this.wiederholungen = wiederholungen;
	}
	public int getUebungsId() {
		return uebungsId;
	}
	public void setUebungsId(int uebungsId) {
		this.uebungsId = uebungsId;
	}
	
	
	

}
