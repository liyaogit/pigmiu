
#关系型数据库

##优点

*强大的SQL功能
*ACID属性

##缺点

*无法存储数据结构
*schema扩展不方便
 >DDL执行有可能长时间锁表

*大数据场景下I/O较高
 >即使针对某一列，也会将整行读入内存

*全文搜索功能比价弱
 >like语句性能非常低

#NoSQL=not only SQL

*K-V存储：Redis
*文档数据库：MongoDB
<x
