package swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import view.*;
import javax.swing.*;

public class ApplicationFrame extends JFrame{
    
    private ActionListenerFactory actionListenerFactory;
    private ImageViewer imageViewer;

    public ApplicationFrame(ActionListenerFactory actionListenerFactory) {
        super("Image Viewer");
        this.actionListenerFactory = actionListenerFactory;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1024, 768));
        setLocationRelativeTo(null);
        createPanel();
    }

    private void createPanel() {
        add(createViewer());
        add(createToolBar(), BorderLayout.SOUTH);
    }

    private JPanel createViewer() {
        imageViewer = new ImageViewerPanel();
        return (JPanel) imageViewer;
    }

    private JPanel createToolBar() {
        JPanel toolBar = new JPanel();
        toolBar.setLayout(new FlowLayout());
        toolBar.add(createPrev());
        toolBar.add(Box.createHorizontalStrut(200));
        toolBar.add(createNext());
        return toolBar;
    }
    
    private JButton createPrev() {
        JButton prev = new JButton("Previous");
        prev.addActionListener(actionListenerFactory.create("prev"));
        return prev;
    }
    
    private JButton createNext() {
        JButton next = new JButton("Next");
        next.addActionListener(actionListenerFactory.create("next"));
        return next;
    }

    
    public ActionListenerFactory getActionListenerFactory() {
        return actionListenerFactory;
    }

    public ImageViewer getImageViewer() {
        return imageViewer;
    }
}
