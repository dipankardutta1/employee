delete from menu_role_map where id = 1;
delete from user_role_map where id = 1;
delete from user where id = 1;
delete from role where id = 1;
delete from menu where id = 1;

insert into user(id,name,username,password,active_flag,created_by,modified_by,created_date,modified_date,delete_flag) values(1,'admin','admin','$2a$10$zOiYoA/wsDWAon0pdXNdqeJJ9WOB3CiycSN1lyJmgvYgMwONMlL3W','Y','admin','admin',NOW(),NOW(),'N');
insert into role(id,role_name,active_flag,created_by,modified_by,created_date,modified_date,delete_flag) values(1,'admin','Y','admin','admin',NOW(),NOW(),'N');
insert into menu(id,menu_name,menu_url,active_flag,created_by,modified_by,created_date,modified_date,delete_flag) values(1,'admin','admin','Y','admin','admin',NOW(),NOW(),'N');
insert into user_role_map(id,user_id,role_id,active_flag,created_by,modified_by,created_date,modified_date,delete_flag) values(1,1,1,'Y','admin','admin',NOW(),NOW(),'N');
insert into menu_role_map(id,menu_id,role_id,active_flag,created_by,modified_by,created_date,modified_date,delete_flag) values(1,1,1,'Y','admin','admin',NOW(),NOW(),'N');









