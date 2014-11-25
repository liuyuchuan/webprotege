package edu.stanford.bmir.protege.web.client.projectsettings;

import edu.stanford.bmir.protege.web.client.rpc.data.ProjectType;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 09/07/2012
 */
public class ProjectSettingsData implements Serializable {

    private ProjectId projectId;
    
    private ProjectType projectType;
    
    private String projectDescription;

    private String defaultLanguage;

    // For serialization
    private ProjectSettingsData() {

    }

    /**
     * Constructs a ProjectSettingsData object.
     * @param projectId The projectId.  Not {@code null}.
     * @param projectType The ProjectType.  Not {@code null}.
     * @param defaultLanguage The default language. Not {@code null}.
     * @param projectDescription The project description. Not {@code null}.
     * @throws java.lang.NullPointerException if any parameters are {@code null}.
     */
    public ProjectSettingsData(ProjectId projectId, ProjectType projectType, String defaultLanguage, String projectDescription) {
        this.projectId = checkNotNull(projectId);
        this.projectType = checkNotNull(projectType);
        this.defaultLanguage = checkNotNull(defaultLanguage);
        this.projectDescription = checkNotNull(projectDescription);
    }


    public ProjectId getProjectId() {
        return projectId;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    @Override
    public int hashCode() {
        return projectType.hashCode() + projectDescription.hashCode() + projectId.hashCode() + defaultLanguage.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ProjectSettingsData)) {
            return false;
        }
        ProjectSettingsData other = (ProjectSettingsData) obj;
        return this.projectType.equals(other.projectType) && this.projectDescription.equals(other.projectDescription) && this.projectId.equals(other.projectId) && this.defaultLanguage.equals(other.defaultLanguage);
    }

    @Override
    public String toString() {
        return "ProjectConfigurationInfo(" + projectId + " Type(" + projectType + ") Description(" + projectDescription + ")" + " DefaultLanguage(" + defaultLanguage + ")";
    }
}
