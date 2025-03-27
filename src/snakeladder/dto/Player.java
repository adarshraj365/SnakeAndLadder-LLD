package snakeladder.dto;

// Entity to represents a Player.
public class Player {
    private String name;
    private boolean won;
    private int position;

    public Player(final String name) {
        this.name = name;
        this.won = false;
        this.position = 1;
    }

    public String getName() {
        return this.name;
    }

    public void setWon() {
        this.won = true;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isWon() {
        return this.won;
    }
}
