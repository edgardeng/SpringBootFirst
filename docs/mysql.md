#MySql

## 服务管理
1. 启动
sudo service mysql start

2. 停止
sudo service mysql stop

3. 服务状态
sudo service mysql status

## 连接mysql

1. root用户登录
mysql -h localhost -u root -p

2. 创建数据库 (进入mysql后，数据库语句需要分号;)
```
  create database dearabao;
  show database;
  use dearabao;
  create table niuzi (name varchar(20));
  
  
```

### 创建用户
mysql> grant all privileges on test.* to user_test@localhost identified by '123456'

// 创建一个user_test用户，拥有数据库test所以的权限


### 执行sql脚本
* 方法一:
mysql -h localhost -u root -p123456 < db.sql
 
* 方法一: (已连接数据库,此时的提示符为 mysql> )

source F:\hello world\niuzi.sql (注意路径不用加引号的) 
或者 \. F:\hello world\niuzi.sql (注意路径不用加引号的) 回车即可
 
 