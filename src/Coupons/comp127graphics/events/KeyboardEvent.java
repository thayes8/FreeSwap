package Coupons.comp127graphics.events;

import Coupons.comp127graphics.CanvasWindow;
import Coupons.comp127graphics.Point;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

/**
 * Carries information about a key being pressed or released.
 *
 * @author Paul Cantrell
 * @see CanvasWindow#onKeyDown(KeyboardEventHandler)
 * @see CanvasWindow#onKeyUp(KeyboardEventHandler)
 * @see CanvasWindow#onCharacterTyped(Consumer)
 */
public final class KeyboardEvent extends AbstractEvent {

    private final Key key;

    /**
     * For internal use. Translates an underlying AWT event to a comp127graphics event.
     */
    public KeyboardEvent(KeyEvent sourceEvent) {
        super(sourceEvent);
        this.key = Key.fromAwtKeyCode(
            sourceEvent.getKeyCode());
    }

    /**
     * The key that was pressed or released.
     */
    public Key getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "KeyboardEvent{"
            + "key=" + key
            + ",modifiers=" + getModifiers()
            + '}';
    }
}
