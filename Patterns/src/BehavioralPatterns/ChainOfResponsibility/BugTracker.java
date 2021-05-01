package BehavioralPatterns.ChainOfResponsibility;

public class BugTracker {
    public static void main(String[] args) {
        Notifier reporter = new SimpleReportNotifier(Priority.ROUTINE);
        Notifier emailReport = new EmailNotifier(Priority.IMPORTANT);
        Notifier smsReport = new SMSNotifier(Priority.ASAP);

        reporter.setNextNotifier(emailReport);
        emailReport.setNextNotifier(smsReport);

        reporter.notifyManager("All is OK",Priority.ROUTINE);
        reporter.notifyManager("Something went wrong",Priority.IMPORTANT);
        reporter.notifyManager("All is bad!!!", Priority.ASAP);
    }
}
