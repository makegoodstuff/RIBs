package native.LoggedOut

expect fun testFunc(): String

fun createApplicationScreenMessage() : String {
    return "Kotlin Rocks on ${testFunc()}"
}

interface NativePresenterDependency {

}

interface LoggedOutDependency {
    val text: String
    fun change(text: String)
}

fun builderConstructorMethod(argument: LoggedOutDependency): String {
    return createApplicationScreenMessage()
}