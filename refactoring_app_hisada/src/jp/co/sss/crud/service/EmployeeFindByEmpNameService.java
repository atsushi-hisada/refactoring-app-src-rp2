package jp.co.sss.crud.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員名に該当する社員情報を表示させるクラス
 */
public class EmployeeFindByEmpNameService implements IEmployeeService {

	/**
	 * 社員名に該当する社員情報を表示
	 *
	 * @throws SystemErrorException 継続不能なエラー
	 * @throws IllegalInputException 不正入力エラー
	 */
	public void execute()
			throws SystemErrorException, IllegalInputException {
		List<Employee> employeeList = new ArrayList<Employee>();
		// 社員名検索
		System.out.println(ConstantMsg.SEARCH_EMP_NAME);
		EmployeeNameReader employeeNameReader = new EmployeeNameReader();
		// 社員名を入力
		String inputEmpName = (String) employeeNameReader.input();
		EmployeeDAO dao = new EmployeeDAO();
		// 入力された値と一致する社員情報をリストに追加
		employeeList = dao.findByEmployeeName(inputEmpName);

		// 社員情報を表示
		ConsoleWriter.showEmployees(employeeList);
	}
}
