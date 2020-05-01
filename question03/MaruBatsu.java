package test2.tutorial.question03;

import java.util.Scanner;


/**
 * ○×ゲーム
 * 交代で○×を入力し、縦横斜めに、○か×が並んだらその場で勝負あり。
 *
 * 仕様変更１：マスの表示に縦横の線が表示されるように修正する。

before
◯✕ Game Start!
－－－－－－－－－
　１　　２　　３　
　４　　５　　６　
　７　　８　　９　
－－－－－－－－－

after
◯✕ Game Start!
－－－－－－－－－
　１　|　２　|　３　
------+------+------
　４　|　５　|　６　
------+------+------
　７　|　８　|　９　
－－－－－－－－－

 *

 * バグ改修：（斜めで勝利することができない状態にしておく）
 * 斜めがそろったときも、勝利できるようにバグ改修する
 *
 */


public class MaruBatsu {

	public static void main(String[] args) {
		System.out.println("◯✕ Game Start!");
		String trun = "◯";
		String[] field = { "１", "２", "３", "４", "５", "６", "７", "８", "９" };

		try (Scanner scan = new Scanner(System.in)) {

			for (int i = 0; i < field.length; i++) {
				displayField(field);
				insertField(trun, field, scan);
				System.out.println();

				if (judge(field)) {
					displayField(field);
					System.out.println("　" + trun + "の勝ち！");
					break;
				}
				trun = turnChange(trun);

				// 最後まで終わらなかったら引き分け
				if (i == field.length - 1) {
					displayField(field);
					System.out.println("Draw!!");
				}
			}
		}
	}

	/**
	 * 選手交代メソッド
	 *
	 * @param trun
	 * @return
	 */
	private static String turnChange(String trun) {
		if (trun.equals("◯")) {
			return "✕";
		} else {
			return "◯";
		}

	}

	/**
	 * 列ごとに同じ文字かチェックするメソッド
	 *
	 * @param field
	 * @return 揃っている列があればtrue
	 */
	private static boolean judge(String[] field) {
		for (int i = 0; i < 9; i++) {
			// 横比較
			if ((i == 0 || i == 3 || i == 6)) {
				if ((field[i] == field[i + 1])
						&& (field[i + 1] == field[i + 2])) {
					return true;
				}
			}
			// 縦比較
			if (i <= 2) {
				if ((field[i]) == (field[i + 3])
						&& (field[i + 3]) == (field[i + 6])) {
					return true;
				}
			}
		}
		// 斜め比較
		if ((field[0]) == (field[4]) && (field[4]) == (field[8])) {
			return true;
		}
		if ((field[2]) == (field[4]) && (field[4]) == (field[6])) {
			return true;
		}
		return false;
	}

	/**
	 * 表に○か✕を入れるメソッド 入力チェック
	 *
	 * @param trun
	 * @param field
	 * @param scan
	 */
	private static void insertField(String trun, String[] field, Scanner scan) {
		System.out.print("どこを" + trun + "にしますか？　");

		String str = scan.next();
		// 数字がチェック
		if (str.matches("\\d") && !(str.equals("0"))) {
			int num = Integer.parseInt(str);

			// 記入済みかチェック
			if ((field[num - 1].equals("◯")) || (field[num - 1].equals("✕"))) {
				System.out.println("記入済み箇所です");
				insertField(trun, field, scan);
			} else {
				field[num - 1] = trun;
			}
		} else {
			System.out.println("半角数字[1-9]を入力してください");
			insertField(trun, field, scan);
		}
	}

	/**
	 * 表を表示するメソッド
	 *
	 * @param field
	 */
	private static void displayField(String[] field) {
		System.out.println("－－－－－－－－－");
		for (int i = 0; i < field.length; i++) {
			System.out.print("　" + field[i] + "　");
			if ((i + 1) % 3 == 0) {
				System.out.println();
			}
		}
		System.out.println("－－－－－－－－－");
	}
}