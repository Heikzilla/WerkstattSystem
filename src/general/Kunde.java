package general;

public class Kunde {

	private int kunde_ID;
	private String vorname;
	private String nachname;
	private int plz;
	private String ort;
	private String strasse;
	private String hausnummer;
	
	public Kunde(int kunde_ID, String vorname, String nachname, int plz,
			String ort, String strasse, String hausnummer) {
		
		this.kunde_ID = kunde_ID;
		this.vorname = vorname;
		this.nachname = nachname;
		this.plz = plz;
		this.ort = ort;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
	}
	
	public int getKunde_ID() {
		return kunde_ID;
	}

	public void setKunde_ID(int kunde_ID) {
		this.kunde_ID = kunde_ID;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

}
