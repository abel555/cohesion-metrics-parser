package com.yourorganization.maven_sample;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class MethodVIsitor extends VoidVisitorAdapter {

    @Override
    public void visit(final MethodDeclaration n, Object arg ) {
        //System.out.println(n.get);
        System.out.println(n.getParameters());
        //arg.add(n);
        super.visit(n, arg);
    }

}
