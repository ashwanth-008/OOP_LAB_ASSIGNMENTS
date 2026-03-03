abstract class ProjectBase {

    void debug() {
        System.out.println("Debugging information displayed.");
    }
    abstract void showDetails();  // abstract method (forces subclasses to implement)
}

class ModuleA extends ProjectBase {

    void showDetails() {
        System.out.println("Module A implemented.");
    }
}

class ModuleB extends ProjectBase {

    void showDetails() {
        System.out.println("Module B implemented.");
    }
}

class TestProject {
    public static void main(String[] args) {

        ModuleA a = new ModuleA();
        ModuleB b = new ModuleB();

        a.showDetails();
        a.debug();   // common debugging method

        System.out.println();

        b.showDetails();
        b.debug();   
    }
}