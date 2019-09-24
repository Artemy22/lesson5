/*
"4. Correct nine classes: Worker (employee), Clerk (clerk), IT (IT specialist), Programmer (programmer), ProjectManager (project manager), CTO (CTO), HR (recruiter), OfficeManager (office manager), Cleaner (cleaner).
Inherit a programmer, project manager and technical director from an IT specialist.
Inherit the recruiter, cleaner and office manager from the clerk.
Inherit the clerk and IT professional from the employee.
*/
public class Lesson54 {
    public static void main(String[] args) {
    }

    class Worker {

    }

    class Clerk extends Worker {

    }

    class IT extends Worker {

    }

    public class Programmer extends IT {

    }

    public class ProjectManager extends IT {

    }

    public class CTO extends IT {

    }

    public class OfficeManager extends Clerk {

    }

    public class HR extends Clerk {

    }

    public class Cleaner extends Clerk {

    }
}