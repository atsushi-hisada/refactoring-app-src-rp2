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
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.ConstantValue;
import jp.co.sss.crud.util.EmployeeDtoMappar;

/**
 * 	DB操作処理用のクラス
 */
public class EmployeeDAO implements IEmployeeDAO {

	/**
	 * 全ての社員情報を検索
	 * 
	 * @return 社員情報リスト
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws ParseException
	 */
	@Override
	public List<Employee> findAll() throws SystemErrorException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// DTOを作成し、セットする
				Employee empDto = EmployeeDtoMappar.employeeDtoMappar(resultSet);
				employeeList.add(empDto);
			}
			return employeeList;
		} catch (ClassNotFoundException | SQLException e) {
			// 独自例外の送出
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);

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
	@Override
	public List<Employee> findByEmployeeName(String searchWord)
			throws SystemErrorException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employeeList = new ArrayList<Employee>();

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

			while (resultSet.next()) {
				// DTOを作成し、セットする
				Employee empDto = EmployeeDtoMappar.employeeDtoMappar(resultSet);
				employeeList.add(empDto);
			}
			return employeeList;
		} catch (ClassNotFoundException | SQLException e) {
			// 独自例外の送出
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}

	}

	@Override
	public List<Employee> findByDeptId(Integer deptId)
			throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employeeList = new ArrayList<Employee>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(ConstantValue.FIND_INDEX_DEPT_ID, deptId);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// DTOを作成し、セットする
				Employee empDto = EmployeeDtoMappar.employeeDtoMappar(resultSet);
				employeeList.add(empDto);
			}
			return employeeList;
		} catch (ClassNotFoundException | SQLException e) {
			// 独自例外の送出
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);

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
	@Override
	public void insert(Employee empDto) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(ConstantValue.SAVE_INDEX_EMP_NAME, empDto.getEmpName());
			preparedStatement.setInt(ConstantValue.SAVE_INDEX_GENDER, empDto.getGender().getGenderNumber());
			preparedStatement.setObject(ConstantValue.SAVE_INDEX_BIRTHDAY, empDto.getBirthday(), Types.DATE);
			preparedStatement.setInt(ConstantValue.SAVE_INDEX_DEPT_ID, empDto.getDepartment().getDeptId());

			// SQL文を実行
			preparedStatement.executeUpdate();

			// 登録完了メッセージを出力
			System.out.println(ConstantMsg.REGISTER_COMPLETE);
		} catch (ClassNotFoundException | SQLException e) {
			// 独自例外の送出
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);
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
	@Override
	public Integer update(Employee empDto) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			// 入力値をバインド
			preparedStatement.setString(ConstantValue.SAVE_INDEX_EMP_NAME, empDto.getEmpName());
			preparedStatement.setInt(ConstantValue.SAVE_INDEX_GENDER, empDto.getGender().getGenderNumber());
			preparedStatement.setObject(ConstantValue.SAVE_INDEX_BIRTHDAY, empDto.getBirthday(), Types.DATE);
			preparedStatement.setInt(ConstantValue.SAVE_INDEX_DEPT_ID, empDto.getDepartment().getDeptId());
			preparedStatement.setInt(ConstantValue.SAVE_INDEX_EMP_ID, empDto.getEmpId());

			// SQL文の実行(失敗時は戻り値0)
			return preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// 独自例外の送出
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);
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
	@Override
	public Integer delete(Integer deleteEmpId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(ConstantValue.DELETE_INDEX_EMP_ID, deleteEmpId);

			// SQL文の実行(失敗時は戻り値0)
			return preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// 独自例外の送出
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);
		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);

		}
	}

}
