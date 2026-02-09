package jp.co.sss.crud.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;

/**
 * 全ての社員情報を検索を表示するクラス
 */
public class EmployeeAllFindService implements IEmployeeService {

	/**
	 * 全ての社員情報を検索を表示
	 *
	 * @throws SystemErrorException 継続不能なエラー
	 */
	public void execute() throws SystemErrorException {

		List<Employee> employeeList = new ArrayList<Employee>();
		EmployeeDAO dao = new EmployeeDAO();
		// 全件検索した情報をリストへ
		employeeList = dao.findAll();
		// 社員情報を表示
		ConsoleWriter.showEmployees(employeeList);
	}
}
