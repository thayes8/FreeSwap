package Coupons.comp127graphics.events;

import Coupons.comp127graphics.CanvasWindow;

/**
 * A listener that can receive events when the mouse button is clicked or released.
 *
 * @author Paul Cantrell
 * @see CanvasWindow#onClick(MouseButtonEventHandler)
 * @see CanvasWindow#onMouseDown(MouseButtonEventHandler)
 * @see CanvasWindow#onMouseUp(MouseButtonEventHandler)
 */
public interface MouseButtonEventHandler {
    void handleEvent(MouseButtonEvent event);
}
