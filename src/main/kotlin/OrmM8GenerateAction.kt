import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages

//import io.flutter

class OrmM8GenerateAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.getData(PlatformDataKeys.PROJECT)

        val independentModels = inputNewModels(
            project,
            "DbEntity: Input your INDEPENDENT model name in PascalCase.",
            "New Independent model"
        )

        val accountRelatedModels = inputNewModels(
            project,
            "DbAccountRelatedEntity: Input your ACCOUNT RELATED model name in PascalCase.",
            "New Account related model"
        )

        val indieModelsString = independentModels.joinToString(",")
        val accountRelatedModelsString = accountRelatedModels.joinToString(",")

        val notificationGroup = NotificationGroup("fOrmM8Generator", NotificationDisplayType.BALLOON, true)
        notificationGroup.createNotification(
            "M8 Need Help to implement these",
            "<b>Independent models:</b> $indieModelsString <br><b>Account related models:</b> $accountRelatedModelsString \n",
            NotificationType.INFORMATION,
            null
        ).notify(e.project)
    }

    private fun inputNewModels(project: Project?, message: String, title: String): MutableList<String> {
        val modelsList = mutableListOf<String>()
        var modelName: String?
        do {
            val inputValidator = PascalCaseInputValidator()
            modelName = Messages.showInputDialog(
                project,
                message,
                title,
                Messages.getQuestionIcon(),
                null,
                inputValidator

            )
            if (modelName != null) {
                modelsList.add(modelName)
            }
        } while (modelName != null)

        return modelsList
    }
}

