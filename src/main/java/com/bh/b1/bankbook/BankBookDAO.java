package com.bh.b1.bankbook;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bh.b1util.DBConnector;

public class BankBookDAO {
	
	private DBConnector dbConnector;
	
	public BankBookDAO() {
		dbConnector = new DBConnector();
	}
	
	//setInsert
	public int setInsert(BankBookDTO bankBookDTO) {
		
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		int result = 0;
		
		String sql = "INSERT INTO BANKBOOK(booknumber, bookname, bookrate, bookuse) VALUES(BANKBOOK_SEQ.NEXTVAL, ?, ?, ?)";
		try {
			st = con.prepareStatement(sql);

			st.setString(1, bankBookDTO.getBookName());
			st.setDouble(2, bankBookDTO.getBookRate());
			st.setInt(3, bankBookDTO.getBookUse());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(st, con);
		}
		
		return result;
	}
	
	
	
	//getList
	public ArrayList<BankBookDTO> getList() {
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		String sql = "SELECT * FROM BANKBOOK";
		try {
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()){
			BankBookDTO result = new BankBookDTO();
			result.setBookNumber(rs.getLong("bookNumber"));
			result.setBookName(rs.getString("bookName"));
			result.setBookRate(rs.getDouble("bookRate"));
			result.setBookUse(rs.getInt("bookUse"));
			ar.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(rs, st, con);
		}
		
		return ar;
	}
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) {
		

		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		BankBookDTO result = null;
		
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUMBER=?";
		
		try {
			
			st = con.prepareStatement(sql);
			
			st.setLong(1, bankBookDTO.getBookNumber());
			
			rs =st.executeQuery();
			if(rs.next()){
				result = new BankBookDTO();
				result.setBookNumber(rs.getLong("BOOKNUMBER"));
				result.setBookName(rs.getString("BOOKNAME"));
				result.setBookRate(rs.getDouble("BOOKRATE"));
				result.setBookUse(rs.getInt("BOOKUSE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(rs, st, con);
		}
		
		return result;
		
	}
}
