
class Pretender {

    def methodMissing(String name, Object args) {
        "called $name with $args"
    }
}

def bounce = new Pretender()
def h = bounce.hello('world') 
// println h
assert h == 'called hello with [world]'
