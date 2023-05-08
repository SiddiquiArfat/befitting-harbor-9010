package utility;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class generator {
	public static String pin() {
		Random random = new Random();
		return String.format("%04d", random.nextInt(10000));
	}
	
	
	public static long generateAcc() {
	  ThreadLocalRandom random = ThreadLocalRandom.current();
	  return random.nextLong(10_000_000_000L, 100_000_000_000L);
	}
}
