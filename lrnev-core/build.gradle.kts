dependencies {
    // 主要依赖
    implementation(libs.bundles.springBootLrnEv)
    implementation(libs.mybatisPlus)
    implementation(libs.hikariCP)
    implementation(libs.knife4j)
    implementation(libs.bundles.mapstructLombok)
    implementation(libs.annotations)
    implementation(libs.servletApi)
    implementation(libs.commonsPool2)
    implementation(libs.hutool)

    // 编译时依赖
    compileOnly(libs.lombok)
    compileOnly(libs.mapstructProcessor)

    // 注解处理器
    annotationProcessor(libs.lombok)
    annotationProcessor(libs.mapstructProcessor)


//    testImplementation(platform("org.junit:junit-bom:5.10.0"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
}