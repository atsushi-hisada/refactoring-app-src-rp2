package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;

/**
 * 全ての社員情報を検索を表示するクラス
 */
public class EmployeeAllFindService {
	/**
	 * 全ての社員情報を検索を表示
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws ParseException
	 */
	public static void findAll() throws ClassNotFoundException, SQLException, ParseException {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = EmployeeDAO.findAll();

		// 社員情報を表示
		ConsoleWriter.showEmployees(employeeList);
	}
}
