package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報を削除するクラス
 */
public class EmployeeDeleteService implements IEmployeeService {

	/**
	 * 社員情報を削除
	 * 
	 * @throws SystemErrorException 継続不能なエラー
	 * @throws IllegalInputException 不正入力エラー
	 */
	public void execute()
			throws SystemErrorException, IllegalInputException {

		System.out.print(ConstantMsg.DELETE_INPUT_EMP_ID);
		EmployeeEmpIdReader employeeEmpIdReader = new EmployeeEmpIdReader();
		// 削除する社員IDを入力
		Integer deleteEmpId = (Integer) employeeEmpIdReader.input();
		EmployeeDAO dao = new EmployeeDAO();
		// 削除を実行
		Integer deleteResult = dao.delete(deleteEmpId);

		if (deleteResult == ConstantValue.SQL_ERROR_RESULT) {
			// SQL文の実行が失敗した場合
			System.out.print(ConstantMsg.DELETE_NOT_FOUND);
		} else {
			// 成功した場合
			System.out.print(ConstantMsg.DELETE_COMPLETE);
		}
	}
}
