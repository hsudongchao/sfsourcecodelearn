package test.bean;

public class TestC {
    private TestA testA;
    public TestC(){}

    public TestC(TestA testA) {
        this.testA = testA;
    }

    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }

    public void c() {
        this.testA.a();
    }
}
