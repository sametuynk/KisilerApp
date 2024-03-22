// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.44")

    }
}
plugins {
    id("com.android.application") version "8.1.3" apply false
    id ("com.google.dagger.hilt.android") version "2.42" apply false
}


