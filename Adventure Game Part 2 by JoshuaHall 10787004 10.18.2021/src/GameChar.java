
public class GameChar {
	public int spacesVisible = 1;
	public int[] go(String direction) {
		if (direction.contentEquals("n")) {
			int[] result = {1, 0};
			return result;
		}
		if (direction.contentEquals("s")) {
			int[] result = {-1, 0};
			return result;
		}
		if (direction.contentEquals("e")) {
			int[] result = {0, 1};
			return result;
		}
		if (direction.contentEquals("w")) {
			int[] result = {0, -1};
			return result;
		}
		return null;
	}
	public String[] inventory() {
		String[] inv = {"brass lantern", "rope", "rations", "staff"};
		return inv;
	}
}
