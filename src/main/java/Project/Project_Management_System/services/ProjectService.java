package Project.Project_Management_System.services;

import Project.Project_Management_System.models.Project;
import Project.Project_Management_System.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveProject(Project project){
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id){
        return projectRepository.findById(id).orElse(null);
    }

    public Project updateProject(Long id, Project updatedProject){
        if(projectRepository.existsById(id)){
            updatedProject.setId(id);
            return projectRepository.save(updatedProject);
        }
        return null;
    }

    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }




}
