package com.bh.b1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bh.b1util.DBConnector;

public class MemberDAO {
	private DBConnector dbConnector;
	
	public MemberDAO() {
		dbConnector = new DBConnector();
	}
	
	public int getJoin(MemberDTO memberDTO) throws Exception {
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		int result = 0;
		
		String sql = "insert into member values(?,?,?,?,?)";
		
		st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
			
		result = st.executeUpdate();
		
		dbConnector.disConnect(st, con);
		
		return result;
		
	}

}
