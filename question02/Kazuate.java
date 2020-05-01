package test2.tutorial.question02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 数当てゲーム
 *
 * コンピュータが自動的に決めた数値を、人間が予想して当てるゲーム
 * 10回以内に当てないとゲームオーバー
 * ヒントとして、もっと大きいか、もっと小さいかを教えてくれる。
 *
 *
 * 機能改修１．10回の回数制限をなくし、「最後にあなたは回答にたどり着くためにｘｘ回かかりました」
 * のメッセージを表示する。
 *
 * 機能改修２．回答にたどり着いたら、「もう一度あそびますか？Yes:1 / No:1以外」
 * のメッセージを表示し、キーボード入力を受付け、1を入力されたら、もう一度遊べるように修正する。
 *
 */


public class Kazuate {
	public static void main(String[] args) {
		Random random = new Random();

		int ans = random.nextInt(1000);
		int count = 0;
		int userAns = 0;

		System.out.println("0～999の数字を入力してください。");

		while (count < 10) {
			System.out.printf("%d> ", count + 1);
			userAns = getNumberInput();
			System.out.printf("\t%d ..... ", userAns);
			if (ans == userAns) {
				System.out.println("正解！");
				break;
			} else if (ans < userAns) {
				System.out.println("大きすぎます。");
			} else {
				System.out.println("小さすぎます。");
			}
			count++;
		}

		if (ans != userAns) {
			System.out.println("Game Over! 正解は " + ans + " でした。");
		}
	}

	private static int getNumberInput() {
		int userAns = -1;

		do {
			String s = getStringInput();
			try {
				userAns = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				System.out.print("もう一度入力してください > ");
			}
		} while (userAns == -1);

		return userAns;
	}

	private static String getStringInput() {
		BufferedReader br = null;
		String line = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return line;
	}

}
