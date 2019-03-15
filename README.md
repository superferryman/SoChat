### 包解析

- common: 字符变量等公用包
- client: 客户端
 
    - socket： 通讯用包
    
    - ui: ui用包
    
- server: 服务端
 
    - socket： 通讯用包
    
    - ui: ui用包
    
### 暂时可用接口
1. server端的init接口(sever的ui你先空着 我后面补上)
2. client端暂时只提供sendMessage(String)方法

### 大概思路
一切开放的接口都会放在客户端/服务端的Service类中，尽量只访问这两个类，需要接口再想办法开放

### 备注

```xml
# package file
*.war
*.ear

# kdiff3
*.orig

# maven
target/

# eclipse
.settings/
.project
.classpath

# idea
.idea/
/idea/
*.ipr
*.iml
*.iws

# temp file
*.log
*.cache
*.diff
*.patch
*.tmp

# system file
.DS_Store
Thumbs.db
```