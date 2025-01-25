INSERT INTO dev_user values(2169860,0,'developer','home|task|overalltasks','36:0|03:2|56:1|90:1',
                           'Jayesh','Patil','Nagpur','3 years','WebTeam');
                           
INSERT INTO dev_user values(1234567,1,'developer','home|task|overalltasks','36:0|03:2|56:1|90:1',
                           'Nikhil','Patil','Dhule','4 years','WebTeam');  

INSERT INTO dev_user values(5432156,1,'support','home|task|overalltasks','36:0|03:2|56:1|90:1',
                           'Durgesh','Yeole','Mumbai','5 years','FNO');


INSERT INTO dev_tasks
values(512,1,'Logs genration issue','CS','Logs are not genrating at client UAT','logs generation issue','2169860:Jayesh:Patil~1234567:Nikhil:Patil','2024-01-08','2024-01-15','java~weblogic',3,0,'restart weblogic server from linux machine with admin rights'); 

INSERT INTO dev_tasks
values(320,1,'Server not starting','ICICI','after new update server not going UP','WebLogicserver is not getting up','2169860:Jayesh:Patil~5432156:Durgesh:Yeole','2024-01-10','2024-01-25','java~linux~weblogic',2,2,'Roll back previous server patch'); 

INSERT INTO dev_tasks
values(532,3,'Need Apache Tomcat upgradation','CITI','Kindly update on the plan regarding apache tomcat upgradation','Apache software upgrade','2169860:Jayesh:Patil~1234567:Nikhil:Patil','2024-12-02','2025-01-12','java~ApacheTomcat',1,1,'Confirm whether the JDK version 11.0.25 is compatible as a substitute for JDK version 11.0.16 then proceed'); 

INSERT INTO dev_tasks
values(510,2,'Web Utility VAPT observations','SBISG','Below table contains comments on VAPT observations, please review','VAPT findings 2025','2169860:Jayesh:Patil','2025-01-02','2025-01-06','java~WebLogic',2,2,'mentioned points are not part of web utility and discussed earlier'); 