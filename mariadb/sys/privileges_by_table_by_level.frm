TYPE=VIEW
query=select `t`.`TABLE_SCHEMA` AS `TABLE_SCHEMA`,`t`.`TABLE_NAME` AS `TABLE_NAME`,`privs`.`GRANTEE` AS `GRANTEE`,`privs`.`PRIVILEGE_TYPE` AS `PRIVILEGE`,`privs`.`LEVEL` AS `LEVEL` from (`INFORMATION_SCHEMA`.`TABLES` `t` join (select NULL AS `TABLE_SCHEMA`,NULL AS `TABLE_NAME`,`information_schema`.`USER_PRIVILEGES`.`GRANTEE` AS `GRANTEE`,`information_schema`.`USER_PRIVILEGES`.`PRIVILEGE_TYPE` AS `PRIVILEGE_TYPE`,\'GLOBAL\' AS `LEVEL` from `INFORMATION_SCHEMA`.`USER_PRIVILEGES` union select `information_schema`.`SCHEMA_PRIVILEGES`.`TABLE_SCHEMA` AS `TABLE_SCHEMA`,NULL AS `TABLE_NAME`,`information_schema`.`SCHEMA_PRIVILEGES`.`GRANTEE` AS `GRANTEE`,`information_schema`.`SCHEMA_PRIVILEGES`.`PRIVILEGE_TYPE` AS `PRIVILEGE_TYPE`,\'SCHEMA\' AS `LEVEL` from `INFORMATION_SCHEMA`.`SCHEMA_PRIVILEGES` union select `information_schema`.`TABLE_PRIVILEGES`.`TABLE_SCHEMA` AS `TABLE_SCHEMA`,`information_schema`.`TABLE_PRIVILEGES`.`TABLE_NAME` AS `TABLE_NAME`,`information_schema`.`TABLE_PRIVILEGES`.`GRANTEE` AS `GRANTEE`,`information_schema`.`TABLE_PRIVILEGES`.`PRIVILEGE_TYPE` AS `PRIVILEGE_TYPE`,\'TABLE\' AS `LEVEL` from `INFORMATION_SCHEMA`.`TABLE_PRIVILEGES`) `privs` on((`t`.`TABLE_SCHEMA` = `privs`.`TABLE_SCHEMA` or `privs`.`TABLE_SCHEMA` is null) and (`t`.`TABLE_NAME` = `privs`.`TABLE_NAME` or `privs`.`TABLE_NAME` is null) and `privs`.`PRIVILEGE_TYPE` in (\'SELECT\',\'INSERT\',\'UPDATE\',\'DELETE\',\'CREATE\',\'ALTER\',\'DROP\',\'INDEX\',\'REFERENCES\',\'TRIGGER\',\'GRANT OPTION\',\'SHOW VIEW\',\'DELETE HISTORY\'))) where `t`.`TABLE_SCHEMA` not in (\'sys\',\'mysql\',\'information_schema\',\'performance_schema\')
md5=990f2dc951d82fc270bfa915549771f0
updatable=0
algorithm=2
definer_user=mariadb.sys
definer_host=localhost
suid=0
with_check_option=0
timestamp=0001734518638621330
create-version=2
source=SELECT t.TABLE_SCHEMA,\n       t.TABLE_NAME,\n       privs.GRANTEE,\n       privs.PRIVILEGE_TYPE,\n       privs.LEVEL\nFROM INFORMATION_SCHEMA.TABLES AS t\nJOIN ( SELECT NULL AS TABLE_SCHEMA,\n              NULL AS TABLE_NAME,\n              GRANTEE,\n              PRIVILEGE_TYPE,\n             \'GLOBAL\' LEVEL\n           FROM INFORMATION_SCHEMA.USER_PRIVILEGES\n         UNION\n       SELECT TABLE_SCHEMA,\n              NULL AS TABLE_NAME,\n              GRANTEE,\n              PRIVILEGE_TYPE,\n              \'SCHEMA\' LEVEL\n           FROM INFORMATION_SCHEMA.SCHEMA_PRIVILEGES\n         UNION\n       SELECT TABLE_SCHEMA,\n              TABLE_NAME,\n              GRANTEE,\n              PRIVILEGE_TYPE,\n              \'TABLE\' LEVEL\n           FROM INFORMATION_SCHEMA.TABLE_PRIVILEGES\n       ) privs\n    ON (t.TABLE_SCHEMA = privs.TABLE_SCHEMA OR privs.TABLE_SCHEMA IS NULL)\n   AND (t.TABLE_NAME = privs.TABLE_NAME OR privs.TABLE_NAME IS NULL)\n   AND privs.PRIVILEGE_TYPE IN (\'SELECT\', \'INSERT\', \'UPDATE\', \'DELETE\',\n                                \'CREATE\', \'ALTER\', \'DROP\', \'INDEX\',\n                                \'REFERENCES\', \'TRIGGER\', \'GRANT OPTION\',\n                                \'SHOW VIEW\', \'DELETE HISTORY\')\nWHERE t.TABLE_SCHEMA NOT IN (\'sys\', \'mysql\',\'information_schema\',\n                             \'performance_schema\');
client_cs_name=utf8mb3
connection_cl_name=utf8mb3_general_ci
view_body_utf8=select `t`.`TABLE_SCHEMA` AS `TABLE_SCHEMA`,`t`.`TABLE_NAME` AS `TABLE_NAME`,`privs`.`GRANTEE` AS `GRANTEE`,`privs`.`PRIVILEGE_TYPE` AS `PRIVILEGE`,`privs`.`LEVEL` AS `LEVEL` from (`INFORMATION_SCHEMA`.`TABLES` `t` join (select NULL AS `TABLE_SCHEMA`,NULL AS `TABLE_NAME`,`information_schema`.`USER_PRIVILEGES`.`GRANTEE` AS `GRANTEE`,`information_schema`.`USER_PRIVILEGES`.`PRIVILEGE_TYPE` AS `PRIVILEGE_TYPE`,\'GLOBAL\' AS `LEVEL` from `INFORMATION_SCHEMA`.`USER_PRIVILEGES` union select `information_schema`.`SCHEMA_PRIVILEGES`.`TABLE_SCHEMA` AS `TABLE_SCHEMA`,NULL AS `TABLE_NAME`,`information_schema`.`SCHEMA_PRIVILEGES`.`GRANTEE` AS `GRANTEE`,`information_schema`.`SCHEMA_PRIVILEGES`.`PRIVILEGE_TYPE` AS `PRIVILEGE_TYPE`,\'SCHEMA\' AS `LEVEL` from `INFORMATION_SCHEMA`.`SCHEMA_PRIVILEGES` union select `information_schema`.`TABLE_PRIVILEGES`.`TABLE_SCHEMA` AS `TABLE_SCHEMA`,`information_schema`.`TABLE_PRIVILEGES`.`TABLE_NAME` AS `TABLE_NAME`,`information_schema`.`TABLE_PRIVILEGES`.`GRANTEE` AS `GRANTEE`,`information_schema`.`TABLE_PRIVILEGES`.`PRIVILEGE_TYPE` AS `PRIVILEGE_TYPE`,\'TABLE\' AS `LEVEL` from `INFORMATION_SCHEMA`.`TABLE_PRIVILEGES`) `privs` on((`t`.`TABLE_SCHEMA` = `privs`.`TABLE_SCHEMA` or `privs`.`TABLE_SCHEMA` is null) and (`t`.`TABLE_NAME` = `privs`.`TABLE_NAME` or `privs`.`TABLE_NAME` is null) and `privs`.`PRIVILEGE_TYPE` in (\'SELECT\',\'INSERT\',\'UPDATE\',\'DELETE\',\'CREATE\',\'ALTER\',\'DROP\',\'INDEX\',\'REFERENCES\',\'TRIGGER\',\'GRANT OPTION\',\'SHOW VIEW\',\'DELETE HISTORY\'))) where `t`.`TABLE_SCHEMA` not in (\'sys\',\'mysql\',\'information_schema\',\'performance_schema\')
mariadb-version=110602
