package business;

public class GrantCondition {
    private String typeName;
    private String conditionName;
    private String minDuration;
    private String maxDuration;
    private String minAmount;
    private String maxAmount;
    private Integer grantConditionId;

    public GrantCondition(String typeName, String conditionName, String minDuration, String maxDuration, String minAmount, String maxAmount, Integer grantConditionId) {
        this.typeName = typeName;
        this.conditionName = conditionName;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.grantConditionId = grantConditionId;
    }

    public GrantCondition() {
    }

    public String getTypeName() {
        return typeName;
    }

    public String getMinDuration() {
        return minDuration;
    }

    public String getMinAmount() {
        return minAmount;
    }

    public String getMaxDuration() {
        return maxDuration;
    }

    public String getMaxAmount() {
        return maxAmount;
    }

    public void setTypeName(String name) {
        this.typeName = name;
    }

    public void setMinDuration(String minTime) {
        this.minDuration = minTime;
    }

    public void setMaxDuration(String maxTime) {
        this.maxDuration = maxTime;
    }

    public void setMinAmount(String minAmount) {
        this.minAmount = minAmount;
    }

    public void setMaxAmount(String maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Integer getGrantConditionId() {
        return grantConditionId;
    }

    public void setGrantConditionId(Integer grantConditionId) {
        this.grantConditionId = grantConditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }
}


