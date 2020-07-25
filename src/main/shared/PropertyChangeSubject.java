package main.shared;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject {
    void addPropertyChangeListener(PropertyChangeListener listener);
}
