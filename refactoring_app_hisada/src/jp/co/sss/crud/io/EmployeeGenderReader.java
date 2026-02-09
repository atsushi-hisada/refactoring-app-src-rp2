package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue.Gender;

public class EmployeeGenderReader {
	/**
	 * 性別を入力
	 * @return 性別
	 * @throws IOException
	 */
	public static Gender InputGender() throws IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			// 性別を入力
			System.out.print(ConstantMsg.INPUT_GENDER);
			String inputGenderString = br.readLine();
			// インデックスから性別を取得
			Gender inputGender = Gender.getGender(Integer.parseInt(inputGenderString));
			return inputGender;
		} catch (IOException e) {
			throw new IllegalInputException(ConstantMsg.INPUT_ERROR_GENDER, e);
		}
	}
}
