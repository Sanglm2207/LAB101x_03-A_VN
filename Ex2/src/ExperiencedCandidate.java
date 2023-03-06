// ExperiencedCandidate class extending the Candidate class
public class ExperiencedCandidate extends Candidate{
    private int expInYear;
    private String proSkill;

    public ExperiencedCandidate(int expInYear, String proSkill) {
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
