package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue.MenuItem;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MenuItem menuItem;
		do {
			// メニューの表示
			System.out.println(ConstantMsg.MENU_TITLE);
			System.out.println(ConstantMsg.MENU_FINDALL);
			System.out.println(ConstantMsg.MENU_FINDBYEMPNAME);
			System.out.println(ConstantMsg.MENU_FINDBYDEPTID);
			System.out.println(ConstantMsg.MENU_INSERT_EMPLOYEE);
			System.out.println(ConstantMsg.MENU_UPDATE_EMPLOYEE);
			System.out.println(ConstantMsg.MENU_DELETE_EMPLOYEE);
			System.out.println(ConstantMsg.MENU_EXIT);
			System.out.print(ConstantMsg.INPUT_MENU_NUMBER);

			// メニュー番号の入力
			String inputMenuNumberStr = br.readLine();
			int inputMenuNumber = Integer.parseInt(inputMenuNumberStr);
			menuItem = MenuItem.getByMenuNumber(inputMenuNumber);
			// 機能の呼出
			switch (menuItem) {
			case MENU_SELECT_ALL:
				// 全件表示機能の呼出
				DBController.findAll();
				break;

			case MENU_SEARCH_EMP_NAME:
				// 社員名検索
				System.out.print(ConstantMsg.INPUT_EMP_NAME);

				// 検索機能の呼出
				DBController.findByEmpName();
				break;

			case MENU_SEARCH_DEPT_ID:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.INPUT_DEPT_ID);
				String deptId = br.readLine();

				// 検索機能の呼出
				DBController.findByDeptId(deptId);
				break;

			case MENU_INSERT:
				// 登録する値を入力
				System.out.print(ConstantMsg.INPUT_MENU_NUMBER);
				String empName = br.readLine();
				System.out.print(ConstantMsg.INPUT_GENDER);
				String gender = br.readLine();
				System.out.print(ConstantMsg.INPUT_BIRTHDAY);
				String birthday = br.readLine();
				System.out.print(ConstantMsg.INPUT_DEPT_ID);
				deptId = br.readLine();

				// 登録機能の呼出
				DBController.insertEmployee(empName, gender, birthday, deptId);
				break;

			case MENU_UPDATE:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.UPDATE_INPUT_EMP_ID);

				// 更新する値を入力する
				String updateEmpId = br.readLine();
				Integer.parseInt(updateEmpId);

				// 更新機能の呼出
				DBController.updateEmployee(updateEmpId);
				System.out.println(ConstantMsg.UPDATE_COMPLETE);

				break;

			case MENU_DELETE:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.DELETE_INPUT_EMP_ID);

				// 削除機能の呼出
				DBController.deleteEmployee();
				break;
			case MENU_EXIT:
				System.out.println(ConstantMsg.EXIT);
			}
		} while (menuItem != MenuItem.MENU_EXIT);
	}
}
