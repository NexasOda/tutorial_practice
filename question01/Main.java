package test2.tutorial.question01;

public class Main {

	public static void main(String[] args) {
		int a = 10;
		int b = 5;

		// このクラスファイルは修正せず、呼び出しているユーティリティクラスを修正して
		// バグを改修してください。

		// バグを改修する際、バグごとにブランチを作成してください。

		System.out.println(a + "と" + b +"の和は" + AddNumber.calc(a, b));		// bug01
		System.out.println(a + "と" + b +"の差は" + SubNumber.calc(a, b));		// bug02
		System.out.println(a + "と" + b +"の積は" + MulNumber.calc(a, b));		// bug03
		System.out.println(a + "と" + b +"の商は" + DivNumber.calc(a, b));		// bug04
		System.out.println(a + "と" + b +"の余りは" + SurNumber.calc(a, b));	// bug05
		System.out.println(a + "の" + b +"乗は" + PowNumber.calc(a, b));		// bug06

	}

}
