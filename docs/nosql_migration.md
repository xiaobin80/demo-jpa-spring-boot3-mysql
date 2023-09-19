NoSQL Migration
===============


# data-redis

## Connection Pool
Commons-Pool2 for compulsory use in Spring Boot 2.x;
It is optional in Spring Boot 3.x.

- [Commons-Pool2](https://cwiki.apache.org/confluence/display/commons/Pool)    
Commons-Pool provides a generic object pooling interface, 
a toolkit for creating modular object pools and several general purpose pool implementations.

### Spring Boot 2.x
- [boot-features-nosql](https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/boot-features-nosql.html)
```
If you add your own @Bean of any of the auto-configured types, 
it replaces the default (except in the case of RedisTemplate, 
when the exclusion is based on the bean name, redisTemplate, not its type). 
By default, if commons-pool2 is on the classpath, you get a pooled connection factory.
```
- [Spring Boot 2.6 requires Commons Pool 2.11.x](https://github.com/spring-projects/spring-boot/issues/30826#issuecomment-1111939635)
```
commons-pool2 is missing some methods after version 2.8.1, causing spring Boot to report errors(spring boot 2.6.7)
```

### Spring Boot 3.x
[Table 1. Feature Availability across Redis Connectors](https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#redis:connectors:connection)

|Supported Feature|Lettuce|Jedis|
|-|-|-|
|Redis Sentinel|Master Lookup, Sentinel Authentication, Replica Reads|Master Lookup|
|Redis Cluster|Cluster Connections, Cluster Node Connections, Replica Reads|Cluster Connections, Cluster Node Connections|
|Transport Channels|TCP, OS-native TCP (epoll, kqueue), Unix Domain Sockets|TCP|
|Connection Pooling|X (using commons-pool2)|X (using commons-pool2)|
|Datatype support|Key, String, List, Set, Sorted Set, Hash, Server, Stream, Scripting, Geo, HyperLogLog|Key, String, List, Set, Sorted Set, Hash, Server, Scripting, Geo, HyperLogLog|


# Ref
- [Apache Commons Pool](https://commons.apache.org/proper/commons-pool/)
