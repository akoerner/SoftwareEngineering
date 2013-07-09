package common.lib.GUITools;

import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class JFrameBackgroundImagePanel extends JComponent {
    private ImageIcon image;
    public JFrameBackgroundImagePanel(ImageIcon image) {
        this.image = image;
        this.setLayout(new FlowLayout());
    } 
 
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image.getImage(), 0, 0, null);
    }
}