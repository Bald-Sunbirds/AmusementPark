package amusementpark_demo.com.baldsunbirds.entity;

public class Building {
    private Integer Health;
    private Integer Cost;
    private Integer time_to_build;

    public Building() {
    }

    public Building(Integer health, Integer cost, Integer time_to_build) {
        Health = health;
        Cost = cost;
        this.time_to_build = time_to_build;
    }

    public Integer getHealth() {
        return Health;
    }

    public void setHealth(Integer health) {
        Health = health;
    }

    public Integer getCost() {
        return Cost;
    }

    public void setCost(Integer cost) {
        Cost = cost;
    }

    public Integer getTime_to_build() {
        return time_to_build;
    }

    public void setTime_to_build(Integer time_to_build) {
        this.time_to_build = time_to_build;
    }
}
