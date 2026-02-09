package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員IDを入力するクラス
 */
public class EmployeeEmpIdReader implements IConsoleReader {
	/**
	 * 社員IDを入力
	 * @return 社員ID
	 */
	public Object input() throws SystemErrorException,
			IllegalInputException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputEmpIdString = null;

		try {
			// 社員IDを入力
			inputEmpIdString = br.readLine();
			// 入力チェック
			if (!isValid(inputEmpIdString)) {
				String errorMsg = getErrorMsg();
				throw new IllegalInputException(errorMsg);
			}
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);
		}
		// 数字に変換する
		if (isParseInt()) {
			return Integer.parseInt(inputEmpIdString);
		}

		return inputEmpIdString;
	}

	/**
	 *	エラーメッセージを返す
	 */
	@Override
	public String getErrorMsg() {
		return ConstantMsg.INPUT_ERROR_EMP_ID;
	}

	/**
	 * 入力チェック
	 */
	@Override
	public boolean isValid(String inputString) {
		//1~9999までの整数
		return inputString.matches("^[1-9１-９]{1}[0-9１-９]{0,3}$");
	}

	/**
	 * 数値に変換
	 */
	@Override
	public boolean isParseInt() {
		return true;
	}

}
