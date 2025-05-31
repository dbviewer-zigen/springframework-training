
## mvn wildfly:deploy
```
mvn wildfly:deploy
```

## 接続
```
http://127.0.0.1:8080/todo-mybatis-1.0/todos
```

### 単体テスト(Junit)

``` java
@Controller
public class HelloController {

    @GetMapping("/")
    public String heelo(ModelMap model) {
        model.addAttribute("message", "Hello World");
        return "hello";
    }
}

```

- hello.jsp
``` jsp
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

### テストプログラム
```java
@Autowired
private WebApplicationContext wac;

private MockMvc mockMvc;

@BeforeEach
public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
}

@Test
public void testGetDefault() throws Exception {

    mockMvc.perform(get("/"))
        .andExpect(status().isOk())//Http Statusの検証
        .andExpect(model().attributeExists("message")) // modelの属性名の検証
        .andExpect(model().attribute("message", "Hello World")); // modelに格納されている値の検証

}
```