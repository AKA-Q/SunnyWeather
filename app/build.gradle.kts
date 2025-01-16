plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.sunnyweather"
    compileSdk = 35

    viewBinding {
        enable = true
    }

    defaultConfig {
        applicationId = "com.example.sunnyweather"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("config") { // 创建签名配置
            storeFile = file(project.findProperty("KEY_PATH") as String)
            storePassword = project.findProperty("KEY_PASS") as String
            keyAlias = project.findProperty("ALIAS_NAME") as String
            keyPassword = project.findProperty("ALIAS_PASS") as String
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("config")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.recyclerview)
    implementation(libs.lifecycle.extensions)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.material)
    implementation(libs.swiperefreshlayout)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
}