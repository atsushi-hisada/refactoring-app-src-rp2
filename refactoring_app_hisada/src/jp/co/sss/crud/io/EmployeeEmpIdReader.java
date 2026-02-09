package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員IDを入力するクラス
 */
public class EmployeeEmpIdReader {
	/**
	 * 社員IDを入力
	 * @return 社員ID
	 * @throws IOException
	 */
	public static Integer InputEmpId() throws IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			// 社員IDを入力
			String inputEmpIdString = br.readLine();
			return Integer.parseInt(inputEmpIdString);
		} catch (IOException e) {
			throw new IllegalInputException(ConstantMsg.INPUT_ERROR_EMP_ID, e);
		}
	}
}
