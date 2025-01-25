CREATE TABLE dev_user(
    dev_empid int PRIMARY KEY,
    dev_type int,
    dev_tag varchar2(100),
    dev_page_access varchar2(1000),
    dev_desktask_id varchar2(1000),
    
    dev_firstname varchar2(100),
    dev_lastname varchar2(100),
    dev_baselocation varchar2(100),
    dev_experience varchar2(100),
    dev_dev_team varchar2(2000));
    
CREATE TABLE dev_tasks(
    task_id int PRIMARY KEY,
    task_pool int,
    task_name varchar2(3000),
    task_client_name varchar2(1000),
    task_info varchar2(3000),
    task_email varchar2(3000),
    task_pickedby varchar2(3000),
    task_reportdate DATE,
    task_resolutiondate DATE,
    task_tag varchar2(3000),
    task_priority number,
    task_status number,
    task_solution varchar2(3000));