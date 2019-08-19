package com.yourorganization.maven_sample;

import com.github.javaparser.ast.stmt.SwitchEntry;

import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class ClassInfo {
    public String name;
    public float methodsNumber;
    public float methodParametersSum;
    public Set<com.github.javaparser.ast.type.Type> set1 = new HashSet<com.github.javaparser.ast.type.Type>();

    public ClassInfo(){
        this.methodsNumber = 0;
        this.methodParametersSum = 1;
    }
    public float getCohesion(){
        return methodParametersSum / (methodsNumber * (set1.size()+1));
    }

}
