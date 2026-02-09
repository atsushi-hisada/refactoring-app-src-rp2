package jp.co.sss.crud.service;

import java.time.LocalDate;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantValue.Gender;

/**
 * 新規登録するクラス
 */
public class EmployeeRegisterService {

	/**
	 * 新規登録
	 * 
	 * @throws SystemErrorException 継続不能なエラー
	 * @throws IllegalInputException 不正入力エラー
	 */
	public static void execute() throws SystemErrorException, IllegalInputException {

		// インスタンスを生成
		EmployeeNameReader employeeNameReader = new EmployeeNameReader();
		EmployeeGenderReader employeeGenderReader = new EmployeeGenderReader();
		EmployeeBirthdayReader employeeBirthdayReader = new EmployeeBirthdayReader();
		EmployeeDeptIdReader employeeDeptIdReader = new EmployeeDeptIdReader();

		// 登録する値を入力
		String inputEmpName = (String) employeeNameReader.input();
		Gender inputGender = (Gender) employeeGenderReader.input();
		LocalDate inputBirthday = (LocalDate) employeeBirthdayReader.input();
		Integer inputDeptId = (Integer) employeeDeptIdReader.input();

		// 部署IDをDTOに入れるために部署クラスにセット
		Department department = new Department();
		department.setDeptId(inputDeptId);

		// Dtoに格納
		Employee empDto = new Employee(inputEmpName, inputGender, inputBirthday, department);

		// 入力した情報を登録
		EmployeeDAO.insertEmployee(empDto);
	}
}
