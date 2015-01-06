package application;

import control.*;
import gui.ApplicationFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import model.Image;
import persistence.ImageLoaderFileList;
import view.ActionListenerFactory;

public class Application {
    
    static final String path = "C:\\Users\\Public\\Pictures\\Sample Pictures";
    
    public static void main(String[] args){
        new Application().execute();
    }

    private void execute() {
        final DictionaryCommand commandSet = new DictionaryCommand();
        ImageLoaderFileList imageLoaderFileList = new ImageLoaderFileList(path);
        List<Image> list = imageLoaderFileList.load();
        
        ActionListenerFactory actionListenerFactory = new ActionListenerFactory() {

            @Override
            public ActionListener create(final String name) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        commandSet.get(name).execute();
                    }
                };
            }
        };
        
        ApplicationFrame window = new ApplicationFrame(actionListenerFactory);
        window.getImageViewer().setImage(list.get(0));
        commandSet.put("next", new NextImageCommand(window.getImageViewer()));
        commandSet.put("prev", new PrevImageCommand(window.getImageViewer()));
        window.setVisible(true);
        
    }
    
}
