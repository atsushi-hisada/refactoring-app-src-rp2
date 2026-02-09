package jp.co.sss.crud.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	private LocalDate birthday;
	// 所属部署
	private Department department;

	public Employee() {
	}

	public Employee(String empName, Gender gender, LocalDate birthday, Department department) {
		this.empName = empName;
		this.gender = gender;
		this.birthday = birthday;
		this.department = department;
	}

	public Employee(Integer empId, String empName, Gender gender, LocalDate birthday, Department department) {
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.birthday = birthday;
		this.department = department;
	}

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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ConstantValue.DATE_FORMAT);
		return this.getEmpId() + "\t" +
				this.getEmpName() + "\t" +
				this.getGender().getGenderLabel() + "\t" +
				dtf.format(getBirthday()) + "\t" +
				this.getDepartment().getDeptName();
	}
}
