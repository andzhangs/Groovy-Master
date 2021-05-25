package script.j2g


class AGroovyClass {
    def useClosure(closure){
        println("Call closure")
        closure()
    }

    def passToClosure(int value,closure){
        println("Simply passing $value to the given closure")
        closure(value)
    }
}
