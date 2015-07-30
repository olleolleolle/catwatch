create table contributor (id bigint not null, organization_id bigint not null, snapshot_date timestamp not null, name varchar(255), organization_name varchar(255), organizational_commits_count integer, organizational_projects_count integer, personal_commits_count integer, personal_projects_count integer, url varchar(255), primary key (id, organization_id, snapshot_date))
create table lang_list (project_id serial not null, language varchar(255))
create table project (id serial generated by default as identity, commits_count integer, contributors_count integer, description varchar(255), forks_count integer, git_hub_project_id bigint, last_pushed varchar(255), name varchar(255), organization_name varchar(255), primary_language varchar(255), score integer, snapshot_date timestamp, stars_count integer, url varchar(255), primary key (id))
create table statistics (id bigint not null, snapshot_date timestamp not null, all_contributors_count integer, all_forks_count integer, all_size_count integer, all_stars_count integer, members_count integer, organization_name varchar(255), private_project_count integer, program_languages_count integer, public_project_count integer, tags_count integer, teams_count integer, primary key (id, snapshot_date))
alter table lang_list add constraint FK_4x7aha9tip7bp2yiwiwka7rmc foreign key (project_id) references project