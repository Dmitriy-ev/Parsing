package ru.aplana.Pars;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PointTask {

	ObjectMapper mapper = new ObjectMapper();
	
	public void getAllCompany(List<Organizations> list) {
		list.stream()
		.forEach(x -> System.out.println("Название компании - " + x.getName() + ", дата основания " 
		+ x.getDateFoundation()));
	}
	public List<SecurityPaper> getFilterNewArrayList() {
		
		List<SecurityPaper> arrayPaper = new ArrayList<>();
		Iterator<Organizations> iter = parseMapper().iterator();
		while(iter.hasNext()) {
			arrayPaper.addAll(iter.next().getSecurityPaper());
		}
		
		LocalDate data = LocalDate.now();
		return arrayPaper.stream()
		.filter(s -> LocalDate.parse(s.getDataExpiry()).isBefore(data))
		.collect(Collectors.toList());
		
	}
	public List<SecurityPaper> getAllPaper(List<Organizations> org, Predicate<SecurityPaper> predicate){
		
		return org.stream().
					flatMap(c -> c.getSecurityPaper().stream())
					.filter(predicate)
					.collect(Collectors.toList());
	}
	
	public void getAllDataAfter(String data){
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yy");
//		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate local = LocalDate.parse(data, formatter1);
		parseMapper().stream()
				.filter(s -> LocalDate.parse(s.getDateFoundation()).isAfter(local))
				.forEach(x -> System.out.println("Компания: " + x.getName() + " дата основания " + 
				x.getDateFoundation()));
	}
	
	public void getAllCurrency(String currency) {
		
		List<SecurityPaper> arrayCurrency = new ArrayList<>();
		Iterator<Organizations> iter = parseMapper().iterator();
		while(iter.hasNext()) {
			arrayCurrency.addAll(iter.next().getSecurityPaper());
		}
		
		arrayCurrency.stream()
		.filter(s -> s.getCurrency().equals(currency))
		.forEach(x -> System.out.println("ID: " + x.getId() + " код валюты " + x.getCurrency()));
	}
	
	public List<Organizations> parseMapper() {
		List<Organizations> list = null;
		try {
			list = mapper.readValue(new File("parsingTest.json"), new TypeReference<List<Organizations>>() {});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void securityData() {
		List<SecurityPaper> security = getAllPaper(parseMapper(), s -> LocalDate.parse(s.getDataExpiry()).isBefore(LocalDate.now()));
		security.forEach(System.out::println);
	}
	
}
