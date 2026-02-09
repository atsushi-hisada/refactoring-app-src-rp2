package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;

/**
 * 社員情報を更新するクラス
 */
public class EmployeeUpdateService {

	/**
	 * 	社員情報を更新
	 * 
	 * @param empIdString
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void updateEmployee(String empIdString)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		EmployeeDAO.updateEmployee(empIdString);
	}
}
