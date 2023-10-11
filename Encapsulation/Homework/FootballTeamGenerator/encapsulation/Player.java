package encapsulation;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if (endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException("A player's endurance should be a number between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException("A player's sprint should be a number between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException("A player's dribble should be a number between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException("A player's passing should be a number between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException("A player's shooting should be a number between 0 and 100.");
        }
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.endurance + this.dribble + this.passing + this.shooting + this.sprint) / 5.0;
    }
}
