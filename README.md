# Nukkit-NickSystem
Simple NickSystem for Nukkit server!

### - Features
* MySQL Support

### - Commands
* /nick
* /nick <nickname>
* /nick reset

### - HowToUse
You will find a file called mysql.json in plugins/NickSystem/ you need to file in you account data of MySQL.

Then it will look like that:
```json
{
  "profile": {
    "host": "127.0.0.1",
    "database": "System",
    "user": "root",
    "password": "123456",
    "port": 3306
  }
}
```
  
### You need luckchat or any chat formatting plugin to use the NickSystem!

config of LuckChat:

```yml
FirstRun: false
ChatAsync: true
Chat:
 default: '[%disname%] >> %msg%'
 admin: '[%disname%] >> %msg%'
NameTag:
  update: 20
  updateAsync: true
  default: '%disname%'
  admin: '%disname%'
```

#### Download of LuckChat
* https://cloudburstmc.org/resources/luckchat.213/

