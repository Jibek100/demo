# demo

### Initialize MySQL repository before starting

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

3. Логи
   
Добавить лог

```Post method```

```http://localhost:8080/addlog```

```required parameters: String content```

Журнал логов

```Post method```

```http://localhost:8080/logs```

```required parameters: No```


