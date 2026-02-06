package jp.co.sss.crud.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.sss.crud.util.ConstantValue;
import jp.co.sss.crud.util.ConstantValue.Gender;

/**
 * 社員情報管理用クラス
 * 
 * */
public class Employee {
	// 社員ID
	private Integer empId;
	// 社員名
	private String empName;
	// 性別
	private Gender gender;
	// 生年月日
	private Date birthday;
	// 所属部署
	private Department department;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	// レコードを表示
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT);
		return this.getEmpId() + "\t" +
				this.getEmpName() + "\t" +
				this.getGender().getGenderLabel() + "\t" +
				sdf.format(this.getBirthday()) + "\t" +
				this.getDepartment().getDeptName();
	}
}
