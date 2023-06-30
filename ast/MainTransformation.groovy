import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.ast.AnnotationNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.ClassNode
import static groovyjarjarasm.asm.Opcodes.*
import static org.codehaus.groovy.ast.ClassHelper.VOID_TYPE
import static org.codehaus.groovy.ast.tools.GeneralUtils.*
import org.codehaus.groovy.control.*
import static org.codehaus.groovy.ast.ClassHelper.STRING_TYPE
import org.codehaus.groovy.ast.Parameter

@GroovyASTTransformation
class MainTransformation implements ASTTransformation {

    @Override
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
        //perform checks
        if (astNodes?.size() != 2) return
        if (!(astNodes[0] instanceof AnnotationNode)) return
        if (astNodes[0].classNode.name != Main.name) return
        if (!(astNodes[1] instanceof MethodNode)) return
    
        //construct appropriate main method
        def targetMethod = astNodes[1]
        def targetClass = targetMethod.declaringClass
        def targetInstance = ctorX(targetClass)
        def callTarget = callX(targetInstance, targetMethod.name)
        def mainBody = block(stmt(callTarget))
        def visibility = ACC_STATIC | ACC_PUBLIC
        def parameter = new Parameter(STRING_TYPE.makeArray(), "args")
        def parameters = new Parameter[]{parameter}
        //add main method to class
        targetClass.addMethod('main', visibility, VOID_TYPE, parameters, ClassNode.EMPTY_ARRAY, mainBody)
    }
}