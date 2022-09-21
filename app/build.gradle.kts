import com.elataoui.badr.moviesdb.AppConfigData
import com.elataoui.badr.moviesdb.Deps

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = AppConfigData.compileSdk

    defaultConfig {
        applicationId = AppConfigData.applicationId
        minSdk = AppConfigData.minSdk
        targetSdk = AppConfigData.targetSdk
        versionCode = AppConfigData.versionCode
        versionName = AppConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Deps.Androidx.CoreKtx.coreKtx)
    implementation(Deps.Androidx.AppCompat.appCompat)
    implementation(Deps.Google.Material.material)
    implementation(Deps.Androidx.ConstraintLayout.constraintLayout)
    testImplementation(Deps.Test.JUnit.junit)
    androidTestImplementation(Deps.Androidx.Test.JUnit.jUnit)
    androidTestImplementation(Deps.Androidx.Test.Espresso.espressoCore)
}
