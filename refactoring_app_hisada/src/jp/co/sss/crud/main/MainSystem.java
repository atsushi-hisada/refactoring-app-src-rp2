package jp.co.sss.crud.main;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.ConsoleWriter;
import jp.co.sss.crud.service.IEmployeeService;
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
				// サービスのインスタンスを生成
				IEmployeeService service = IEmployeeService.getInstanceByMenuNo(menuItem);
				// 何も入っていない場合終了する
				if (service == null) {
					break;
				}
				// サービスの実行
				service.execute();

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
