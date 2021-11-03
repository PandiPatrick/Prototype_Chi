package saves;

public class SaveNumber {
    private int SaveNumber;
    private boolean isActive;

    public SaveCharacter[] sc = new SaveCharacter[2];

    public SaveNumber(int saveNumber, SaveCharacter[] sc, boolean isActive) {
        SaveNumber = saveNumber;
        this.sc = sc;
        isActive = isActive;
    }

    public void setSaveNumber(int saveNumber) {
        SaveNumber = saveNumber;
    }


    public int getSaveNumber() {
        return SaveNumber;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }
}
