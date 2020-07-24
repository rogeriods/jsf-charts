package br.com.grupoindemetal.web;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.grupoindemetal.dao.RevenueDAO;
import br.com.grupoindemetal.dao.RevenueDAOImpl;
import br.com.grupoindemetal.models.Revenue;

@ManagedBean
public class RevenueFaces {
	
	private int year, company;
	private String graphData;
	
	private RevenueDAO dao = new RevenueDAOImpl();
	
	// Constructor
	public RevenueFaces() {
		// Set default form values
		this.year = 2020;
		this.company = 1;
		this.graphData = Arrays.toString(new float[12]);
	}
	
	// Form actions
	public String fillGraph() {
		List<Revenue> revenues = dao.getAllRevenuesByYearCompany(this.year, this.company);
		setGraphData(Arrays.toString(fillFloatArray(revenues)));
		return "revenues.xhtml";
	}
	
	// Complementary methods
	// Break a list of object into a float array values
	public float[] fillFloatArray(List<Revenue> revenues) {
		float[] revenueArray = new float[revenues.size()];
		int index = 0;
		for (Revenue revenue : revenues) {
			revenueArray[index] = revenue.getTotal();
			index++;
		}
		return revenueArray;
	}
	
	// Getters and setters for XHTML forms
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getCompany() {
		return company;
	}
	
	public void setCompany(int company) {
		this.company = company;
	}
	
	public String getGraphData() {
		return graphData;
	}
	
	public void setGraphData(String graphData) {
		this.graphData = graphData;
	}
	
}
