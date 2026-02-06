package jp.co.sss.crud.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.ConstantValue;
import jp.co.sss.crud.util.ConstantValue.Gender;

/**
 * DB操作処理用のクラス
 *
 * @author System Shared
 */
public class DBController {

	/** インスタンス化を禁止 */
	private DBController() {
	}

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public static void findAll() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//resultSetの結果Setがない場合はfalse
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.NOT_FOUND);
				return;
			}

			// レコードを出力
			System.out.println(ConstantMsg.EMPLOYEE_LIST);
			while (resultSet.next()) {
				// DTOを作成し、セットする
				Employee empDto = new Employee();
				empDto.setEmpId(resultSet.getInt(ConstantValue.COL_EMP_ID));
				empDto.setEmpName(resultSet.getString(ConstantValue.COL_EMP_NAME));
				empDto.setGender(Gender.getGender(resultSet.getInt(ConstantValue.COL_GENDER)));
				String bitrhdayString = resultSet.getString(ConstantValue.COL_BIRTHDAY);
				// フォーマットを作成
				SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT);
				empDto.setBirthday(sdf.parse(bitrhdayString));
				Department department = new Department();
				department.setDeptName(resultSet.getString(ConstantValue.COL_DEPT_NAME));
				empDto.setDepartment(department);
				// toStringで出力
				System.out.print(empDto);
				System.out.println("");
			}

			System.out.println("");
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void findByEmpName() throws ClassNotFoundException, SQLException, IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 検索ワード
		String searchWord = br.readLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(ConstantValue.FIND_INDEX_EMP_NAME, "%" + searchWord + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.NOT_FOUND);
				return;
			}

			System.out.println(ConstantMsg.EMPLOYEE_LIST);

			while (resultSet.next()) {
				// DTOを作成し、セットする
				Employee empDto = new Employee();
				empDto.setEmpId(resultSet.getInt(ConstantValue.COL_EMP_ID));
				empDto.setEmpName(resultSet.getString(ConstantValue.COL_EMP_NAME));
				empDto.setGender(Gender.getGender(resultSet.getInt(ConstantValue.COL_GENDER)));
				String bitrhdayString = resultSet.getString(ConstantValue.COL_BIRTHDAY);
				// フォーマットを作成
				SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT);
				empDto.setBirthday(sdf.parse(bitrhdayString));
				Department department = new Department();
				department.setDeptName(resultSet.getString(ConstantValue.COL_DEPT_NAME));
				empDto.setDepartment(department);
				// toStringで出力
				System.out.print(empDto);
				System.out.println("");
			}

			System.out.println("");

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void findByDeptId(String deptId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(ConstantValue.FIND_INDEX_DEPT_ID, Integer.parseInt(deptId));

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.NOT_FOUND);
				return;
			}

			System.out.println(ConstantMsg.EMPLOYEE_LIST);
			while (resultSet.next()) {
				// DTOを作成し、セットする
				Employee empDto = new Employee();
				empDto.setEmpId(resultSet.getInt(ConstantValue.COL_EMP_ID));
				empDto.setEmpName(resultSet.getString(ConstantValue.COL_EMP_NAME));
				empDto.setGender(Gender.getGender(resultSet.getInt(ConstantValue.COL_GENDER)));
				String bitrhdayString = resultSet.getString(ConstantValue.COL_BIRTHDAY);
				// フォーマットを作成
				SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT);
				empDto.setBirthday(sdf.parse(bitrhdayString));
				Department department = new Department();
				department.setDeptName(resultSet.getString(ConstantValue.COL_DEPT_NAME));
				empDto.setDepartment(department);
				// toStringで出力
				System.out.print(empDto);
				System.out.println("");
			}

			System.out.println("");
		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void insertEmployee(String empName, String genderString, String bitrhdayString, String deptIdString)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);
			// Dtoに格納できるようにそれぞれを型変換
			Gender gender = Gender.getGender(Integer.parseInt(genderString));
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT);
			Date bitrhday = sdf.parse(bitrhdayString);
			Integer deptId = Integer.parseInt(deptIdString);
			Department department = new Department(deptId);
			// Dtoに格納
			Employee empDto = new Employee(empName, gender, bitrhday, department);

			// 入力値をバインド
			preparedStatement.setString(ConstantValue.SAVE_INDEX_EMP_NAME, empDto.getEmpName());
			preparedStatement.setInt(ConstantValue.SAVE_INDEX_GENDER, empDto.getGender().getGenderNumber());
			preparedStatement.setObject(ConstantValue.SAVE_INDEX_BIRTHDAY, empDto.getBirthday(), Types.DATE);
			preparedStatement.setInt(ConstantValue.SAVE_INDEX_DEPT_ID, empDto.getDepartment().getDeptId());

			// SQL文を実行
			preparedStatement.executeUpdate();

			// 登録完了メッセージを出力
			System.out.println(ConstantMsg.UPDATE_COMPLETE);
		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void updateEmployee(String empIdString)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			Integer empId = Integer.parseInt(empIdString);
			//名前を入力
			System.out.print(ConstantMsg.INPUT_EMP_NAME);
			String empName = br.readLine();
			// 性別を入力
			System.out.print(ConstantMsg.INPUT_GENDER);
			String genderString = br.readLine();
			Gender gender = Gender.getGender(Integer.parseInt(genderString));
			// 誕生日を入力
			System.out.print(ConstantMsg.INPUT_BIRTHDAY);
			String bitrhdayString = br.readLine();
			// フォーマットを作成
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT);
			Date bitrhday = sdf.parse(bitrhdayString);
			// 部署IDを入力
			System.out.print(ConstantMsg.INPUT_DEPT_ID);
			String deptIdString = br.readLine();
			Integer deptId = Integer.parseInt(deptIdString);
			Department department = new Department(deptId);
			// Dtoに格納
			Employee empDto = new Employee(empId, empName, gender, bitrhday, department);

			// 入力値をバインド
			preparedStatement.setString(ConstantValue.SAVE_INDEX_EMP_NAME, empDto.getEmpName());
			preparedStatement.setInt(ConstantValue.SAVE_INDEX_GENDER, empDto.getGender().getGenderNumber());
			preparedStatement.setObject(ConstantValue.SAVE_INDEX_BIRTHDAY, empDto.getBirthday(), Types.DATE);
			preparedStatement.setInt(ConstantValue.SAVE_INDEX_DEPT_ID, empDto.getDepartment().getDeptId());
			preparedStatement.setInt(ConstantValue.SAVE_INDEX_EMP_ID, empDto.getEmpId());

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件削除
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void deleteEmployee() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();
			String empId = br.readLine();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(ConstantValue.DELETE_INDEX_EMP_ID, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

			System.out.println(ConstantMsg.DELETE_COMPLETE);

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			// Statementをクローズ
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}
	}
}
