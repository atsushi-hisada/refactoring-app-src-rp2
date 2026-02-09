package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * メニューナンバーを入力するクラス
 */
public class MenuNoReader {

	/**
	 * メニューナンバーを入力
	 * @return メニューナンバー
	 * @throws IOException
	 */
	public static Integer InputMenuNo() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// メニューナンバーを入力
		String inputMenuNoString = br.readLine();
		return Integer.parseInt(inputMenuNoString);
	}
}
