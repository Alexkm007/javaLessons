package StructuralPatterns.bridge;

public class CppDeveloper implements Developer{
    @Override
    public void writeCode() {
        System.out.println("C++ developer write c++ code");
    }
}
