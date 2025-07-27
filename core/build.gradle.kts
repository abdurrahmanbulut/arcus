plugins {
    id("com.android.library")
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinter)
}

android {
    namespace = libs.versions.namespace.get() + ".network"
    compileSdk = libs.versions.compileSdk.get().toInt()
//    buildToolsVersion = libs.versions.buildToolsVersion.get()
    defaultConfig.minSdk = libs.versions.minSdk.get().toInt()
    defaultConfig.targetSdk = libs.versions.targetSdk.get().toInt()
    kotlin.jvmToolchain(libs.versions.jdk.get().toInt())
}

dependencies {

//    compileOnly(fileTree("../libs"))
//    compileOnly(project(":model"))
//    compileOnly(project(":common"))
//    implementation(libs.bundles.network)
//    implementation(libs.bundles.lifecycle)
//    implementation(libs.bundles.paging)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.koin)
    implementation(libs.koin.compose)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.logging.interceptor)
    implementation(libs.androidx.material3)
    implementation(libs.navigation)
    implementation(libs.converter.gson)
}