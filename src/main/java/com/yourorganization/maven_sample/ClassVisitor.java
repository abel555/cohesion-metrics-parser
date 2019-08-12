package com.yourorganization.maven_sample;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ClassVisitor extends VoidVisitorAdapter {
    @Override
    public void visit(final ClassOrInterfaceDeclaration c, Object Arg){
        MethodVIsitor methodVIsitor = new MethodVIsitor();
        System.out.println(c.getName() + " tiene estos parametros: ");
        System.out.println(c.getFields());
        c.accept(methodVIsitor, null);
        super.visit(c,Arg);
    }
}
