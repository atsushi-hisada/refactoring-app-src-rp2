package jp.co.sss.crud.service;

import java.time.LocalDate;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue.Gender;

/**
 * 社員情報を更新するクラス
 */
public class EmployeeUpdateService {

	/**
	 * 	社員情報を更新
	 * 
	 * @throws SystemErrorException 継続不能なエラー
	 * @throws IllegalInputException 不正入力エラー
	 */
	public static void updateEmployee() throws SystemErrorException, IllegalInputException {
		// 更新する社員IDを入力
		System.out.print(ConstantMsg.UPDATE_INPUT_EMP_ID);
		Integer updateEmpId = EmployeeEmpIdReader.InputEmpId();
		// 更新する値を入力
		String inputEmpName = EmployeeNameReader.InputEmpName();
		Gender inputGender = EmployeeGenderReader.InputGender();
		LocalDate inputBirthday = EmployeeBirthdayReader.InputBirthday();
		Integer inputDeptId = EmployeeDeptIdReader.InputDeptId();
		Department department = new Department();
		department.setDeptId(inputDeptId);
		// Dtoに格納
		Employee empDto = new Employee(updateEmpId, inputEmpName, inputGender, inputBirthday, department);
		// 更新
		EmployeeDAO.updateEmployee(empDto);
	}
}
