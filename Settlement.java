public class Settlement {
    private String settlementName;
    private Building[] buildingArray;

    public Settlement(String sN, Building ... bA) {
        settlementName = sN;
        buildingArray = bA;
    }

    public void addBuilding(Building building) {
        int arrayLength = buildingArray.length;
        Building[] newBuildingArray = new Building[arrayLength + 1];
        for (int i = 0; i < arrayLength; i++) {
            newBuildingArray[i] = buildingArray [i];
        }
        newBuildingArray[arrayLength] = building;
        buildingArray = newBuildingArray;
    }
    public boolean build(int allottedMoney, Population population,
        int cost, int workersRequired) {
        if (population.canWork(workersRequired) && allottedMoney > cost) {
            Building newBuilding = new Building(cost, workersRequired);
            addBuilding(newBuilding);
            return true;
        } else {
            return false;
        }
    }
    public void expandSettlement() {
        Building[] newBuildingArray = new Building[2 * buildingArray.length];
        for (int i = 0; i < buildingArray.length; i++) {
            newBuildingArray[i] = buildingArray [i];
        }
        buildingArray = newBuildingArray;
    }

    public String getName() {
        return settlementName;
    }
}
