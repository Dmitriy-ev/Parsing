package ru.aplana.Pars;

public class SecurityPaper {

	private String nameOrganization;
	private int id;
	private String name;
	private String dataExpiry;
	private String currency;
	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDataExpiry() {
		return dataExpiry;
	}

	public String getNameOrganization() {
		return nameOrganization;
	}

	public String getCurrency() {
		return currency;
	}
	
	@Override
	public String toString() {
		return "Компания: " + nameOrganization + ", ID бумаги: " + getId() + ", Название бумаги: " + getName() + ", дата истечения: " + dataExpiry; 
	}

}
