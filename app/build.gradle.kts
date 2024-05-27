plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = 34
    buildToolsVersion = "34.0.0"
    ndkVersion = "26.3.11579264"

    defaultConfig {
        applicationId = "com.mefazm.rdpvr"
        minSdk = 32
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        ndk {
            abiFilters += listOf("arm64-v8a")
        }
    }

    signingConfigs {
        create("release") {
            storeFile = file("key.jks")
            storePassword = "fDfNfH421!"
            keyAlias = "key"
            keyPassword = "fDfNfH421!"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    externalNativeBuild {
        cmake {
            version = "3.29.3"
            path = file("src/main/cpp/CMakeLists.txt")
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    namespace = "com.mefazm.rdpvr"
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}
