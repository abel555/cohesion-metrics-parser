package com.yourorganization.maven_sample;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithStatements;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.HashSet;
import java.util.Set;

public class MethodVIsitor extends VoidVisitorAdapter<ClassInfo> {

    @Override
    public void visit(final MethodDeclaration n, ClassInfo info ) {

        NodeList<Parameter> parameters = n.getParameters();
        Set<com.github.javaparser.ast.type.Type> distinctMethodsParams = new HashSet<com.github.javaparser.ast.type.Type>();
        for (Parameter par:parameters) {
            info.set1.add(par.getType());
            distinctMethodsParams.add(par.getType());
        }
        info.methodParametersSum = info.methodParametersSum + distinctMethodsParams.size();
        super.visit(n, info);
    }

}
