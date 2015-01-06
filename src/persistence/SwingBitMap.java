package persistence;

import java.awt.image.BufferedImage;
import model.BitMap;

public class SwingBitMap implements BitMap{
    
    BufferedImage bufferedImage;

    public SwingBitMap(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    @Override
    public double getWidth() {
        return bufferedImage.getWidth();
    }

    @Override
    public double getHeigth() {
        return bufferedImage.getHeight();
    }
}
