package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public static Date InputBirthday() throws IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 生年月日を入力
		System.out.print(ConstantMsg.INPUT_BIRTHDAY);
		String bitrhdayString = br.readLine();
		// フォーマットを作成
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT);
		Date bitrhday = sdf.parse(bitrhdayString);
		return bitrhday;
	}
}
