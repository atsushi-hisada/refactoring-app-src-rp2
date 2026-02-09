package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員情報を削除するクラス
 */
public class EmployeeDeleteService {

	/**
	 * 社員情報を削除
	 * 
	 * @throws SystemErrorException 継続不能なエラー
	 * @throws IllegalInputException 不正入力エラー
	 */
	public static void execute()
			throws SystemErrorException, IllegalInputException {

		System.out.print(ConstantMsg.DELETE_INPUT_EMP_ID);
		EmployeeEmpIdReader employeeEmpIdReader = new EmployeeEmpIdReader();
		// 削除する社員IDを入力
		Integer deleteEmpId = (Integer) employeeEmpIdReader.input();
		// 削除を実行
		EmployeeDAO.deleteEmployee(deleteEmpId);
	}
}
