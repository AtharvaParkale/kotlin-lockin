package com.example.kotlinlockin.common.data

data class CommonQuestionsModel(
    val title: String,
    val youtubeVideoUrl: String,
    val youtubeThumbnailUrl: String,
    val articleUrl: String
)

fun getAllCommonQuestions(): List<CommonQuestionsModel> {
    return listOf(
        CommonQuestionsModel(
            title = "What is the syntax for modifiers?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=ekB0w7tkG7k",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/ekB0w7tkG7k/hqdefault.jpg",
            articleUrl = "https://developer.android.com/jetpack/compose/modifiers"
        ),
        CommonQuestionsModel(
            title = "How to iterate a list in compose and render UI?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=fZ0S24T1epA",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/fZ0S24T1epA/hqdefault.jpg",
            articleUrl = "https://developer.android.com/jetpack/compose/lists"
        ),
        CommonQuestionsModel(
            title = "What are the different types of classes in Kotlin?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=F9UC9DY-vIU",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/F9UC9DY-vIU/hqdefault.jpg",
            articleUrl = "https://kotlinlang.org/docs/classes.html"
        ),
        CommonQuestionsModel(
            title = "What is suspend keyword in Kotlin?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=F6thT9K4aH8",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/F6thT9K4aH8/hqdefault.jpg",
            articleUrl = "https://kotlinlang.org/docs/coroutines-basics.html#suspending-functions"
        ),
        CommonQuestionsModel(
            title = "What is remember keyword in compose?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=s9_gV6O9gpo",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/s9_gV6O9gpo/hqdefault.jpg",
            articleUrl = "https://developer.android.com/jetpack/compose/state#remember"
        ),
        CommonQuestionsModel(
            title = "How to make an API call in compose?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=MEqM6f1Bav0",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/MEqM6f1Bav0/hqdefault.jpg",
            articleUrl = "https://developer.android.com/topic/libraries/architecture/viewmodel#network"
        ),
        CommonQuestionsModel(
            title = "How to implement timer in compose?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=yx6N4Hs60E8",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/yx6N4Hs60E8/hqdefault.jpg",
            articleUrl = "https://developer.android.com/jetpack/compose/side-effects#rememberCoroutineScope"
        ),
        CommonQuestionsModel(
            title = "How to parse JSON in compose?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=ITnY2tQdEew",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/ITnY2tQdEew/hqdefault.jpg",
            articleUrl = "https://developer.android.com/topic/libraries/architecture/viewmodel#network"
        ),
        CommonQuestionsModel(
            title = "What is interface and abstract keyword in Kotlin?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=GDV3_vdBkho",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/GDV3_vdBkho/hqdefault.jpg",
            articleUrl = "https://kotlinlang.org/docs/interfaces.html"
        ),
        CommonQuestionsModel(
            title = "What is private set keyword and why is it used in Compose?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=KjY94sAKLlw",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/KjY94sAKLlw/hqdefault.jpg",
            articleUrl = "https://kotlinlang.org/docs/properties.html#getters-and-setters"
        ),
        CommonQuestionsModel(
            title = "What are Kotlin Flows?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=QVMs3t4JQxU",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/QVMs3t4JQxU/hqdefault.jpg",
            articleUrl = "https://developer.android.com/kotlin/flow"
        ),
        CommonQuestionsModel(
            title = "What are coroutines in Kotlin?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=BOHK_w09pVA",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/BOHK_w09pVA/hqdefault.jpg",
            articleUrl = "https://kotlinlang.org/docs/coroutines-basics.html"
        ),
        CommonQuestionsModel(
            title = "What is recycler view in Kotlin Jetpack Compose?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=jTLZXzJdS2E",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/jTLZXzJdS2E/hqdefault.jpg",
            articleUrl = "https://developer.android.com/jetpack/compose/lists"
        ),
        CommonQuestionsModel(
            title = "What are activities, fragments and services in Android?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=fr9a8xJbPkw",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/fr9a8xJbPkw/hqdefault.jpg",
            articleUrl = "https://developer.android.com/guide/components/activities/intro-activities"
        ),
        CommonQuestionsModel(
            title = "How is data synced in background?",
            youtubeVideoUrl = "https://www.youtube.com/watch?v=QCLhQH0Rz2E",
            youtubeThumbnailUrl = "https://img.youtube.com/vi/QCLhQH0Rz2E/hqdefault.jpg",
            articleUrl = "https://developer.android.com/topic/performance/background-optimization"
        ),
        CommonQuestionsModel(
            title = "What are the different types of onclick intents in android",
            youtubeVideoUrl = "",
            youtubeThumbnailUrl = "",
            articleUrl = ""
        ),
        CommonQuestionsModel(
            title = "How does dark theme and light theme work in compose",
            youtubeVideoUrl = "",
            youtubeThumbnailUrl = "",
            articleUrl = ""
        ),
        CommonQuestionsModel(
            title = "Different activities and their relation in android?",
            youtubeVideoUrl = "",
            youtubeThumbnailUrl = "",
            articleUrl = ""
        ),
        CommonQuestionsModel(
            title = "Lifecycle of android app",
            youtubeVideoUrl = "",
            youtubeThumbnailUrl = "",
            articleUrl = ""
        ),
        CommonQuestionsModel(
            title = "Single top, Top types of activities",
            youtubeVideoUrl = "",
            youtubeThumbnailUrl = "",
            articleUrl = ""
        ),

    )
}