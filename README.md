# custom-spring-boot-starter

`custom-logger` 와 `page-database` 를 묶은 `starter` 들을 만든 예제 프로젝트.  

### how to use
`sample-web` 을 사용하면 된다.  

```
$ mvn install

[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for Custom Spring Boot Project 0.0.1-SNAPSHOT:
[INFO] 
[INFO] custom-logger ...................................... SUCCESS [ 10.312 s]
[INFO] Page Database ...................................... SUCCESS [ 11.693 s]
[INFO] Custom Spring Boot Project ......................... SUCCESS [  0.318 s]
[INFO] Custom Spring Boot AutoConfigure ................... SUCCESS [  1.972 s]
[INFO] Custom Spring Boot Starters ........................ SUCCESS [  0.055 s]
[INFO] Custom Spring Boot Starter Custom Log .............. SUCCESS [  0.509 s]
[INFO] Custom Spring Boot Starter Page Database ........... SUCCESS [  0.423 s]
[INFO] sample-web ......................................... SUCCESS [  1.219 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  27.780 s
[INFO] Finished at: 2019-10-04T12:32:53+09:00
[INFO] ------------------------------------------------------------------------
```

=

관련 문서는 [spring-boot-starter-custom](https://nevercaution.github.io/2019/10/02/spring-boot-starter-custom/) 에서 확인할 수 있다.

### note

* jar 들은 로컬환경에서 작업했기 때문에 deploy 에 대한 부분은 고려되지 않았다.  
* `starter` 들의 설정 디폴트 값들에 대한 예외처리는 모두 대응되어 있지 않다.  
* 프로젝트의 구조는 [spring-boot-starter github](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-starters) 를 참고했다. 

