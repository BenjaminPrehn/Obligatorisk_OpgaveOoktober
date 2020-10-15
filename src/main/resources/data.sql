-- INSERT EMPLOYEES
insert into employee (employee_id, firstname, lastname, email) values (1, 'Benjamin', 'Prehn', 'benj075d@stud.kea.dk');

-- INSERT PROJECTS
insert into projects (project_id, name, status, description) values (1000, 'Obligatorisk opgave', 'INPROGRESS', 'Aflever opgaven inden klokken 15.30 ');

-- INSERT PROJECT_EMPLOYEE_RELATION (Removed duplicates from video)
insert into project_employee (employee_id, project_id) values (1,1000);