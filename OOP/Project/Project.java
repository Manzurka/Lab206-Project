public class Project {
    private String name;
    private String description;
    
    public void setProject() {
        name = "NA";
        description = "NA";
    }
    public void setProject(String name) {
        this.name = name;
        this.description = "NA";
    }
    public void setProject(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String ProjectName() {
        return name;
    }
    public String ProjectDescription() {
        return description;
    }
    public String elevatorPitch() {
        return name + ":" + description;
    }
}