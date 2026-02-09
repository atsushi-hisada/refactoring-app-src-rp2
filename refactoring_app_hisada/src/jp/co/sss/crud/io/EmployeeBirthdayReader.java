package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 生年月日を入力するクラス
 */
public class EmployeeBirthdayReader {
	/**
	 * 生年月日を入力
	 * 
	 * @return 生年月日
	 * @throws IOException
	 * @throws ParseException
	 */
	public static LocalDate InputBirthday() throws IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			// 生年月日を入力
			System.out.print(ConstantMsg.INPUT_BIRTHDAY);
			String bitrhdayString = br.readLine();
			// フォーマットを作成
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ConstantValue.DATE_FORMAT);
			LocalDate bitrhday = LocalDate.parse(bitrhdayString, dtf);
			return bitrhday;
		} catch (IOException e) {
			throw new IllegalInputException(ConstantMsg.INPUT_ERROR_DEPT_ID, e);
		}
	}
}
