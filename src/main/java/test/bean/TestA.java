package test.bean;

public class TestA {
    private TestB testB;

    public TestA(){}

    public TestA(TestB testB) {
        this.testB = testB;
    }

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }

    public void a() {
        this.testB.b();
    }
}
