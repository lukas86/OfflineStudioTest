package DB;

import java.util.ArrayList;
import java.util.List;

public class DBCommunication {

    private static final List<String> projectList = new ArrayList<>();

    static {
        projectList.add("test_project_#1");
        projectList.add("test_project_#2");
    }

    public static String[] getListOfProjects() {
        return projectList.toArray(new String[projectList.size()]);
    }

    public static void createNewProject(String projectName) {
        projectList.add(projectName);
    }
}
