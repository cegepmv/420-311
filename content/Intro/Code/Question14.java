import java.util.Arrays;

public class Question14{
	public static void main(String[] args) {
        int tab[] = new int[5];
		for (int i = 5; i > 0; i--) {
			tab[5 - i] = i;
		}
		Arrays.sort(tab);
		for (int i = 0; i < 5; ++i) {
			System.out.print(tab[i]);
	    }     
	}
}