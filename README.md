# ARouter
路由框架
1.先在项目根目录的 build.gradle 的 repositories 添加:
```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

2.然后在dependencies添加:
```
dependencies {
	...
	implementation 'com.github.chentl666.ARouter:api:1.0.0'
	implementation 'com.github.chentl666.ARouter:annotation:1.0.0'
	implementation 'com.github.chentl666.ARouter:compiler:1.0.0'
}
```