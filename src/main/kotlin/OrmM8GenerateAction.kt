import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.ui.Messages

//import io.flutter

class OrmM8GenerateAction: AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.getData(PlatformDataKeys.PROJECT)
        val modelName = Messages.showInputDialog(project, "Enter model name in pascalCase", "New Independent model", Messages.getQuestionIcon())
        Messages.showMessageDialog(project, "Hello, $modelName!\n I am glad to see you.", "Information", Messages.getInformationIcon())
        val notificationGroup = NotificationGroup("fOrmM8Generator", NotificationDisplayType.BALLOON, true)
        notificationGroup.createNotification("M8 Title",
            "M8 Message",
            NotificationType.INFORMATION,
            null
        ).notify(e.project)
    }
}

