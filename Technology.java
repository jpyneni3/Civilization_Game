public class Technology {
  //phiosophy variables
    private int understanding = 0;
    private boolean foundMeaningOfLife = false;
  //Architecture variables
    private int experienceLevel = 0;
    private boolean builtWonderOfTheWorld = false;

    public void philosophize() {
        understanding += 25;
        checkUnderstanding();
    }

    public void improveWriting() {
        understanding += 10;
        checkUnderstanding();
    }

    public void checkUnderstanding() {
        if (understanding > 200) {
            foundMeaningOfLife = true;
        }
    }

    public void checkExpLevel() {
        if (experienceLevel > 200) {
            builtWonderOfTheWorld = true;
        }
    }


    public void increaseExperience(int incExp) {
        experienceLevel += incExp;
        checkExpLevel();
    }

    public boolean hasTechnologyWin() {
        checkExpLevel();
        checkUnderstanding();
        return foundMeaningOfLife && builtWonderOfTheWorld;
    }

    public int getUnderstanding() {
        return understanding;
    }

    public int getBuildExperience() {
        return experienceLevel;
    }



}
