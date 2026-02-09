package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員情報を削除するクラス
 */
public class EmployeeDeleteService {
	/**
	 * 	社員情報を削除
	 * 
	 * @param empIdString
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void deleteEmployee()
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		// 削除する社員IDを入力
		System.out.print(ConstantMsg.DELETE_INPUT_EMP_ID);
		int deleteEmpId = EmployeeEmpIdReader.InputEmpId();
		EmployeeDAO.deleteEmployee(deleteEmpId);
	}
}
