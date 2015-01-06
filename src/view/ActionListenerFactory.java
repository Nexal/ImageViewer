package view;

import java.awt.event.ActionListener;

public interface ActionListenerFactory {
    public ActionListener create(String name);
}
