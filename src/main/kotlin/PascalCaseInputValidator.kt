import com.intellij.openapi.ui.InputValidator

class PascalCaseInputValidator : InputValidator {
    override fun canClose(inputString: String?): Boolean {
        if (inputString == null) return false
        if (inputString.length == 1) return false
        return true
    }

    override fun checkInput(inputString: String?): Boolean {
        val regex = """^[A-Z][a-z]+(?:[A-Z][a-z]+)*${'$'}""".toRegex()
        if (inputString == null) return false

        if (regex matches inputString) {
            return true
        }
        return false
    }
}