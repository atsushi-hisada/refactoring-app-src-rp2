package jp.co.sss.crud.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantValue.Gender;

/**
 * DTOに格納するクラス
 */
public class EmployeeDtoMappar {

	// ResultSetからDTOにセット
	public static Employee employeeDtoMappar(ResultSet resultSet) throws SQLException, ParseException {

		// Dtoに格納できるようにそれぞれを型変換
		Integer empId = resultSet.getInt(ConstantValue.COL_EMP_ID);
		String empName = resultSet.getString(ConstantValue.COL_EMP_NAME);
		Gender gender = Gender.getGender(resultSet.getInt(ConstantValue.COL_GENDER));
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT);
		Date bitrhday = sdf.parse(resultSet.getString(ConstantValue.COL_BIRTHDAY));
		String deptName = resultSet.getString(ConstantValue.COL_DEPT_NAME);
		Department department = new Department(deptName);
		// Dtoに格納
		Employee empDto = new Employee(empId, empName, gender, bitrhday, department);
		return empDto;
	}
}
