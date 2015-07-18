package praca.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BufferedImageUtils {
    public static BufferedImage antenaIcon() {
        try {
            File file = new File("dane/15.png");
            if (!file.exists())
                throw new RuntimeException("file not found:"
                        + file.getAbsolutePath());
            return ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
