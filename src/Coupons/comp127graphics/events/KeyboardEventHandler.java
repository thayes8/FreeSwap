package Coupons.comp127graphics.events;

import Coupons.comp127graphics.CanvasWindow;

/**
 * A listener that can receive events when the mouse moves.
 *
 * @author Paul Cantrell
 * @see CanvasWindow#onKeyDown(KeyboardEventHandler)
 * @see CanvasWindow#onKeyUp(KeyboardEventHandler)
 */
public interface KeyboardEventHandler {
    void handleEvent(KeyboardEvent event);
}
