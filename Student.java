public class Student {
    String name,stuNo;
    int classes;
    Course calculus;
    Course physics;
    Course programming;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course calculus,Course physics,Course programming) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.calculus = calculus;
        this.physics = physics;
        this.programming = programming;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int calculus, int physics, int programming) {

        if (calculus >= 0 && calculus <= 100) {
            this.calculus.note = calculus;
        }

        if (physics >= 0 && physics <= 100) {
            this.physics.note = physics;
        }

        if (programming >= 0 && programming <= 100) {
            this.programming.note = programming;
        }

    }

    public void isPass() {
        if (this.calculus.note == 0 || this.physics.note == 0 || this.programming.note == 0) {
            System.out.println("Notes not entered exactly !");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Average : " + this.avarage);
            if (this.isPass) {
                System.out.println("Passed the class. ");
            } else {
                System.out.println("Remained the class.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = (this.calculus.note + this.physics.note + this.programming.note) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Student : " + this.name);
        System.out.println("Calculus Note : " + this.calculus.note);
        System.out.println("Physics Note : " + this.physics.note);
        System.out.println("Programming Note : " + this.programming.note);
    }

}


