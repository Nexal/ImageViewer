package swing;

import java.awt.*;
import java.net.URL;
import view.*;
import javax.swing.*;

public class ApplicationFrame extends JFrame {

    private ActionListenerFactory actionListenerFactory;
    private ImageViewer imageViewer;

    public ApplicationFrame(ActionListenerFactory actionListenerFactory) {
        super("Image Viewer");
        setIconImage(setIcon().getImage());
        this.actionListenerFactory = actionListenerFactory;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1024, 768));
        setLocationRelativeTo(null);
        add(createViewer());
    }

    private JPanel createViewer() {
        imageViewer = new ImageViewerPanel();
        return (JPanel) imageViewer;
    }

    public ActionListenerFactory getActionListenerFactory() {
        return actionListenerFactory;
    }

    public ImageViewer getImageViewer() {
        return imageViewer;
    }
    
    private ImageIcon setIcon() {
        URL iconURL = getClass().getResource("icon.png");
        ImageIcon icon = new ImageIcon(iconURL);
        return icon;
    }
}
