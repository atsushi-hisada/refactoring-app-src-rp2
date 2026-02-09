package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員名に該当する社員情報を表示させるクラス
 */
public class EmployeeFindByEmpNameService {
	/**
	 * 社員名に該当する社員情報を表示
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws ParseException
	 * @throws IOException 
	 */
	public static void findByEmpName()
			throws ClassNotFoundException, SQLException, ParseException, IOException {
		List<Employee> employeeList = new ArrayList<Employee>();
		// 社員名検索
		System.out.print(ConstantMsg.INPUT_EMP_NAME);
		String inputEmpName = EmployeeNameReader.InputEmpName();
		employeeList = EmployeeDAO.findByEmpName(inputEmpName);

		// 社員情報を表示
		ConsoleWriter.showEmployees(employeeList);
	}
}
