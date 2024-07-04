package publiccode.designpattern.template_method;

public class TemplateMethod {
    public static void main(String[] args) {
        Human fireman = new Fireman();
        Human policeOfficer = new PoliceOfficer();

        System.out.println("소방관:");
        fireman.work();

        System.out.println("\n경찰관:");
        policeOfficer.work();
    }
}

abstract class Human {
    //template method
    //오버라이딩을 막기 위한 final.
    final void work() {
        goToWork();
        doWork();
        if (needOvertimeWork()) {
            doOvertimeWork();
        }
        leaveWork();
    }

    private void goToWork() {
        System.out.println("출근을 한다.");
    }

    protected abstract void doWork();

    //hook method
    protected boolean needOvertimeWork() {
        return false;
    }

    private void doOvertimeWork() {
        System.out.println("야근을 한다.");
    }

    private void leaveWork() {
        System.out.println("퇴근을 한다.");
    }
}

class Fireman extends Human {
    @Override
    protected void doWork() {
        System.out.println("불을 끈다.");
    }
}

class PoliceOfficer extends Human {
    @Override
    protected void doWork() {
        System.out.println("사건을 해결한다.");
    }

    @Override
    protected boolean needOvertimeWork() {
        return true;
    }
}
