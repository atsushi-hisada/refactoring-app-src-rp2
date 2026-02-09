package jp.co.sss.crud.main;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.ConsoleWriter;
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
	 */
	public static void main(String[] args) {
		MenuItem menuItem = null;
		do {
			try {
				// メニューの表示
				ConsoleWriter.showMenu();
				// インスタンス生成
				MenuNoReader menuNoReader = new MenuNoReader();
				// メニュー番号の入力
				int inputMenuNumber = (int) menuNoReader.input();
				menuItem = MenuItem.getByMenuNumber(inputMenuNumber);

				// 機能の呼出
				switch (menuItem) {
				case MENU_SELECT_ALL:
					// 全件表示機能の呼出
					EmployeeAllFindService.execute();
					break;

				case MENU_SEARCH_EMP_NAME:
					// 検索機能の呼出
					EmployeeFindByEmpNameService.execute();
					break;

				case MENU_SEARCH_DEPT_ID:
					// 検索機能の呼出
					EmployeeFindByDeptIdService.execute();
					break;

				case MENU_INSERT:
					// 登録機能の呼出
					EmployeeRegisterService.execute();
					break;

				case MENU_UPDATE:
					// 更新機能の呼出
					EmployeeUpdateService.execute();
					break;

				case MENU_DELETE:
					// 削除機能の呼出
					EmployeeDeleteService.execute();
					break;

				case MENU_EXIT:
					break;
				}

			} catch (SystemErrorException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				break;

			} catch (IllegalInputException e) {
				System.out.println(e.getMessage());
				System.out.println();
				continue;
			}

		} while (menuItem != MenuItem.MENU_EXIT);
		System.out.println(ConstantMsg.EXIT);
	}
}
