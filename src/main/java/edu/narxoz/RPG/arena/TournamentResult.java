package edu.narxoz.RPG.arena;

public class TournamentResult {
    private String winnerName;
    private int roundsPlayed;
    private boolean heroWon;

    public TournamentResult(String winnerName, int roundsPlayed, boolean heroWon) {
        this.winnerName = winnerName;
        this.roundsPlayed = roundsPlayed;
        this.heroWon = heroWon;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public boolean isHeroWon() {
        return heroWon;
    }

    @Override
    public String toString() {
        return "TournamentResult{" +
                "winnerName='" + winnerName + '\'' +
                ", roundsPlayed=" + roundsPlayed +
                ", heroWon=" + heroWon +
                '}';
    }
}