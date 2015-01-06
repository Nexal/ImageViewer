package persistence;

import java.io.File;
import java.util.*;
import model.Image;

public class ImageLoaderFileList implements ImageLoaderList{
    
    String path;

    public ImageLoaderFileList(String fileName) {
        this.path = fileName;
    }

    public String getPath() {
        return path;
    } 

    @Override
    public List<Image> load() {
        return null;
    }
    
    public List<Image> loadImage(){
        List<Image> imageList = new ArrayList<>();
        
        for (String name : new File(path).list()) {
            if (name.contains(".npg")||name.contains(".jpg")||name.contains(".bmp")||name.contains(".gif")) {
                imageList.add(new ProxyImage(new ImageLoaderFile(path + "/" + name)));
            }
        }
        return imageList;
    }
    
    public List<Image> linkImage(List<Image> images){
        for (int i = 0; i < images.size(); i++) {
            Image image = images.get(i);
            image.setNext(images.get((i + 1) % images.size()));
            image.setPrev(images.get((i + images.size() - 1) % images.size()));
        }
        return images;
    }
}
