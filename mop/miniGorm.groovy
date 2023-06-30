
class MiniGorm {

    def db = []

    def methodMissing(String name, Object args) {
        db.find { it[name.toLowerCase() - 'findby'] == args[0] }
    }
}

def people = new MiniGorm()
def dierk = [first: 'Dierk', last: 'Koenig']
def paul = [first: 'Paul', last: 'King']
people.db << dierk << paul

assert people.findByFirst('Dierk') == dierk
assert people.findByFirst('Paul') == paul