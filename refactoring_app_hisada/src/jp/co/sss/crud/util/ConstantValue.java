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

		// 引数と一致するインデックスを持つ定数を返す
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

	// 性別
	public static enum Gender {
		GENDER_NO_ANSWER(0, "回答なし"), 
		GENDER_MAN(1, "男性"), 
		GENDER_WOMAN(2, "女性"), 
		GENDER_OTHERS(9, "その他");

		private int genderNumber;
		private String genderLabel;

		private Gender(int genderNumber, String genderLabel) {
			this.genderNumber = genderNumber;
			this.genderLabel = genderLabel;
		}

		public int getGenderNumber() {
			return genderNumber;
		}

		public String getGenderLabel() {
			return genderLabel;
		}

		// 引数と一致するインデックスを持つ定数を返す
		public static Gender getGender(int inputGenderNumber) {
			for (Gender gender : Gender.values()) {
				if (gender.getGenderNumber() == inputGenderNumber) {
					return gender;
				}
			}
			// 引数と一致する定数がなかった場合
			throw new IllegalArgumentException();
		}
	}

	// 部署
	public static enum Department {
		DEPT_SALES(1, "営業部"), 
		DEPT_ACCOUNTING(2, "経理部"), 
		DEPT_GENERAL_AFFAIRS(3, "総務部");

		private int deptNumber;
		private String deptLabel;

		private Department(int deptNumber, String deptLabel) {
			this.deptNumber = deptNumber;
			this.deptLabel = deptLabel;
		}

		public int getDeptNumber() {
			return deptNumber;
		}

		public String getDeptLabel() {
			return deptLabel;
		}

		// 引数と一致するインデックスを持つ定数を返す
		public static Department getDept(int inputDeptNumber) {
			for (Department dept : Department.values()) {
				if (dept.getDeptNumber() == inputDeptNumber) {
					return dept;
				}
			}
			// 引数と一致する定数がなかった場合
			throw new IllegalArgumentException();
		}
	}
}