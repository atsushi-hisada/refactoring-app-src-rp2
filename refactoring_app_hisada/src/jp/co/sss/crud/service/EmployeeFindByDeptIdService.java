package jp.co.sss.crud.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeDeptIdReader;

/**
 * 
 */
public class EmployeeFindByDeptIdService {

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws SystemErrorException 継続不能なエラー
	 * @throws IllegalInputException 不正入力エラー
	 */
	public static void findByDeptId()
			throws SystemErrorException, IllegalInputException {
		List<Employee> employeeList = new ArrayList<Employee>();
		// 部署IDを入力
		Integer inputDeptId = EmployeeDeptIdReader.InputDeptId();
		employeeList = EmployeeDAO.findByDeptId(inputDeptId);
		// 社員情報を表示
		ConsoleWriter.showEmployees(employeeList);
	}

}
