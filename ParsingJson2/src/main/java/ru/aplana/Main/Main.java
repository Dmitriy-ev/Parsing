package ru.aplana.Main;

import ru.aplana.Pars.PointTask;

public class Main {

	public static void main(String[] args) {

		PointTask task1 = new PointTask();
		System.out.println("Все имеющиеся компании: ");
		task1.getAllCompany(task1.parseMapper());
		task1.securityData();
		System.out.println("Сумма бумаг = " + task1.getFilterNewArrayList().size());
		task1.getAllDataAfter("20/02/01");
		task1.getAllCurrency("RU");
		
	}

}
