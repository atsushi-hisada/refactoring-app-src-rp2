package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 生年月日を入力するクラス
 */
public class EmployeeBirthdayReader implements IConsoleReader {

	/**
	 * 生年月日を入力
	 * 
	 * @return 生年月日
	 * @throws IOException
	 * @throws ParseException
	 */
	public Object input() throws SystemErrorException,
			IllegalInputException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputBitrhdayString = null;

		try {
			// 生年月日を入力
			System.out.print(ConstantMsg.INPUT_BIRTHDAY);
			inputBitrhdayString = br.readLine();
			// 入力チェック
			if (!isValid(inputBitrhdayString)) {
				String errorMsg = getErrorMsg();
				throw new IllegalInputException(errorMsg);
			}
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);
		}
		// 存在している生年月日のパターンを作成
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ConstantValue.DATE_FORMAT);
		// 型変換
		LocalDate bitrhday = LocalDate.parse(inputBitrhdayString, dtf);
		return bitrhday;
	}

	/**
	 *	エラーメッセージを返す
	 */
	@Override
	public String getErrorMsg() {
		return ConstantMsg.INPUT_ERROR_BIRTHDAY;
	}

	/**
	 * 入力チェック
	 */
	@Override
	public boolean isValid(String inputString) {
		try {
			// 存在している生年月日のパターンを作成
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ConstantValue.DATE_FORMAT)
					.withResolverStyle(ResolverStyle.STRICT);
			LocalDate.parse(inputString, dtf);
			return true;
		} catch (DateTimeParseException e) {
			//不正な日時や存在しない日時の場合
			return false;
		}
	}

	/**
	 * 数値に変換
	 */
	@Override
	public boolean isParseInt() {
		return false;
	}
}
