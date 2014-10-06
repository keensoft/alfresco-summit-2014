package es.keensoft.repo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Test {
	
	private static final Log logger = LogFactory.getLog(Test.class);
	
	private String verifier;
	
	public void init() {
		logger.info("[REPO] Verifier value: " + getVerifier());
	}

	public String getVerifier() {
		return verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

}
