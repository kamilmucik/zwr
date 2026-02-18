

MySQL
```sql
CREATE DATABASE zwroty_e_strix_com;
```
```sql
CREATE USER 'user'@'localhost' IDENTIFIED WITH mysql_native_password BY 'user';
```

```sql
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES ON user.* TO 'user'@'localhost';
FLUSH PRIVILEGES;
```

```sql
GRANT FILE ON *.* TO 'user'@'localhost';
```



```bash
docker-compose up --force-recreate --build sonarqube  
```
