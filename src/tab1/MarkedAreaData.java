package tab1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MarkedAreaData {//implements List<MarkedAreaData> {

	public static int posX;
	public static int posY;
	public static int Width;
	public static int Height;

	public MarkedAreaData(int X, int Y, int W, int H) {
		posX = X;
		posY = Y;
		Width = W;
		Height = H;
	}

	public static Boolean CheckMarkedArea(int X, int Y) {
		System.out.println("sporawdzam czy jest");
		if ((posX < X) && (X <posX+ Width))
			if ((posY < Y) && (Y <posY+ Height))
			{
				System.out.println("zgaza sie ze jest");
				return true;
			}

		return false;
	}

	public static void Change(int X, int Y, int W, int H) {
		System.out.println("zapisuje");
		posX = X;
		posY = Y;
		Width = W;
		Height = H;
	
		// TODO Auto-generated method stub
		
	}
}