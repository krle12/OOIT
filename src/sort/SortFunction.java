package sort;

import geometry.Point;
import geometry.Rectangle;
import java.util.Comparator;
import java.util.Random;


public class SortFunction {
	
	private Rectangle[] list;
	private RectangleComparator comp;
	
	
	public SortFunction() {
		
	}
	
	public SortFunction(Rectangle[] list, RectangleComparator comp) {
		this.list = list;
		this.comp = comp;
	}

	public static void print(Rectangle[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println("area = " + list[i].getWidth() * list[i].getHeight());
		}
	}

	
	
	public static Rectangle[] generateRectangle(Rectangle[] list) {

		Random r = new Random();

		for (int i = 0; i < list.length; i++) {

			list[i] = new Rectangle(new Point(r.nextInt(9) + 1, r.nextInt(9) + 1), r.nextInt(9) + 1, r.nextInt(9) + 1);
		}

		return list;
	}
	
	class RectangleComparator implements Comparator<Object> {

		@Override
		public int compare(Object firstObject, Object secondObject) {
			
			Rectangle r1 = (Rectangle) firstObject;
			double area1 = r1.area();
			Rectangle r2 = (Rectangle) secondObject;
			double area2 = r2.area();

			if (area1 < area2) {
				return -1;
			}
			if (area1 > area2) {
				return 1;
			} else 
			{
				double x1 = r1.getUpperLeftPoint().getX();
				double y1 = r1.getUpperLeftPoint().getY();
				double x2 = r2.getUpperLeftPoint().getX();
				double y2 = r2.getUpperLeftPoint().getY();

				if (x1 == x2 && y1 == y2 && r1.getWidth() == r2.getWidth() && r1.getHeight() == r2.getHeight()) {
					return 0;
				} else 
				{
					if (Math.sqrt(x1 * x1 + y1 * y1) < Math.sqrt(x2 * x2 + y2 * y2)) {
						return -1;
					} else {
						return 1;
					}
				}
			}

		}

	}


	public Rectangle[] getList() {
		return list;
	}


	public void setList(Rectangle[] list) {
		this.list = list;
	}


	public RectangleComparator getComp() {
		return comp;
	}


	public void setComp(RectangleComparator comp) {
		this.comp = comp;
	}

}


