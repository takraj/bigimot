public class DrawingCoords {

	private int map_size;
	private int my_position;

	private int drawing_width = 0;
	private int drawing_height = 0;

	public DrawingCoords(int size, int pos){
		map_size = size;
		my_position = pos + 1;
	}

	public void SetDrawingArea(int width, int height) {
		drawing_width = width;
		drawing_height = height;
	}

	public int GetX() {
		// my_position-t elosztom az sqrt(map_size)-al, �s als� eg�szr�sz
		// (floor)
		// visszaszorzom sqrt(map_size)-al
		// ezt a sz�mot kivonom a my_position-b�l
		int result = my_position
				- ((int) ((Math.floor(my_position / Math.sqrt(map_size))) * Math
						.sqrt(map_size)));
		return ((result == 0) ? (int)Math.sqrt(map_size) : result);
	}

	public int GetY() {
		// my_position-t elosztom az sqrt(map_size)-al, �s fels� eg�szr�sz
		// (ceil)
		return (int) Math.ceil(my_position / Math.sqrt(map_size));
	}

	public void StepX(int i) {
		if (((GetX() + i) > 0) && (GetX() + i <= Math.sqrt(map_size)))
			my_position += i;
	}

	public void StepY(int i) {
		if (((GetY() + i) > 0) && (GetY() + i <= Math.sqrt(map_size)))
			my_position += (i * Math.sqrt(map_size));
	}

	public int GetStartX() {
		// X poz�ci�-1 * (rajzsz�less�g+1 / sqrt(map_size))
		return (int) ((GetX() - 1) * ((drawing_width + 1) / Math.sqrt(map_size)));
	}

	public int GetStartY() {
		// Y poz�ci�-1 * (rajzsz�less�g+1 / sqrt(map_size))
		return (int) ((GetY() - 1) * ((drawing_height + 1) / Math.sqrt(map_size)));
	}

	public int GetEndX() {
		// X poz�ci� * (rajzmagass�g+1 / sqrt(map_size))
		return (int) (GetX() * ((drawing_width + 1) / Math.sqrt(map_size)));
	}

	public int GetEndY() {
		// Y poz�ci� * (rajzmagass�g+1 / sqrt(map_size))
		return (int) (GetY() * ((drawing_height + 1) / Math.sqrt(map_size)));
	}
}
