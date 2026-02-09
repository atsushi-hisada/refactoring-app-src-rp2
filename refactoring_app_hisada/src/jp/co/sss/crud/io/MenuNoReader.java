package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * メニューナンバーを入力するクラス
 */
public class MenuNoReader {

	/**
	 * メニューナンバーを入力
	 * @return メニューナンバー
	 * @throws IOException
	 */
	public static Integer InputMenuNo() throws IllegalInputException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// メニューナンバーを入力
		try {
			String inputMenuNoString = br.readLine();
			return Integer.parseInt(inputMenuNoString);
		} catch (IOException e) {
			throw new IllegalInputException(ConstantMsg.INPUT_ERROR_MENU_NUMBER, e);
		}
	}
}
