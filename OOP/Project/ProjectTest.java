public class ProjectTest {
    public static void main(String[] args) {
        Project project = new Project();
        project.setProject();
        Project projectA = new Project();
        projectA.setProject("Harry Potter");
        Project projectB = new Project();
        projectB.setProject("The boy who lived");
        System.out.println(projectB.ProjectName());
        System.out.println(projectB.ProjectDescription());
        System.out.println(projectB.elevatorPitch());
    }
}