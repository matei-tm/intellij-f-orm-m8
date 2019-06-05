import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationType

class OrmM8GenerateAction: AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val noti = NotificationGroup("fOrmM8Generator", NotificationDisplayType.BALLOON, true)
        noti.createNotification("M8 Title",
            "M8 Message",
            NotificationType.INFORMATION,
            null
        ).notify(e.project)
    }
}