package persistence;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.RealImage;

public class ImageLoaderFile implements ImageLoader{
    
    private String fileName;

    public ImageLoaderFile(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public RealImage load(){
        return new RealImage(new SwingBitMap(loadImage()));
    }
    
    private BufferedImage loadImage(){
        try {
            return ImageIO.read(new File(fileName));
        } catch (IOException e) {
            return null;
        }
    }
    
}
