import kotlinx.cinterop.ExportObjCClass
import kotlinx.cinterop.ObjCObjectBase.OverrideInit
import kotlinx.cinterop.ObjCOutlet
import kotlinx.cinterop.*
import platform.Foundation.*
import platform.UIKit.*
import platform.CoreGraphics.*

@ExportObjCClass
class JustinViewController: UIViewController {
    @OverrideInit
    constructor(coder: NSCoder): super(coder)

    @ObjCOutlet
    lateinit var stackView: UIStackView

    var firstLabel = UILabel()
    var secondLabel = UILabel()
    var thirdLabel = UILabel()
    var submitButton = UIButton()

    override fun viewDidLoad() {
        super.viewDidLoad()
        setupSubviews()
        setupLayout()
    }

    private fun setupSubviews() {
        firstLabel.text = "Welcome to Justin, a Kotlin Native experiment"
        firstLabel.textAlignment = 0

        secondLabel.text = "So far this app is the opposite of good"
        secondLabel.textAlignment = 2

        thirdLabel.text = "But on the bright side, now I'm so evolved I don't even *see* platform"
        thirdLabel.textAlignment = 1
        thirdLabel.numberOfLines = 0

        submitButton.setTitle("SUBMIT", 0)
        submitButton.setTitleColor(UIColor.redColor, 0)
        submitButton.backgroundColor = UIColor.greenColor

        stackView.addArrangedSubview(firstLabel)
        stackView.addArrangedSubview(secondLabel)
        stackView.addArrangedSubview(thirdLabel)
        stackView.addArrangedSubview(submitButton)
    }

    private fun setupLayout() {
        submitButton.sizeToFit()
    }
}
