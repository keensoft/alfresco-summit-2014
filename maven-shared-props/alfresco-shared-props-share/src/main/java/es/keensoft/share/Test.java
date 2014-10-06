package es.keensoft.share;


public class Test {
	
	private String verifier;
	
	public void init() {
		// TODO config log4j
		System.out.println("[SHARE] Verifier value: " + getVerifier());
	}

	public String getVerifier() {
		return verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

}