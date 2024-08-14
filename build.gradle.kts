plugins {
	java
	id("org.springframework.boot") version libs.versions.springBoot.get()
	id("io.spring.dependency-management") version libs.versions.springDependencyManagement.get()
	kotlin("jvm") version libs.versions.kotlin.get()
	kotlin("plugin.spring") version libs.versions.kotlin.get()
}

group = "com.github.lrnev"
version = "1.0.0"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	// 本地
	mavenLocal()
	// 阿里云提供的 Maven 中央仓库镜像，用于加快下载速度
	maven { url = uri("https://maven.aliyun.com/repository/central") }
	// 阿里云提供的公共 Maven 仓库，包含多种第三方库
	maven { url = uri("https://maven.aliyun.com/repository/public") }
	// 阿里云提供的 Spring 仓库
	maven { url = uri("https://maven.aliyun.com/repository/spring") }
	// 阿里云提供的 Spring 插件仓库
	maven { url = uri("https://maven.aliyun.com/repository/spring-plugin") }
	// Spring 官方发布的仓库，包含最新的 Spring 框架及其相关组件
	maven { url = uri("https://repo.spring.io/release") }
	// 中央仓库
	mavenCentral()
}

subprojects {
	apply(plugin = "java")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "kotlin")
	apply(plugin = "kotlin-spring")
}

