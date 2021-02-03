package ru.aplana.Pars;

import java.util.List;

public class Organizations {

	private String name;
	private String adress;
	private int phoneNumber;
	private int inn;
	private int ogrn;
	private String dateFoundation;
	private List<SecurityPaper> securityPaper;
	public String getName() {
		return name;
	}
	public String getAdress() {
		return adress;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public int getInn() {
		return inn;
	}
	public int getOgrn() {
		return ogrn;
	}
	public String getDateFoundation() {
		return dateFoundation;
	}
	public List<SecurityPaper> getSecurityPaper() {
		return securityPaper;
	}
}

