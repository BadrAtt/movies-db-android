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
            const val navigationFragmentKtx= "androidx.navigation:navigation-fragment-ktx:$version"
            const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Lifecycle {
            private const val version = "2.5.1"
            const val liveDataKtx =
                "androidx.lifecycle:lifecycle-livedata-ktx:$version"
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

    object Test {
        object JUnit {
            private const val version = "4.13.2"
            const val junit = "junit:junit:$version"
        }
    }

}
