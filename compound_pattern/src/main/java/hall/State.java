package hall;

public abstract class State {
    State current_state;
    String name() { return ""; }
    void pull() {}  // pull rotates the fan's state
}
