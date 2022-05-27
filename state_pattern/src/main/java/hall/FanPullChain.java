package hall;

class FanPullChain {
    private State currentState;

    public FanPullChain() {
        currentState = new OffState();
    }

    public void pull() {
        currentState.pull();
        currentState = currentState.current_state;
    }
}
