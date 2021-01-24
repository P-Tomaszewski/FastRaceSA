package p.tomaszewski.FastRace.model.projection;

import java.util.List;
import java.util.Map;

public class DriverResultModel {
    String raceName;
    int  score;

    public DriverResultModel() {
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
