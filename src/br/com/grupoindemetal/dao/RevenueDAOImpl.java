package br.com.grupoindemetal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.grupoindemetal.models.Revenue;

public class RevenueDAOImpl extends OracleConnection implements RevenueDAO {
	
	private Statement stm;
	private ResultSet rs;

	// Implementation for all revenues by year and company
	@Override
	public List<Revenue> getAllRevenuesByYearCompany(int year, int company) {
		conn = createConnection();
		List<Revenue> revenues = new ArrayList<Revenue>();
		Revenue revenue = null;
		try {
			stm = conn.createStatement();
			PreparedStatement pstm = conn.prepareStatement(RevenueQueries.ALL_REVENUES_BY_YEAR_COMPANY);
			pstm.setInt(1, company);
			pstm.setInt(2, year);			
			rs = pstm.executeQuery();
			while (rs.next() == true) {
				revenue = new Revenue();
				revenue.setMonth(rs.getString("month"));
				revenue.setTotal(rs.getFloat("total"));
				revenues.add(revenue);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return revenues;
	}

}
