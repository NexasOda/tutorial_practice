package test2.tutorial.question01;

public class PowNumber {
	/**
	 * 数字を２つ受け取り、aのb乗を計算し返却する
	 * @param a
	 * @param b
	 * @return
	 */
	public static int calc(int a, int b) {
		int ret = a;

		for (int i = 0 ; i < b ; i ++) {
			ret = ret + a;
		}

		return ret;
	}
}
