package project;

import gui.MainCardManager;
import gui.dialog.DialogManager;

public class ProjectManager {

    private final static Project currentProject = new Project();
//    private static ProjectStateEnum projectStateEnum = ProjectStateEnum.NULL;
    private static ProjectState projectState = new NullProjectState();

    public static void createNewProject() {
//        //TODO: refactor -> projectState = projectState.create();
//
//        //TODO: DBCommunication.getListOfAllProjects()
//        String[] listOfProjects = new String[]{"test_project_#1", "test_project_#2"};
//
//        if(currentProject.getState() == ProjectStateEnum.NULL
//                || currentProject.getState() == ProjectStateEnum.SAVED) {
//
//            String validNewProjectName = DialogManager.getValidNewProjectName(listOfProjects);
//
//            if(validNewProjectName == null) {
//                return;
//            }
//
//            //TODO: DBCommunication.createNewProject(newProjectName)
////            currentProject.setState(ProjectState.SAVED);
//            currentProject.setState(ProjectStateEnum.UNSAVED);
//        } else if(currentProject.getState() == ProjectStateEnum.UNSAVED) {
//            if(DialogManager.showSaveDialog()) {
//                //TODO: DBCommunication.saveProject();
//                currentProject.setState(ProjectStateEnum.SAVED);
//            }
//        }
//        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
        projectState.createNewProject();
    }

    public static void saveCurrentProject() {
//        //TODO: refactor -> projectState = projectState.save();
//        //TODO: DBCommunication.save()
//        currentProject.setState(ProjectStateEnum.SAVED);
        projectState.saveCurrentProject();
    }

    public static void loadExistingProject() {
//        //TODO: refactor -> projectState = projectState.load();
//        //TODO: DBCommunication.getListOfAllProjects()
//        String[] listOfProjects = new String[]{"test_project_#1", "test_project_#2"};
//
//        DialogManager.choseExistingProjectDialog(listOfProjects);
//
//        //TODO: DBCommunication.load()
//        currentProject.setState(ProjectStateEnum.SAVED);
        projectState.loadExistingProject();
    }

    public static void closeCurrentProject() {
//        //TODO: refactor -> projectState = projectState.close();
//        if(currentProject.getState() == ProjectStateEnum.UNSAVED) {
//            if(DialogManager.showSaveDialog()) {
//                currentProject.setState(ProjectStateEnum.UNSAVED);
//            }
//        }
//        MainCardManager.changePanel(MainCardManager.MAIN_MENU_PANEL);
        projectState.closeCurrentProject();
    }

    public static void exit() {
        ProjectManager.closeCurrentProject();
        System.exit(0);
    }

    public static void setProjectState(ProjectState projectState) {
        ProjectManager.projectState = projectState;
    }

}
