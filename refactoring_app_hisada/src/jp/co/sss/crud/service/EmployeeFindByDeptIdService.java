package jp.co.sss.crud.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.util.ConstantMsg;

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
	public static void execute()
			throws SystemErrorException, IllegalInputException {

		List<Employee> employeeList = new ArrayList<Employee>();
		System.out.println(ConstantMsg.SEARCH_DEPT_ID);

		EmployeeDeptIdReader employeeDeptIdReader = new EmployeeDeptIdReader();
		// 部署IDを入力
		Integer inputDeptId = (Integer) employeeDeptIdReader.input();
		// 部署IDで検索した社員情報をリストに
		employeeList = EmployeeDAO.findByDeptId(inputDeptId);
		// 社員情報を表示
		ConsoleWriter.showEmployees(employeeList);
	}

}
