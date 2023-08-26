# demo

### Initialize MySQL database before starting

```bash
create database file_database;
create user 'user'@'%' identified by 'ThePassword';
grant all on file_database.* to 'user'@'%';
```
### Run application 

Run demo application from editor or shell

### urls 
1. Загрузить файл

```Post method```

```http://localhost:8080/upload```

```required parameters: MultipartFile file```

2. Запрос данных о файле

```Post method```

```http://localhost:8080/getinfo```

```required parameters: String fileName```
