package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 部署IDを入力するクラス
 */
public class EmployeeDeptIdReader implements IConsoleReader {
	/**
	 * 部署IDを入力
	 * @return 部署
	 */
	public Object input() throws SystemErrorException, IllegalInputException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String InputDeptIdString = null;

		try {
			// 部署IDを入力
			System.out.print(ConstantMsg.INPUT_DEPT_ID);
			InputDeptIdString = br.readLine();
			// 入力チェック
			if (!isValid(InputDeptIdString)) {
				String errorMsg = getErrorMsg();
				throw new IllegalInputException(errorMsg);
			}
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);
		}
		// 数値に変換
		if (isParseInt()) {
			return Integer.parseInt(InputDeptIdString);
		}

		return InputDeptIdString;
	}

	/**
	 *	エラーメッセージを返す
	 */
	@Override
	public String getErrorMsg() {

		return ConstantMsg.INPUT_ERROR_DEPT_ID;

	}

	/**
	 * 入力チェック
	 */
	@Override
	public boolean isValid(String inputString) {
		//1~3までの整数
		return inputString.matches("^[1-3１-３]{1}$");

	}

	/**
	 * 数字に変換する
	 */
	@Override
	public boolean isParseInt() {
		return true;
	}
}
