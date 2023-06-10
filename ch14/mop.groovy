
// mop in class
// class Person {
//     def work() {
//         println "working"
//     }

//     def plays = ['Tennis', 'VolleyBall', 'BasketBall']

//     def methodMissing(String name, args) {
//         System.out.println "methodMissing called of $name"

//         if (!name.startsWith('play')) {
//             return
//         }
    
//         def p = name.split('play')[1]
//         def methodInList = plays.find {it == p}

//         if (methodInList) {

//             def impl = { Object[] vargs -> 
//                 println "playing ${p}..."
//             }

//             Person instance = this
//             instance.metaClass."$name" = impl

//             impl(args)
            
//         } else {
//             throw new MissingMethodException(name, Person.class, args)
//         }
        
//     }   
// }

// jack = new Person()
// jack.work()
// jack.playTennis()
// jack.playTennis()
// jack.playVolleyBall()

// jack.playBadminton()

// mop with ExpandoMetaClass
// class Person {}

// def emc = new ExpandoMetaClass(Person)
// emc.methodMissing = {String name, args -> 
//     println "call $name"
// }
// emc.initialize()

// def jack = new Person()
// jack.metaClass = emc

// jack.walk()
// jack.dance()

class Person {
    def work() {
        println "working..."
    }
}

Person.metaClass.invokeMethod = {String name, args ->
    println "intercepting call for ${name}"

    def method = Person.metaClass.getMetaMethod(name, args)
    if (method) {
        method.invoke(delegate, args)
    } else {
        Person.metaClass.invokeMissingMethod(delegate, name, args)
    }
}

Person.metaClass.methodMissing = {String name, args ->
    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    println "methodMissing called for $name"

    if (name.startsWith('play')) {
        println "will implement $name"
    } else {
        throw new MissingMethodException(name, Person.class, args)
    }
}

jack = new Person()
jack.work()
jack.playTennis()
jack.dance()