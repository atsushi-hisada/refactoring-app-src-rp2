package jp.co.sss.crud.util;

/**
 * メッセージ定数用クラス
 */
public class ConstantMsg {
	// 社員情報
	public static final String EMPLOYEE_LIST = "社員ID\t社員名\t性別\t生年月日\t部署名";

	//メニュー表示
	public static final String MENU_TITLE = "=== 社員管理システム ===";
	public static final String MENU_FINDALL = "1.全件表示";
	public static final String MENU_FINDBYEMPNAME = "2.社員名検索";
	public static final String MENU_FINDBYDEPTID = "3.部署ID検索";
	public static final String MENU_INSERT_EMPLOYEE = "4.新規登録";
	public static final String MENU_UPDATE_EMPLOYEE = "5.更新";
	public static final String MENU_DELETE_EMPLOYEE = "6.削除";
	public static final String MENU_EXIT = "7.終了";

	//入力前に表示されるテキスト
	public static final String INPUT_MENU_NUMBER = "メニュー番号を入力してください：";
	public static final String INPUT_EMP_NAME = "社員名:";
	public static final String INPUT_GENDER = "性別(0:その他, 1:男性, 2:女性, 9:回答なし):";
	public static final String INPUT_BIRTHDAY = "生年月日(西暦年/月/日):";
	public static final String INPUT_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部):";

	// 登録機能
	public static final String REGISTER_COMPLETE = "社員情報を登録しました";

	// 更新機能
	public static final String UPDATE_INPUT_EMP_ID = "更新する社員の社員IDを入力してください：";
	public static final String UPDATE_COMPLETE = "社員情報を更新しました";

	// 削除機能
	public static final String DELETE_INPUT_EMP_ID = "削除する社員の社員IDを入力してください：";
	public static final String DELETE_COMPLETE = "社員情報を削除しました";

	public static final String EXIT = "システムを終了します。";

	public static final String NOT_FOUND = "該当者はいませんでした";

}
