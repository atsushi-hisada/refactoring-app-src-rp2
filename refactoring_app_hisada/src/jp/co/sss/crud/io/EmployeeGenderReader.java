package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue.Gender;

/**
 * 性別入力クラス
 */
public class EmployeeGenderReader implements IConsoleReader {

	/**
	 * 性別を入力
	 */
	public Object input() throws SystemErrorException, IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputGenderString = null;
		try {
			// 性別を入力
			System.out.print(ConstantMsg.INPUT_GENDER);
			inputGenderString = br.readLine();
			// 入力チェック
			if (!isValid(inputGenderString)) {
				String errorMsg = getErrorMsg();
				throw new IllegalInputException(errorMsg);
			}
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);
		}
		if (isParseInt()) {
			// インデックスから性別を取得
			Gender inputGender = Gender.getGender(Integer.parseInt(inputGenderString));
			return inputGender;
		}
		return inputGenderString;
	}

	/**
	 *	エラーメッセージを返す
	 */
	@Override
	public String getErrorMsg() {
		return ConstantMsg.INPUT_ERROR_GENDER;
	}

	/**
	 * 入力チェック
	 */
	@Override
	public boolean isValid(String inputString) {
		//0,1,2,9の整数
		return inputString.matches("^|[0129０１２９]{1}$");
	}

	/**
	 * 数値に変換
	 */
	@Override
	public boolean isParseInt() {
		return true;
	}
}
