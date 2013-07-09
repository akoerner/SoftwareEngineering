package common.lib.GUITools;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

public class JFrameDragger extends MouseMotionAdapter {

	private Point point = new Point();
	private JFrame frame;

	public JFrameDragger(final JFrame frame) {
		this.frame = frame;

		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});

		frame.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = frame.getLocation();
				frame.setLocation(p.x + e.getX() - point.x, p.y + e.getY()
						- point.y);
			}
		});
	}
}
