package utils;

public class UrlProvider {

	private final String v1ProductionUrl = "https://demo.applitools.com/tlcHackathonMasterV1.html"; 
	private final String devBranchUrl = "https://demo.applitools.com/tlcHackathonDev.html"; 
	private final String finalProductionUrl = "https://demo.applitools.com/tlcHackathonMasterV2.html"; 
	
	public String getV1ProductionUrl() {
		return v1ProductionUrl;
	}
	
	public String getDevBranchUrl() {
		return devBranchUrl;
	}

	public String getFinalProductionUrl() {
		return finalProductionUrl;
	}
}
