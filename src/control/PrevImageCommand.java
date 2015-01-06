package control;

import view.ImageViewer;

public class PrevImageCommand implements Command{
    ImageViewer imageViewer;
    
    public PrevImageCommand(ImageViewer imageViewer){
        this.imageViewer = imageViewer;
    }
    
    @Override
    public void execute(){
        imageViewer.setImage(imageViewer.getImage().getPrev());
    }
}
