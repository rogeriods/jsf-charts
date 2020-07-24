package br.com.grupoindemetal.dao;

public class RevenueQueries {
	
	// Query for revenues by year and company
	public static final String ALL_REVENUES_BY_YEAR_COMPANY = ""
			+ "SELECT to_char(datemi, 'MM') AS month, SUM(vlrliq) AS total " 
			+ "FROM e140nfv WHERE sitnfv = 2 AND codemp = ? AND to_char(datemi, 'YYYY') = ? " 
			+ "GROUP BY to_char(datemi, 'MM') "
			+ "ORDER BY month";

}
