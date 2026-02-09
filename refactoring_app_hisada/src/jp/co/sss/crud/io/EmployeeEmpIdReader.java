package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 社員IDを入力するクラス
 */
public class EmployeeEmpIdReader {
	/**
	 * 社員IDを入力
	 * @return 社員ID
	 * @throws IOException
	 */
	public static Integer InputEmpId() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 社員IDを入力
		String inputEmpIdString = br.readLine();
		return Integer.parseInt(inputEmpIdString);
	}
}
