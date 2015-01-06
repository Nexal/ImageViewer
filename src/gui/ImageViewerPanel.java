package gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import model.Image;
import persistence.*;
import view.*;

public class ImageViewerPanel extends JPanel implements ImageViewer {

    private Image image;
    private int initialX;
    private int offSet;

    public ImageViewerPanel() {
        offSet = 0;
        chainedEvents();
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public void paint(Graphics grphcs) {
        if (image == null) {
            return;
        }
        super.paint(grphcs);
        grphcs.clearRect(0, 0, this.getWidth(), this.getHeight());
        if (image.getBitMap() instanceof SwingBitMap) {
            grphcs.drawImage(getBufferedImage((SwingBitMap) image.getBitMap()), offSet, 0, null);
            putImage(grphcs);
        }
    }

    private java.awt.Image getBufferedImage(SwingBitMap swingBitMap) {
        return swingBitMap.getBufferedImage();
    }

    private void putImage(Graphics grphcs) {
        if (offSet == 0) {
            return;
        }

        if (offSet < 0) {
            grphcs.drawImage(getBufferedImage((SwingBitMap) image.getNext().getBitMap()),
                    (int) (image.getBitMap().getWidth() + offSet),
                    0,
                    null);
        } else {
            grphcs.drawImage(getBufferedImage((SwingBitMap) image.getPrev().getBitMap()),
                    (int) (offSet - image.getBitMap().getWidth()),
                    0,
                    null);

        }
    }

    private void chainedEvents() {
        chainMouseListener();
        chainMouseMotionListener();
    }

    private void chainMouseListener() {
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                initialX = me.getX();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (offSet > -image.getBitMap().getWidth() / 2) {
                    image = image.getPrev();
                }
                
                if (offSet < image.getBitMap().getWidth() / 2) {
                    image = image.getNext();
                }
                
                offSet = 0;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
    }

    private void chainMouseMotionListener() {
        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent me) {
                offSet = me.getX() - initialX;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent me) {
            }
        });
    }

}
