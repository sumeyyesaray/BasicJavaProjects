public class TeacherMain {
    public static void main(String[] args) {
        Course calculus = new Course("CALCULUS" , "CALC101" , "CALC");
        Course physics = new Course("PHYSİCS","PHYSC101", "PHYSC");
        Course programming = new Course("PROGRAMMİNG" , "PRGRM101" , "PRGR");

        Teacher t1 = new Teacher("Ömer" , "Calculus" , "208");
        Teacher t2 = new Teacher("Cahit" , "Pysc" , "209");
        Teacher t3 = new Teacher("Barış" , "Programming" , "210");

        calculus.addTeacher(t1);
        physics.addTeacher(t2);
        programming.addTeacher(t3);

        Student s1 = new Student("Sümeyye" , 2 , "220709070" , calculus , physics , programming);
        s1.addBulkExamNote(80,90,10);
        s1.isPass();

        Student s2 = new Student("Yaren" , 2 , "220705080" , calculus , physics , programming);
        s2.addBulkExamNote(85,90,80);
        s2.isPass();

        Student s3 = new Student("Berra" , 2, "220709506" , calculus , physics , programming);
        s3.addBulkExamNote(100,95,80);
        s3.isPass();

    }
}
