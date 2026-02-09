package jp.co.sss.crud.db;

import static jp.co.sss.crud.util.ConstantSQL.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * データベースに接続するクラス
 *
 * @author System Shared
 *
 */
public class DBManager {

	/**
	 * DBと接続する
	 *
	 * @return DBコネクション
	 * @throws ClassNotFoundException
	 *             ドライバクラスが見つからなかった場合
	 * @throws SystemErrorException
	 *             DB接続に失敗した場合
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		// JDBCドライバクラスをJVMに登録
		Class.forName(JDBC_DRIVER);

		// DBに接続
		Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

		return connection;
	}

	/**
	 * DBとの接続を切断する
	 *
	 * @param connection
	 *            DBとの接続情報
	 * @throws SystemErrorException
	 *             クローズ処理に失敗した場合に送出
	 */
	public static void close(Connection connection) throws SystemErrorException {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// 独自例外の送出
				throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);
			}
		}
	}

	/**
	 * PreparedStatementをクローズする
	 *
	 * @param preparedStatement
	 *            ステートメント情報
	 * @throws SystemErrorException
	 *             クローズ処理に失敗した場合に送出
	 */
	public static void close(PreparedStatement preparedStatement) throws SystemErrorException {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// 独自例外の送出
				throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);
			}
		}
	}

	/**
	 * ResultSetをクローズする
	 *
	 * @param resultSet
	 *            SQL検索結果
	 * @throws SystemErrorException
	 *             クローズ処理に失敗した場合に送出
	 */
	public static void close(ResultSet resultSet) throws SystemErrorException {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// 独自例外の送出
				throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR, e);
			}
		}
	}

}