package classcode;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Predicate<Integer> isEven = (num) -> num % 2 == 0;

		Predicate<Integer> isGreaterThan = (num) -> num > 100;

		// combined predicate
		Predicate<Integer> isEvenAndGreaterThan = isEven.and(isGreaterThan);

		// combined predicate with or
		Predicate<Integer> isEvenAndGreaterThanHundred = isEven.or(isGreaterThan);

		Predicate<Integer> isNotEven = isEven.negate();

		System.out.println("isEven : " + isEven.test(12));
		System.out.println("isGreaterThan : " + isGreaterThan.test(120));
		System.out.println("isEvenAndGreaterThan : " + isEvenAndGreaterThan.test(120));
		System.out.println("isEvenAndGreaterThanHundred : " + isEvenAndGreaterThanHundred.test(140));
		System.out.println("isNotEven : " + isNotEven.test(120));

	}

}
