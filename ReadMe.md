
# 配備方法
## 確認環境
- macOS Sequoia 
- wildfly 2.2.3.Final
- openjdk version "23.0.2"

## wildFly起動例
``` sh
sh /opt/wildfly-29.0.0.Final/bin/standalone.sh 
```

## wildFlyへの配備方法
```
mvn wildfly:deploy
```

## 接続URL

- http://127.0.0.1:8080/todo-mybatis-1.0/

- http://127.0.0.1:8080/todo-mybatis-1.0/todos


# テスト対象のプログラム
### Controllerクラス

``` java
// HelloController.java
@Controller
public class HelloController {

    @GetMapping("/")
    public String heelo(ModelMap model) {
        model.addAttribute("message", "Hello World");
        return "hello";
    }
}

```
### JSP

``` jsp
// hello.js
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<meta charset="UTF-8" />
<title>HELLO</title>
</head>

<body>
<p>${message}</p>
</body>
</html>
```

# テストプログラム
```java
// TodoControllerTest.java
package com.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitConfig
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:test-applicationContext.xml" })
public class TodoControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
            this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testGetDefault() throws Exception {

        // rootにGET
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attributeExists("message"))
                .andExpect(model().attribute("message", "Hello World"));

    }

    @Test
    public void testCreateTodo() throws Exception {
        mockMvc.perform(post("/todos/create")
                .param("description", "Test TODO")
                .param("completed", "false"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/todos"));
    }

    @Test
    public void testGetTodo() throws Exception {
        mockMvc.perform(post("/todos/create")
                .param("description", "Test TODO")
                .param("completed", "false"))
                .andExpect(status().is3xxRedirection());

        mockMvc.perform(get("/todos/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("todoDetails"))
                .andExpect(model().attributeExists("todo"));
    }

    @Test
    public void testUpdateTodo() throws Exception {
        mockMvc.perform(post("/todos/create")
                        .param("description", "Test TODO")
                        .param("completed", "false"))
                        .andExpect(status().is3xxRedirection());

        mockMvc.perform(post("/todos/update/1")
                        .param("description", "Updated TODO")
                        .param("completed", "true"))
                        .andExpect(status().is3xxRedirection())
                        .andExpect(redirectedUrl("/todos"));
    }

    @Test
    public void testDeleteTodo() throws Exception {
        mockMvc.perform(post("/todos/create")
                .param("description", "Test TODO")
                .param("completed", "false"))
                .andExpect(status().is3xxRedirection());

        mockMvc.perform(get("/todos/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/todos"));
    }
}

```