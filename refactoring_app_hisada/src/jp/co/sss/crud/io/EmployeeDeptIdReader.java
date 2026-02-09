package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.util.ConstantMsg;

/**
 * 部署IDを入力するクラス
 */
public class EmployeeDeptIdReader {
	/**
	 * 部署IDを入力し
	 * @return 部署
	 * @throws IOException
	 */
	public static Integer InputDeptId() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 部署IDを入力
		System.out.print(ConstantMsg.INPUT_DEPT_ID);
		String InputDeptIdString = br.readLine();
		return Integer.parseInt(InputDeptIdString);
	}
}
