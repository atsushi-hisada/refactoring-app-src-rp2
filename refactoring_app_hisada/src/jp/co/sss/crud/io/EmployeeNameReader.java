package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員名を入力するクラス
 */
public class EmployeeNameReader {
	/**
	 * 社員名を入力
	 * @return 社員名
	 * @throws IOException
	 */
	public static String InputEmpName() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 社員名を入力
		System.out.print(ConstantMsg.INPUT_EMP_NAME);
		String InputEmpName = br.readLine();
		return InputEmpName;
	}
}
