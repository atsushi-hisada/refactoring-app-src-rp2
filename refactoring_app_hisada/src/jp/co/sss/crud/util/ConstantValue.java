package jp.co.sss.crud.util;

/**
 * 定数定義用クラス
 */
public class ConstantValue {

	// メニュー表示
	public static enum MenuItem {
		MENU_SELECT_ALL(1),
		MENU_SEARCH_EMP_NAME(2), 
		MENU_SEARCH_DEPT_ID(3), 
		MENU_INSERT(4), 
		MENU_UPDATE(5),
		MENU_DELETE(6),
		MENU_EXIT(7);

		private int menuNumber;

		private MenuItem(int menuNumber) {
			this.menuNumber = menuNumber;
		}

		public int getMenuNumber() {
			return menuNumber;
		}

		// 引数と一致する定数を返す
		public static MenuItem getByMenuNumber(int inputMenuNumber) {
			for (MenuItem menuItem : MenuItem.values()) {
				if (menuItem.getMenuNumber() == inputMenuNumber) {
					return menuItem;
				}
			}
			// 引数と一致する定数がなかった場合
			throw new IllegalArgumentException();
		}
	}
	
	
}
