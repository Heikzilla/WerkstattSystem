package general;

public class Auftrag {
	private int auftrag_ID;
	private String arbeiten;
	private boolean erledigt;
	private int kfz_ID;
	
	
	
	public Auftrag() {
		super();
	}

	public Auftrag(int auftrag_ID, String arbeiten, boolean erledigt, int kfz_ID) {

		this.auftrag_ID = auftrag_ID;
		this.arbeiten = arbeiten;
		this.erledigt = erledigt;
		this.kfz_ID = kfz_ID;
	}

	public int getAuftrag_ID() {
		return auftrag_ID;
	}

	public void setAuftrag_ID(int auftrag_ID) {
		this.auftrag_ID = auftrag_ID;
	}

	public String getArbeiten() {
		return arbeiten;
	}

	public void setArbeiten(String arbeiten) {
		this.arbeiten = arbeiten;
	}

	public boolean isErledigt() {
		return erledigt;
	}

	public void setErledigt(boolean erledigt) {
		this.erledigt = erledigt;
	}

	public int getKfz_ID() {
		return kfz_ID;
	}

	public void setKfz_ID(int kfz_ID) {
		this.kfz_ID = kfz_ID;
	}
	
	
}
