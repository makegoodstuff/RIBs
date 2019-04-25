import kotlinx.cinterop.*
import platform.UIKit.*
import kotlinx.cinterop.ObjCObjectBase.OverrideInit

class AppDelegate: UIResponder, UIApplicationDelegateProtocol {
    companion object: UIResponderMeta(), UIApplicationDelegateProtocolMeta {}

    @OverrideInit constructor(): super()

    private var _window: UIWindow? = null
    override fun window() = _window

    override fun setWindow(window: UIWindow?) {
        _window = window
    }
}
