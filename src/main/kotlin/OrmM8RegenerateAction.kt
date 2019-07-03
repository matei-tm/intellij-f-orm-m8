import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.ui.Messages

class OrmM8RegenerateAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.getData(PlatformDataKeys.PROJECT)
        val acceptRegeneration =
            Messages.showOkCancelDialog(
                project,
                "Confirmation",
                "The f-orm-m8 scaffolds will be regenerated. Are you sure?",
                "OK",
                "Cancel",
                Messages.getQuestionIcon()
            )

        val dialogAnswer = if (acceptRegeneration == Messages.OK) "OK" else "Cancel"
        Messages.showMessageDialog(
            project,
            "The answer was $dialogAnswer!\n.",
            "Information",
            Messages.getInformationIcon()
        )
        val notificationGroup = NotificationGroup(
            "fOrmM8Generator",
            NotificationDisplayType.BALLOON,
            true
        )
        notificationGroup.createNotification(
            "M8 Title",
            "M8 Regeneration started",
            NotificationType.INFORMATION,
            null
        ).notify(e.project)
    }
}