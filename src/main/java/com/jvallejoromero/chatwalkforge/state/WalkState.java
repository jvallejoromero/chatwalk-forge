package com.jvallejoromero.chatwalkforge.state;

/**
 * A simple state holder class, equivalent to the Fabric version's LiterallyJustOneBoolean.
 * Encapsulates the state for whether the player should continue walking while in chat.
 */
public class WalkState {
    /**
     * This flag is set to true when the player opens the chat screen while walking forward.
     * It signals to our tick handler that we should continue pretending to walk forward.
     */
    private static boolean isWalkingWhileChatting = false;

    /**
     * Returns whether the player is currently set to walk forward while in chat.
     * @return true if the player should walk forward in chat, false otherwise.
     */
    public static boolean isWalkingWhileChatting() {
        return isWalkingWhileChatting;
    }

    /**
     * Sets the state of whether the player should walk forward while in chat.
     * @param walkingWhileChatting The new state.
     */
    public static void setWalkingWhileChatting(boolean walkingWhileChatting) {
        isWalkingWhileChatting = walkingWhileChatting;
    }
}
