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
import jp.co.sss.crud.util.ConstantValue;
import jp.co.sss.crud.util.ConstantValue.Gender;

/**
 * 社員情報を更新するクラス
 */
public class EmployeeUpdateService implements IEmployeeService {

	/**
	 * 	社員情報を更新
	 * 
	 * @throws SystemErrorException 継続不能なエラー
	 * @throws IllegalInputException 不正入力エラー
	 */
	public void execute() throws SystemErrorException, IllegalInputException {

		// インスタンスを生成
		EmployeeEmpIdReader employeeEmpIdReader = new EmployeeEmpIdReader();
		EmployeeNameReader employeeNameReader = new EmployeeNameReader();
		EmployeeGenderReader employeeGenderReader = new EmployeeGenderReader();
		EmployeeBirthdayReader employeeBirthdayReader = new EmployeeBirthdayReader();
		EmployeeDeptIdReader employeeDeptIdReader = new EmployeeDeptIdReader();

		// 更新する社員IDを入力
		System.out.print(ConstantMsg.UPDATE_INPUT_EMP_ID);
		Integer updateEmpId = (Integer) employeeEmpIdReader.input();

		// 更新する値を入力
		String inputEmpName = (String) employeeNameReader.input();
		Gender inputGender = (Gender) employeeGenderReader.input();
		LocalDate inputBirthday = (LocalDate) employeeBirthdayReader.input();
		Integer inputDeptId = (Integer) employeeDeptIdReader.input();

		// 部署IDをDTOに入れるために部署クラスにセット
		Department department = new Department();
		department.setDeptId(inputDeptId);

		// Dtoに格納
		Employee empDto = new Employee(updateEmpId, inputEmpName, inputGender, inputBirthday, department);

		EmployeeDAO dao = new EmployeeDAO();
		// 更新
		Integer updateResult = dao.update(empDto);

		if (updateResult == ConstantValue.SQL_ERROR_RESULT) {
			// SQL文の実行が失敗した場合
			System.out.print(ConstantMsg.UPDATE_NOT_FOUND);
		} else {
			// 成功した場合
			System.out.print(ConstantMsg.UPDATE_COMPLETE);
		}

	}
}
