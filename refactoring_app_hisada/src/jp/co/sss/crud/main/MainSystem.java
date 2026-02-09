package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeDeleteService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
import jp.co.sss.crud.service.EmployeeUpdateService;
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
			int inputMenuNumber = MenuNoReader.InputMenuNo();
			menuItem = MenuItem.getByMenuNumber(inputMenuNumber);
			// 機能の呼出
			switch (menuItem) {
			case MENU_SELECT_ALL:
				// 全件表示機能の呼出
				EmployeeAllFindService.findAll();
				break;

			case MENU_SEARCH_EMP_NAME:
				// 検索機能の呼出
				EmployeeFindByEmpNameService.findByEmpName();
				break;

			case MENU_SEARCH_DEPT_ID:
				// 検索機能の呼出
				EmployeeFindByDeptIdService.findByDeptId();
				break;

			case MENU_INSERT:
				// 登録機能の呼出
				EmployeeRegisterService.insertEmployee();
				break;

			case MENU_UPDATE:
				// 更新機能の呼出
				EmployeeUpdateService.updateEmployee();
				break;

			case MENU_DELETE:
				// 削除機能の呼出
				EmployeeDeleteService.deleteEmployee();
				break;

			case MENU_EXIT:
				System.out.println(ConstantMsg.EXIT);
			}
		} while (menuItem != MenuItem.MENU_EXIT);
	}
}
