plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinter)
}

android {

    namespace = libs.versions.namespace.get()
    compileSdk = libs.versions.compileSdk.get().toInt()
//    buildToolsVersion = libs.versions.buildToolsVersion.get()
    defaultConfig.minSdk = libs.versions.minSdk.get().toInt()
    defaultConfig.versionCode = 1
    defaultConfig.versionName = "1.0"
    defaultConfig.targetSdk = libs.versions.targetSdk.get().toInt()
    kotlin.jvmToolchain(libs.versions.jdk.get().toInt())

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(fileTree("../libs"))
    implementation(project(":core"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.navigation)
    implementation(libs.koin)
    implementation(libs.koin.compose)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)
    implementation(libs.lottie)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.datastore)
}
