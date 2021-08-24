package com.bh.b1.test;

import com.bh.b1.bankbook.BankBookDAO;
import com.bh.b1.bankbook.BankBookDTO;
import com.bh.b1util.DBConnector;
import java.sql.Connection;
import java.util.ArrayList;

public class DBTest {

	public static void main(String[] args) {
		
		//BankBookDAO getSelect Test
		BankBookDAO bankBookDAO = new BankBookDAO();
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBookNumber(1);
//		
//		bankBookDTO = bankBookDAO.getSelect(bankBookDTO);
//		
//		System.out.println(bankBookDTO.getBookName());

		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
//		System.out.println(ar.size());
		for(int i=0;i<ar.size();i++) {
			System.out.println("BOOKNUMBER : "+ar.get(i).getBookNumber());
			System.out.println("BOOKNAME   : "+ar.get(i).getBookName());
			System.out.println("BOOKRATE   : "+ar.get(i).getBookRate());
			System.out.println("BOOKUSE    : "+ar.get(i).getBookUse());
			System.out.println("=======================");
		}
	}

}
