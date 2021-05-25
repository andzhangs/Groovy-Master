package dsl

def large = 'large'
def thin = 'thin'
def Olives = 'Olives'
def Online = 'Online'
def Bell_Pepper = 'Bell_Pepper'

orderInfo = [:]

def methodMissing(String name, args) {
    orderInfo[name] = args
}

def acceptOrder(closure) {
    closure.delegate = this
    closure()
    println("Validation adn proccessing performed here for order received:")
    orderInfo.each { key, value ->
        println("$key -> ${value.join(', ')}")
    }
}


