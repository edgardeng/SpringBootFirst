# Redis

## 安装

### Linux下安装Redis

1. 下载文件  wget http://download.redis.io/releases/redis-4.0.11.tar.gz 

2. 压缩文件  tar -zxvf redis-4.0.11.tar.gz

3. cd redis-4.0.11

4. make 

5. sudo make install  (默认安装在 /usr/local/redis,或指定PREFIX=)

6. mv redis.conf /usr/local/redis/etc (没有则创建etc)

7. vi /usr/local/redis/etc/redis.conf  (daemonize no为yes 后台启动)

8. /usr/local/redis/bin/redis-server /usr/local/redis/etc/redis.conf (开启redis )

9. 设置开机启动 vi /etc/rc.local (添加命令8)


## 常用命令
pkill redis 停止

rm -rf /usr/local/redis 删除

## MySQL

mysql -uroot -p 你的密码

#服务管理
#启动
sudo service mysql start
#停止
sudo service mysql stop
#服务状态
sudo service mysql status
复制代码
#连接数据库
mysql -h 127.0.0.1 -P 3306 -uroot -p123456
#-h为远程IP，-P为端口号，-u为用户名，-p为密码
#测试SQL
show databases;




