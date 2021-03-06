package by.it.Utils.OtrherChart;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main1 {
    public static void main(String[] args) throws Exception {
        BufferedImage img = new BufferedImage(320, 240, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g2d = img.createGraphics();

        try {
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, 320, 240);
/*
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
*/
            g2d.setColor(Color.BLUE);
          //  g2d.setStroke(new BasicStroke(30.f));

            g2d.drawLine(0, 0, 320, 240);
            g2d.drawLine(0, 240, 320, 0);

           // g2d.setColor(Color.GREEN);
           // g2d.setFont(new Font("Arial", Font.PLAIN, 25));

            g2d.drawString("1712", 130, 60);
        } finally {
            g2d.dispose();
        }

        ImageIO.write(img, "PNG", new File("test.png"));
    }
}
