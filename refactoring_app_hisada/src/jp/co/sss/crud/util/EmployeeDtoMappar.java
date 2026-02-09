package jp.co.sss.crud.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantValue.Gender;

/**
 * DTOに格納するクラス
 */
public class EmployeeDtoMappar {

	// ResultSetからDTOにセット
	public static Employee employeeDtoMappar(ResultSet resultSet) throws SQLException {

		// Dtoに格納できるようにそれぞれを型変換
		Integer empId = resultSet.getInt(ConstantValue.COL_EMP_ID);
		String empName = resultSet.getString(ConstantValue.COL_EMP_NAME);
		Gender gender = Gender.getGender(resultSet.getInt(ConstantValue.COL_GENDER));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ConstantValue.DATE_FORMAT);
		LocalDate bitrhday = LocalDate.parse(resultSet.getString(ConstantValue.COL_BIRTHDAY), dtf);
		String deptName = resultSet.getString(ConstantValue.COL_DEPT_NAME);
		Department department = new Department(deptName);
		// Dtoに格納
		Employee empDto = new Employee(empId, empName, gender, bitrhday, department);
		return empDto;
	}
}
