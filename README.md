# SpringMVC

文件目录结构
```
|-- src
    |-- main
        |-- java
        |   |-- com
        |       |-- yhb
        |           |-- controller
        |           |   |-- HelloController.java
        |           |   |-- StudentController.java
        |           |-- dao
        |           |   |-- StudentMapper.java
        |           |-- domain
        |           |   |-- Student.java
        |           |-- service
        |               |-- StudentService.java
        |               |-- impl
        |                   |-- StudentServiceImpl.java
        |-- resources
        |   |-- datasource.properties
        |   |-- mybatis-config.xml
        |   |-- mapper
        |   |   |-- StudentMapper.xml
        |   |-- spring
        |       |-- spring-dao.xml
        |       |-- spring-service.xml
        |       |-- spring-web.xml
        |-- webapp
            |-- static
            |-- WEB-INF
                |-- web.xml
                |-- views
                    |-- hello.jsp
                    |-- index.jsp
                    |-- landing.jsp
```

## SpringMVC 简单跳转
实现步骤简述:
1. 用户访问index页面,点击按钮
2. 按钮绑定 `/hello` `/handing` 触发控制器Controller类
3. Controller类直接跳转页面

## 整合Mybatis
实现步骤简述:
1. 用户访问index页面,点击按钮
2. 按钮绑定 `/getStudentAll` `/getStudentById` 
3. 前端页面通过 request请求,触发控制器
4. 控制器中调用Service服务,去实现Mapper DAO层接口
5. Mapper接口通过Mybatis映射文件去数据库查询,返回结果
6. 结果保存于Model对象,返回前端页面
