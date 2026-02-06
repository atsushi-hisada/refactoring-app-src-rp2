package jp.co.sss.crud.util;

/**
 * 定数定義用クラス
 */
public class ConstantValue {

	// メニュー表示
	public static enum MenuItem {
		MENU_SELECT_ALL(1), MENU_SEARCH_EMP_NAME(2), MENU_SEARCH_DEPT_ID(3), MENU_INSERT(4), MENU_UPDATE(
				5), MENU_DELETE(6), MENU_EXIT(7);

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
		GENDER_NO_ANSWER(0, "回答なし"), GENDER_MAN(1, "男性"), GENDER_WOMAN(2, "女性"), GENDER_OTHERS(9, "その他");

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
		DEPT_SALES(1, "営業部"), DEPT_ACCOUNTING(2, "経理部"), DEPT_GENERAL_AFFAIRS(3, "総務部");

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

	// employeeテーブルのカラム
	public static final String COL_EMP_ID = "emp_id";
	public static final String COL_EMP_NAME = "emp_name";
	public static final String COL_GENDER = "gender";
	public static final String COL_BIRTHDAY = "birthday";
	public static final String COL_DEPT_ID = "dept_id";
	public static final String COL_DEPT_NAME = "dept_name";

	// 社員名検索のインデックス
	public static final int FIND_INDEX_EMP_NAME = 1;

	// 部署名検索のインデックス
	public static final int FIND_INDEX_DEPT_ID = 1;

	// 登録機能および更新機能のインデックス
	public static final int SAVE_INDEX_EMP_NAME = 1;
	public static final int SAVE_INDEX_GENDER = 2;
	public static final int SAVE_INDEX_BIRTHDAY = 3;
	public static final int SAVE_INDEX_DEPT_ID = 4;
	public static final int SAVE_INDEX_EMP_ID = 5;

	// 削除機能のインデックス
	public static final int DELETE_INDEX_EMP_ID = 1;

	// 日付のフォーマット
	public static final String DATE_FORMAT = "yyyy/MM/dd";

}