package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * コンソール出力を管理するクラス
 */
public class ConsoleWriter {

	// 社員情報を表示
	public static void showEmployees(List<Employee> employeeList) {

		if (employeeList.isEmpty()) {
			showNonExistTarget();//対象者がいませんでした と表示 
		} else {
			showHeader();
			for (Employee employee : employeeList) {
				System.out.println(employee);
			}
		}
	}

	//メニュー表示
	public static void showMenu() {

		System.out.println(ConstantMsg.MENU_TITLE);
		System.out.println(ConstantMsg.MENU_FINDALL);
		System.out.println(ConstantMsg.MENU_FINDBYEMPNAME);
		System.out.println(ConstantMsg.MENU_FINDBYDEPTID);
		System.out.println(ConstantMsg.MENU_INSERT_EMPLOYEE);
		System.out.println(ConstantMsg.MENU_UPDATE_EMPLOYEE);
		System.out.println(ConstantMsg.MENU_DELETE_EMPLOYEE);
		System.out.println(ConstantMsg.MENU_EXIT);
		System.out.print(ConstantMsg.INPUT_MENU_NUMBER);
	}

	// レコードのカラム部分の表示
	private static void showHeader() {
		System.out.println(ConstantMsg.EMPLOYEE_LIST);
	}

	//該当者がいなかった場合
	private static void showNonExistTarget() {
		System.out.println(ConstantMsg.NOT_FOUND);
	}
}
