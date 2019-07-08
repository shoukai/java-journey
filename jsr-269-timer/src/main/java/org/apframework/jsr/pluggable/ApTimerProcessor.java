package org.apframework.jsr.pluggable;

import com.sun.source.util.Trees;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeTranslator;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/7/8 14:48
 */
@SupportedAnnotationTypes("org.apframework.jsr.pluggable.ApTimer")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ApTimerProcessor extends AbstractProcessor {

    private Trees trees;
    private TreeTranslator visitor;

    @Override
    public void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        trees = Trees.instance(processingEnvironment);
        visitor = new ApTimerTranslator(((JavacProcessingEnvironment) processingEnvironment).getContext());
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            Set<? extends Element> elements = roundEnv.getRootElements();
            elements.forEach(element -> {
                JCTree tree = (JCTree) trees.getTree(element);
                tree.accept(visitor);
            });
        }
        return true;
    }
}
