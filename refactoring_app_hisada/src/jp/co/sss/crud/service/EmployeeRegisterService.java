package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;

/**
 * 新規登録するクラス
 */
public class EmployeeRegisterService {

	/**
	 * 新規登録
	 * 
	 * @param empName
	 * @param genderString
	 * @param bitrhdayString
	 * @param deptIdString
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void insertEmployee(String empName, String genderString, String bitrhdayString,
			String deptIdString) throws ClassNotFoundException, SQLException, IOException, ParseException {
		EmployeeDAO.insertEmployee(empName, genderString, bitrhdayString, deptIdString);
	}
}
