package main;

import java.sql.SQLException;

import JDBC.CreateAdmin;
import Menu.MainMenu;

public class Main {

	public static void main(String[] args) throws SQLException {
		CreateAdmin.createUser();
		
//		MainMenu.menu();
	}

}
