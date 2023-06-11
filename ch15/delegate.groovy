
class Worker {

    def simpleWork1(spec) {
        println "worker does work1 with spec $spec"
    }

    def simpleWork2() {
        println "worker does work2"
    }

}

class Expert {
    def advanceWork1(spec) {
        println "Exper does work1 with spec $spec"
    }
    def advanceWork2(scope, spec) {
        println "Exper does work2 with spcoe $scope spec $spec"
    }
}

class Manager {
    def worker = new Worker()
    def exper = new Expert()

    def schedule() {
        println "Scheduling..."
    }

    def methodMissing(String name, args) {
        println "intercepting call to $name..."
        def deletageTo = null

        if (name.startsWith('simple')) {
            deletageTo = worker
        } else if (name.startsWith('advance')) {
            deletageTo = expert
        } else {
            throw new MissingMethodException(name, Manager.class, args)
        }

        if (deletageTo.metaClass.respondsTo(deletageTo, name, args)) {
            Manager instance = this
            instance.metaClass."${name}" = {Object[] vargs -> 
                deletageTo.invokeMethod(name, vargs)
            }
            deletageTo.invokeMethod(name, args)
        } else {
            throw new MissingMethodException(name, Manager.class, args)
        }
    }
}

peter = new Manager()
peter.schedule()
peter.simpleWork1('fast')
peter.simpleWork1('very fast')
peter.advanceWork1('fast')
peter.advanceWork2('product', 'quality')

peter.hello()