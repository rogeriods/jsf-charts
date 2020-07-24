package br.com.grupoindemetal.dao;

import java.util.List;

import br.com.grupoindemetal.models.Revenue;

public interface RevenueDAO {
	
	// Signature for all revenues by year and company
	public List<Revenue> getAllRevenuesByYearCompany(int year, int company);

}
