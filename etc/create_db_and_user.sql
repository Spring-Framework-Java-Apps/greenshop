create database oscommerce2;

CREATE USER 'oscommerce2'@'%' IDENTIFIED BY 'oscommerce2pwd';

CREATE USER 'oscommerce2'@'localhost' IDENTIFIED BY 'oscommerce2pwd';

GRANT ALL PRIVILEGES ON oscommerce2.* TO 'oscommerce2'@'localhost';

GRANT ALL PRIVILEGES ON oscommerce2.* TO 'oscommerce2'@'%';

flush privileges;