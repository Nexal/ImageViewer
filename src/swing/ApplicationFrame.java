package swing;

import java.awt.Dimension;
import view.*;
import javax.swing.*;

public class ApplicationFrame extends JFrame {

    private ActionListenerFactory actionListenerFactory;
    private ImageViewer imageViewer;

    public ApplicationFrame(ActionListenerFactory actionListenerFactory) {
        super("Image Viewer");
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
}
