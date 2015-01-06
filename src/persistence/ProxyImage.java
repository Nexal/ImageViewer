package persistence;

import model.BitMap;
import model.Image;
import model.RealImage;

public class ProxyImage extends Image{
    
    private ImageLoader imageLoader;
    private RealImage realImage;

    public ProxyImage(ImageLoader imageLoader){
        this.imageLoader = imageLoader;
    }

    @Override
    public BitMap getBitMap() {
        checkLoader();
        return realImage.getBitMap();
    }

    private void checkLoader() {
        if (realImage != null)return;
        realImage = imageLoader.load();
    }
}
