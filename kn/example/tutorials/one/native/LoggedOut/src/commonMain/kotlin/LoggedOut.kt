package native.LoggedOut

expect fun testFunc(): String

fun createApplicationScreenMessage() : String {
    return "Kotlin Rocks on ${testFunc()}"
}