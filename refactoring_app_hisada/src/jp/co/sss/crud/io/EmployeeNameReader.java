package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員名を入力するクラス
 */
public class EmployeeNameReader implements IConsoleReader {
	/**
	 * 社員名を入力
	 * @return 社員名
	 * @throws IOException
	 */
	public Object input() throws SystemErrorException, IllegalInputException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String InputEmpName = null;

		try {
			// 社員名を入力
			System.out.print(ConstantMsg.INPUT_EMP_NAME);
			InputEmpName = br.readLine();
			if (!isValid(InputEmpName)) {
				String errorMsg = getErrorMsg();
				throw new IllegalInputException(errorMsg);
			}
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);
		}

		// 数字に変換しない
		if (isParseInt()) {
			return Integer.parseInt(InputEmpName);
		}

		return InputEmpName;
	}

	/**
	 *	エラーメッセージを返す
	 */
	@Override
	public String getErrorMsg() {
		return ConstantMsg.INPUT_ERROR_EMP_NAME;
	}

	/**
	 * 入力チェック
	 */
	@Override
	public boolean isValid(String inputString) {
		// 1文字以上30文字以下かチェック
		if (inputString.length() >= 1 && 30 >= inputString.length()) {
			return true;
		}
		return false;
	}

	/**
	 * 数値に変換
	 */
	@Override
	public boolean isParseInt() {
		return false;
	}
}
