package general;

public class Kfz {

	private int kfz_ID;
	private String marke;
	private String modell;
	private String kennzeichen;
	private int kunde_ID;
	
	

	public Kfz() {
		super();
	}

	public Kfz(int kfz_ID, String marke, String modell, String kennzeichen,
			int kunde_ID) {
		
		this.kfz_ID = kfz_ID;
		this.marke = marke;
		this.modell = modell;
		this.kennzeichen = kennzeichen;
		this.kunde_ID = kunde_ID;
	}

	public int getKfz_ID() {
		return kfz_ID;
	}

	public void setKfz_ID(int kfz_ID) {
		this.kfz_ID = kfz_ID;
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getKennzeichen() {
		return kennzeichen;
	}

	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	public int getKunde_ID() {
		return kunde_ID;
	}

	public void setKunde_ID(int kunde_ID) {
		this.kunde_ID = kunde_ID;
	}
	
}
