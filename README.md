This is the demo that shows a datasheet.

<img src="https://images2018.cnblogs.com/blog/359743/201806/359743-20180603225915973-2039825735.png" />

* [Java17](https://adoptium.net/temurin/releases/?version=17)
* Spring Boot    
>> [3.x](https://spring.io/projects/spring-boot#learn)
* JPA    
>> [v3.1](https://jakarta.ee/specifications/persistence/3.1/jakarta-persistence-spec-3.1.pdf)
* MySQL
>> [redis-server](https://tdtc-hrb.github.io/csdn/post/ops_dc_redis_ubuntu/)
* Thymeleaf    
>> [v3.1.x](https://www.thymeleaf.org/doc/articles/thymeleaf31whatsnew.html)
* ReactJS    
>> [userDetails-saga](https://github.com/xiaobin80/userDetails-saga)    
>> [userDetails-thunk](https://github.com/xiaobin80/userDetails-thunk)    

## Table of Contents
- [App](#app)
- [PC](#pc)
- [Package](#package)
- [Run PC](#run)

### App
```java
	//@CrossOrigin(origins = "http://localhost:3000")
	@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3030"})
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDetails>> getAllUser() {
		List<UserDetails> user = userService.getUsers();
		return new ResponseEntity<List<UserDetails>>(user, HttpStatus.OK);
	}
```

### Pc
```java
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public String findAll(Model model) {
		List<UserDetails> users = userService.getUsers();
		
		model.addAttribute("users", users);
		
		for(UserDetails user : users) {
			System.out.println(user.getEmail() + " " + user.getName());
		}
		return "userList";
	}
```

### Package
```bash
mvn package -DskipTests
```

### Run
[pc side](http://localhost:8080/user/listPage)
