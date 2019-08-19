package com.yourorganization.maven_sample;

import com.github.javaparser.JavaParser;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.utils.SourceRoot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FolderParser {
    Path root;
    List<String> filesList;
    private static final String UTF_8 = "utf-8";
    public FolderParser(Path root){
        this.root = root;
        filesList = new ArrayList<>();
    }

    public void getAllJavaFiles(){
        try (Stream<Path> walk = Files.walk(root)) {

            filesList = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith(".java")).collect(Collectors.toList());

            filesList.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createCus(){
        for (String path:filesList) {
            ClassInfo result = new ClassInfo();
            try(FileInputStream in = new FileInputStream(path)){
                CompilationUnit cu;
                try {

                    cu = StaticJavaParser.parse(in, Charset.forName(UTF_8));
                    ClassVisitor classVIsitor = new ClassVisitor();
                    cu.accept(classVIsitor, result);

                } catch (Error e) {
                    System.out.println(String.format("Critical Javaparser error while processing the file %s.", path));
                }

            } catch (Exception e) {
                // We can ignore small errors here
                System.out.println(String.format("Error while processing the file %s.", path));
            }
            System.out.println("la cohesion es de la clase " + result.name + " es: "  + result.getCohesion());

        }

    }

}
