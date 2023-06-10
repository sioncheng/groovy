str = 'hello'
println str
println str.dump()

list = [1,2]
list.with {
    add(3)
    add(4)
    println size()
    println contains(2)
}

class Car {
    int miles, fuelLevel
}

car = new Car(fuelLevel: 80, miles: 25)

carProps = ['miles', 'fuelLevel']
carProps.each {p -> 
    println "$p = ${car[p]}"
}

class Person {
    def walk() {
        println "Walking..."
    }

    def walk(int miles) {
        println "Walking $miles miles..."
    }

    def walk(int miles, String where) {
        println "Walking $miles miles $where..."
    }
}

peter = new Person()
peter.invokeMethod("walk", null)
peter.invokeMethod("walk", 10)
peter.invokeMethod("walk", [2, 'uphill'] as Object[])


def i = 10
println i.next()

def a = 'a'
println a.next()

new File("./gdk.groovy").eachLine { line ->
    println line
}