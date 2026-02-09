package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * メニューナンバーを入力するクラス
 */
public class MenuNoReader implements IConsoleReader {

	/**
	 * メニューナンバーを入力
	 * @return メニューナンバー
	 * @throws IOException
	 */
	public Object input() throws SystemErrorException,
			IllegalInputException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputMenuNoString = null;

		try {
			// メニューナンバーを入力
			inputMenuNoString = br.readLine();
			// 入力チェック
			if (!isValid(inputMenuNoString)) {
				String errorMsg = getErrorMsg();
				throw new IllegalInputException(errorMsg);
			}
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);
		}

		// 数字に変換する
		if (isParseInt()) {
			return Integer.parseInt(inputMenuNoString);
		}

		return inputMenuNoString;
	}

	/**
	 *	エラーメッセージを返す
	 */
	@Override
	public String getErrorMsg() {
		return ConstantMsg.INPUT_ERROR_MENU_NUMBER;
	}

	/**
	 * 入力チェック
	 */
	@Override
	public boolean isValid(String inputString) {
		//1~7までの整数
		return inputString.matches("^[1-7１-７]$");
	}

	/**
	 * 数値に変換する
	 */
	@Override
	public boolean isParseInt() {
		return true;
	}
}
