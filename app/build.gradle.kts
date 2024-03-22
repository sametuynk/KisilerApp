import groovyjarjarantlr.build.ANTLR.compiler

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.kisilerapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kisilerapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures{
        viewBinding = true
        dataBinding = true
    }
}

apply(plugin = "androidx.navigation.safeargs")
apply(plugin = "dagger.hilt.android.plugin")



dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    implementation("androidx.navigation:navigation-ui:2.7.7")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel:2.7.0")

    // Dagger Core
    implementation ("com.google.dagger:dagger:2.44")
    annotationProcessor  ("com.google.dagger:dagger-compiler:2.44")

    // Dagger Android
    api ("com.google.dagger:dagger-android:2.44")
    api ("com.google.dagger:dagger-android-support:2.44")
    annotationProcessor  ("com.google.dagger:dagger-android-processor:2.44")

    // Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:2.44")
    annotationProcessor  ("com.google.dagger:hilt-android-compiler:2.44")

    //Room
    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")
    //RxJava
    implementation ("androidx.room:room-rxjava2:2.6.1")
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")














}