

new GroovyShell(getClass().classLoader).evaluate '''
class Greeter {
    @Main
    def greet() {
        println "Hello from the greet() method!"
    }
}
'''