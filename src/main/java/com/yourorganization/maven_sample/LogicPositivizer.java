package com.yourorganization.maven_sample;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.utils.CodeGenerationUtils;
import com.github.javaparser.utils.SourceRoot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Some code that uses JavaParser.
 */
public class LogicPositivizer {
    public static void main(String[] args) throws IOException {

        File[] directories = new File("E:\\java projects").listFiles(File::isDirectory);
        for (File file:directories
             ) {
            FolderParser folderParser = new FolderParser(file.toPath());
            folderParser.getAllJavaFiles();
            folderParser.createCus();
        }


        /*
        FolderParser folderParser = new FolderParser(Paths.get("E:\\Refactor-tests"));
        folderParser.getAllJavaFiles();
        folderParser.createCus();


         */
        /*
        Set<String> set1 = new HashSet<String>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        Set<String> set2 = new HashSet<String>();
        set1.add("a");
        set1.add("d");
        set1.add("e");

        Set<String> result = new HashSet<>(set1);
        result.addAll(set2);
        System.out.println(set1);*/
    }


}
