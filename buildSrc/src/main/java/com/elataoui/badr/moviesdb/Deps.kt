package com.elataoui.badr.moviesdb

object Deps {

    object Androidx {
        object CoreKtx {
            private const val version = "1.9.0"
            const val coreKtx = "androidx.core:core-ktx:$version"
        }

        object AppCompat {
            private const val version = "1.5.1"
            const val appCompat = "androidx.appcompat:appcompat:$version"
        }

        object ConstraintLayout {
            private const val version = "2.1.4"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:$version"
        }

        object Navigation {
            private const val version = "2.5.2"
            const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Lifecycle {
            private const val version = "2.5.1"
            const val liveDataKtx =
                "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        }

        object Room {
            private const val version = "2.4.3"
            const val room = "androidx.room:room-runtime:$version"
            const val processor = "androidx.room:room-compiler:$version"
        }

        object Test {
            object JUnit {
                private const val version = "1.1.3"
                const val jUnit = "androidx.test.ext:junit:$version"
            }

            object Espresso {
                private const val version = "3.4.0"
                const val espressoCore = "androidx.test.espresso:espresso-core:$version"
            }
        }
    }

    object Google {
        object Material {
            private const val version = "1.6.1"
            const val material = "com.google.android.material:material:$version"
        }
    }

    object Timber {
        private const val version = "5.0.1"
        const val timber = "com.jakewharton.timber:timber:$version"
    }

    object Hilt {
        private const val version = "2.44"
        const val hilt = "com.google.dagger:hilt-android:$version"
        const val hilt_compiler = "com.google.dagger:hilt-android-compiler:$version"
    }

    object Glide {
        private const val version = "4.13.2"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }

    object Serialization {
        private const val serialization_version = "1.4.0"
        private const val serialization_converter_version = "0.8.0"
        const val kotlinxSerialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:$serialization_version"
        const val retrofitKotlinxSerializationConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:" +
                    serialization_converter_version
    }

    object Networking {
        private const val retrofit_version = ""
        private const val logging_interceptor_version = "4.9.3"
        private const val ok2CurlVersion = "0.8.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
        const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:" +
                logging_interceptor_version
        const val ok2Curl = "com.github.mrmike:ok2curl:$ok2CurlVersion"
    }

    object Coroutines {
        private const val version = "1.6.4"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Test {
        object JUnit {
            private const val version = "4.13.2"
            const val junit = "junit:junit:$version"
        }
    }

}
