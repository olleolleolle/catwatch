package org.zalando.catwatch.backend.repo.populate;

import static org.zalando.catwatch.backend.repo.populate.BuilderUtil.freshId;
import static org.zalando.catwatch.backend.repo.populate.BuilderUtil.random;
import static org.zalando.catwatch.backend.repo.populate.BuilderUtil.randomDate;
import static org.zalando.catwatch.backend.repo.populate.BuilderUtil.randomLanguage;
import static org.zalando.catwatch.backend.repo.populate.BuilderUtil.randomProjectName;

import org.zalando.catwatch.backend.model.Project;
import org.zalando.catwatch.backend.repo.ProjectRepository;

public class ProjectBuilder {

	private Project project;

	private ProjectRepository projectRepository;

	public ProjectBuilder(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
		project = new Project(freshId(), randomDate());
		project.setName(randomProjectName());
		project.setPrimaryLanguage(randomLanguage());
		project.setForksCount(random(1, 10));
		project.setStarsCount(random(1, 4));
	}

	private void updateUrl() {
		project.setUrl("https://github.com/" + project.getOrganizationName() + "/" + project.getName());
	}

	public ProjectBuilder name(String name) {
		project.setName(name);
		return this;
	}

	public ProjectBuilder organizationName(String organizationName) {
		project.setOrganizationName(organizationName);
		return this;
	}

	public Project create() {
		
		updateUrl();
		
		Project p = new Project(project.getId(), project.getSnapshotDate());
		p.setName(project.getName());
		p.setPrimaryLanguage(project.getPrimaryLanguage());
		p.setForksCount(project.getForksCount());
		p.setStarsCount(project.getStarsCount());
		return p;
	}

	public Project save() {
		return projectRepository.save(create());
	}

}